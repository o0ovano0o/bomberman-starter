package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.Sound.Test;
import uet.oop.bomberman.gui.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JMenu{
    public Frame frame;

    public Game(Frame frame) {
        super("Game");
        this.frame = frame;
        JMenuItem pause = new JMenuItem("Pause");
        pause.setMnemonic(KeyEvent.VK_P);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.pause();
            }
        });
        add(pause);
    }
}
