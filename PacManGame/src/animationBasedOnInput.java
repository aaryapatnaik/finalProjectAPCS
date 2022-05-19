import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class animationBasedOnInput extends JPanel implements KeyListener, ActionListener {
    Timer timer = new Timer(5, this);
    int xPos = 0;
    int yPos = 0;
    int xVel = 1;
    int yVel = 1;
    Image animationImage;

    public animationBasedOnInput() {
        this.setPreferredSize(new Dimension(840, 840));
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        animationImage = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/working/finalProjectAPCS/Media/Garfield/Garf/garfieldL0.png").getImage();
        timer = new Timer(1000, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.fill(new Ellipse2D.Double(xPos,yPos,40,40));
    }

    public void up(){
        yVel -= 1;
        xVel = 0;
    }
    public void down(){
        yVel = 1;
        xVel = 0;
    }
    public void left(){
        xVel -= 1;
        yVel = 0;
    }
    public void right(){
        xVel += 1;
        yVel = 0;
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        xPos += xVel;
        yPos += yVel;
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyVal = e.getKeyCode();
        if (keyVal == KeyEvent.VK_UP) {
            up();
        }
        if (keyVal == KeyEvent.VK_DOWN) {
            down();
        }
        if (keyVal == KeyEvent.VK_LEFT) {
            left();
        }
        if (keyVal == KeyEvent.VK_RIGHT) {
            right();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
