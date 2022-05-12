import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class MyPanel extends JPanel implements ActionListener {
    final int panelWidth = 500;
    final int panelHeight = 500;
    Image garfield; 
    Image background;
    Timer timer;
    int xVelocity = 10;
    int yVelocity = 10;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.WHITE);
        garfield = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/untitled folder/finalProjectAPCS/Media/Garfield/lasagna.png").getImage();
        timer = new Timer(1000, null);
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(garfield, x, y, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String key = "";
        key += e.getKeyChar();
        if (key.equals("d")) {
            x += xVelocity;
            repaint();
        }
    }
}
