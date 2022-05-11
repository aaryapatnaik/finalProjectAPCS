import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
<<<<<<< HEAD
public class MainPacMan {
=======
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class MainPacMan{
>>>>>>> ba9ea19770a9e96f07e73a89dc0140748131ab7c
    private JFrame frame;
    private ImageIcon lasagna;
    private JLabel myLabel;
    private JPanel panel;
    public MainPacMan() {
        //Lasagna
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/Users/aarya/Desktop/AP_CompSci_FinalProject/finalProjectAPCS/PacManGame/src/lasagna.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(600, 400,Image.SCALE_SMOOTH);
        ImageIcon lasagna = new ImageIcon(dimg);
        myLabel = new JLabel(lasagna);
        
        //Actual frame
        JFrame frame = new JFrame("PacMan Game by AP, AV, JI, HN");
        frame.add(myLabel);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String args[]) throws InterruptedException
    {
        new MainPacMan();
    }

}
