package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class AIHigh extends AI{
    Bomber _bomber;
    Enemy _e;
    ArrayList<Bomb> _bombs;
    public AIHigh(Bomber bomber, Enemy e, Board board) {
        _bomber = bomber;
        _e = e;
        _bombs= (ArrayList<Bomb>) board.getBombs();
    }
    @Override
    public int calculateDirection() {
        int rd=random.nextInt(2),t,a,b;
        for( int i=0;i<_bombs.size();i++){
            a= (int) (_bombs.get(i).getX()-_e.getX());
            b= (int) (_bombs.get(i).getY()-_e.getY());
            if(a<100&&a>0) return 1;
            else if(a>-100&&a<0) return 3;
            else if(b<100&&b>0) return 0;
            else if(b>-100&&b<0) return 2;
            System.out.println(a +" "+b);
        }
        if(rd==0) {
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
