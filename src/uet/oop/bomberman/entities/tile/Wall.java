package uet.oop.bomberman.entities.tile;


import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.enemy.Ovape;
import uet.oop.bomberman.graphics.Sprite;

public class Wall extends Tile {

	public Wall(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	@Override
	public boolean collide(Entity e) {
		if(e instanceof Ovape)
			return true;
		return false;
	}


}
