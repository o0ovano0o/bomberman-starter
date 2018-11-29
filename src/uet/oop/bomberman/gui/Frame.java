package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.Sound.Test;
import uet.oop.bomberman.gui.menu.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Frame chứa toàn bộ các component
 */
public class Frame extends JFrame {
	
	public GamePanel _gamepane;
	private JPanel _containerpane;
	private InfoPanel _infopanel;
	private JMenuBar _menu;
	private Game _game;

	public Frame() {
		_menu = new Menu(this);
		_containerpane = new JPanel(new BorderLayout());
		_gamepane = new GamePanel(this);
		_infopanel = new InfoPanel(_gamepane.getGame());
        _containerpane.add(_menu,BorderLayout.PAGE_START);
		_containerpane.add(_infopanel, BorderLayout.CENTER);
		_containerpane.add(_gamepane, BorderLayout.PAGE_END);
		_game = _gamepane.getGame();

		add(_containerpane);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);	
		
		_game.start();

	}
	
	public void setTime(int time) {
		_infopanel.setTime(time);
	}
	
	public void setPoints(int points) {
		_infopanel.setPoints(points);
	}
	public void endGame(){
		_game.getBoard().endGame();
    }
    public void pause(){
		if(_game.isPaused()){
			_game.play();
		}
		else
		{
			_game.resetScreenDelay();
			_game.pause();
			_game.getBoard().setShow(3);
		}
 	}
	
}
