package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;
import uet.oop.bomberman.level.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class AI_Kodonria extends AI{
    Bomber _bomber;
    Enemy _e;
    ArrayList<Bomb> _bombs;
    public AI_Kodonria(Bomber bomber, Enemy e, Board board) {
        _bomber = bomber;
        _e = e;
        _bombs= (ArrayList<Bomb>) board.getBombs();
    }
    @Override
    public int calculateDirection() {
        int rd=random.nextInt(5),t,kc=5;
        double a,b;
        if(_bomber==null)
            return random.nextInt(4);
        for( int i=0;i<_bombs.size();i++){
            a = _bombs.get(i).getX()-_e.getXTile() ;
            b = _bombs.get(i).getY()-_e.getYTile();

                if (a < kc && a >= 0) return 3;
                else if (a > -kc && a <= 0) return 1;
                else  if (b < kc && b >= 0) return 0;
                else if (b > -kc && b <= 0) return 2;
        }
        if(rd==0||rd==1) {
            if (_bomber.getX() - _e.getX() > 0)
                return 1;
            else
                return 3;
        }
        else if(rd==2||rd==3) {
            if (_bomber.getY() - _e.getY() > 0)
                return 2;
            else
                return 0;
        }
        else{
            return random.nextInt(3);
        }
    }
}
