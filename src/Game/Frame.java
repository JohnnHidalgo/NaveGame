package Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener{
    Rectangulo nave;
    public Frame (Rectangulo nav) {
        nave=nav;
        addKeyListener((KeyListener) this);
    }
    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode() == 37) {
            nave.setX(nave.getX()-10);

        }
        else if(event.getKeyCode() == 39) {
            nave.setX(nave.getX()+10);

        }
        else if(event.getKeyCode()== 38) {
            nave.setY(nave.getY()-10);

        }
        else if(event.getKeyCode() == 40) {
            nave.setY(nave.getY()+10);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
