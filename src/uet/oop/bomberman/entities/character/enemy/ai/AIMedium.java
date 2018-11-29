package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium extends AI {
	Bomber _bomber;
	Enemy _e;
	
	public AIMedium(Bomber bomber, Enemy e) {
		_bomber = bomber;
		_e = e;
	}

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đường đi
		int i=random.nextInt(2),t;
		if(i==0) {
			if (_bomber.getX() - _e.getX() > 0)
				return 3;
			else
				return 1;
		}
		else {
			if (_bomber.getY() - _e.getY() > 0)
				return 2;
			else
				return 0;
		}
	}

}
