package uet.oop.bomberman.entities.character.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Message;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.Character;
import uet.oop.bomberman.entities.character.enemy.ai.AI;
import uet.oop.bomberman.entities.character.enemy.ai.AILow;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.Coordinates;

import java.awt.*;
import uet.oop.bomberman.Sound.Test;
public abstract class Enemy extends Character {

	protected int _points;
	
	protected double _speed;
	protected AI _ai;

	protected final double MAX_STEPS;
	protected final double rest;
	protected double _steps;
	
	protected int _finalAnimation = 30;
	protected Sprite _deadSprite;
	
	public Enemy(int x, int y, Board board, Sprite dead, double speed, int points) {
		super(x, y, board);
		
		_points = points;
		_speed = speed;
		
		MAX_STEPS = Game.TILES_SIZE / _speed;
		rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
		_steps = MAX_STEPS;
		
		_timeAfter = 20;
		_deadSprite = dead;
	}
	
	@Override
	public void update() {
		animate();
		
		if(!_alive) {
			afterKill();
			return;
		}
		
		if(_alive)
			calculateMove();
	}
	
	@Override
	public void render(Screen screen) {
		
		if(_alive)
			chooseSprite();
		else {
			if(_timeAfter > 0) {
				_sprite = _deadSprite;
				_animate = 0;
			} else {
				_sprite = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60);
			}
				
		}
			
		screen.renderEntity((int)_x, (int)_y - _sprite.SIZE, this);
	}
	
	@Override
	public void calculateMove() {
		// TODO: Tính toán hướng đi và di chuyển Enemy theo _ai và cập nhật giá trị cho _direction
		// TODO: sử dụng canMove() để kiểm tra xem có thể di chuyển tới điểm đã tính toán hay không
		// TODO: sử dụng move() để di chuyển
		// TODO: nhớ cập nhật lại giá trị cờ _moving khi thay đổi trạng thái di chuyển
		double x=0,y=0;
		if(_steps <= 0){
			_direction = _ai.calculateDirection();
			_steps = MAX_STEPS;
		}
		if(_direction==0) y--;
		if(_direction==1) x++;
		if(_direction==2) y++;
			if(_direction==3) x--;
			if(canMove(x, y)) {
				_steps -= 1 + rest;
				move(x * _speed, y * _speed);
				_moving = true;

		} else {
			_steps = 0;
			_moving = false;
		}

	}
	
	@Override
	public void move(double xa, double ya) {
		if(!_alive) return;
		_y += ya;
		_x += xa;
	}
	
	@Override
	public boolean canMove(double x, double y) {

		double[] xa = new double[4];
		double[] ya = new double[4];
		xa[0] = (_x + x) / Game.TILES_SIZE;
		ya[0] = ((_y + y-1)) / Game.TILES_SIZE;
		xa[1] = (_x + x+ 14) / Game.TILES_SIZE;
		ya[1] = ((_y + y-14)) / Game.TILES_SIZE;
		xa[2] = ((_x + x)) / Game.TILES_SIZE;
		ya[2] = (_y + y-14) / Game.TILES_SIZE;
		xa[3] = (_x + x+14) / Game.TILES_SIZE;
		ya[3] = (_y + y-14) / Game.TILES_SIZE;
		for(int i=0;i<4;i++) {
			if(xa[i]<0||ya[i]<0||xa[i]>=13||ya[i]>=31)
				return false;
			Entity entity = _board.getEntity(xa[i], ya[i], this);
			if (!entity.collide(this))
				return false;
		}
		return true;
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý va chạm với Flame
		// TODO: xử lý va chạm với Bomber
		if(e instanceof Flame)
		{
			kill();
			return false;
		}
		if(e instanceof  Bomber){
			((Bomber) e).kill();
			return false;
		}
		return true;
	}

	@Override
	public void kill() {
		if(!_alive) return;

		_alive = false;

		_board.addPoints(_points);
		Message msg = new Message("+" + _points, getXMessage(), getYMessage(), 2, Color.white, 14);
		_board.addMessage(msg);
		int loop;
		if(this instanceof Balloon)
			loop=1;
		if(this instanceof Oneal)
			loop=2;
		else
			loop=3;
		for (int i=1 ;i<=loop;i++)
			Test.enemy().play();

	}


	@Override
	protected void afterKill() {
		if(_timeAfter > 0) --_timeAfter;
		else {
			if(_finalAnimation > 0) --_finalAnimation;
			else

				remove();

		}
	}
	
	protected abstract void chooseSprite();
}
