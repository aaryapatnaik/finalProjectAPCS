import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserInput extends JFrame implements KeyListener{
    UserInput() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        String key = "";
        key += e.getKeyChar();
        if (key.equals("w")) {
            //move up if possible
        }
        else if (key.equals("s")) {
            //move down if possible
        }
        else if (key.equals("a")) {
            //move left if possible
        }
        else if (key.equals("d")) {
            //move right if possible
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}

