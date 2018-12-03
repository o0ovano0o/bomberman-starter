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

        for( int i=0;i<_bombs.size();i++){
            a = _e.getXTile() - _bombs.get(i).getX();
            b = _e.getYTile() - _bombs.get(i).getY();
            System.out.println(_e.getXTile()+" "+_bombs.get(i).getX());
                if (a < kc && a >= 0) return 3;
                else if (a > -kc && a <= 0) return 1;
                else  if (b < kc && b >= 0) return 2;
                else if (b > -kc && b <= 0) return 0;
        }
        if(rd==0||rd==1) {
            if (_bomber.getX() - _e.getX() > 0)
                return 3;
            else
                return 1;
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
