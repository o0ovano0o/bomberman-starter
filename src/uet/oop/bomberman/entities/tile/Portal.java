package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Sound.Test;
public class Portal extends Tile {
	Board _board;
	public Portal(int x, int y,Sprite sprite) {
		super(x, y, sprite);
	}
	public Portal(int x, int y, Sprite sprite, Board _board) {
		super(x, y, sprite);
		this._board=_board;
	}
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		if(e instanceof Bomber){
			if(_board.detectNoEnemies() == false)
				return false;

			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies())
					 Test.next().start();
					_board.nextLevel();
			}

			return true;
		}
		return false;
	}

}
