import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500; 
    Image image;
    Image background;
    Timer timer;
    int xVelocity = 100;
    int yVelocity = 100;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
<<<<<<< HEAD
        image = new ImageIcon("\Users\abhir\New folder\finalProjectAPCS\finalProjectAPCS\Media\Garfield\lasagna.png").getImage();
=======
        image = new ImageIcon("/Users/justinim/Desktop/AP Comp Sci/finalProjectAPCS/PacManGame/src/lasagna.png").getImage();
>>>>>>> 319722964a75b516f5cac28f72f8e0bdac969514
        timer = new Timer(1000, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        x = x + xVelocity;
        repaint();
    }
}
