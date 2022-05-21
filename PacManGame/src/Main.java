import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
//test
public class Main extends JPanel {
     private JLabel myLabel;
     private static JPanel panel;
     private JButton startButton;

    public static Image[] imgs = new Image[3];
   

    
    
    public static void main(String args[]) throws IOException {
        //Setting JFrame
        JFrame frame= new JFrame("PacMan by AP, AV, JI, HN");   
        frame.setSize(800,800);            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        // //Setting background
		JPanel backgroundPanel=new JPanel();  
        backgroundPanel.setBounds(0, 0, 800, 800);
		backgroundPanel.setLayout(new FlowLayout());      
		BufferedImage myPicture = ImageIO.read(new File("/Users/justinim/Desktop/AP Comp Sci/finalProjectAPCS copy/Media/pacManBoard.png"));
        Image dimg = myPicture.getScaledInstance(800, 800,Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(dimg));
		backgroundPanel.add(picLabel);
		frame.add(backgroundPanel);

        Player p = new Player("pacman", imgs, 30, 30, 100, 100);
//make a player jpanel
        frame.add(picLabel);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);

    }

    //for testing
	// protected void paintComponent(Graphics g) {
    //     ImageIcon imageIcon = new ImageIcon("/Users/justinim/Desktop/AP Comp Sci/finalProjectAPCS copy/Media/Garfield/Garf/garfieldL0.png");
    //     Image img = imageIcon.getImage();
    //     super.paintComponent(g);
    //         g.drawImage(img, (int)p.getX(), (int)p.getY(), 30, 30, null);
	// }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("/Users/justinim/Desktop/AP Comp Sci/finalProjectAPCS copy/Media/Garfield/Garf/garfieldL0.png");
        Image img = imageIcon.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 100, 100, null);
    }






    /* public MainPacMan() throws IOException {
        //Setting JFrame
        JFrame frame= new JFrame("PacMan by AP, AV, JI, HN");   
        frame.setSize(1000,1000);            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //Setting background
		JPanel backgroundPanel=new JPanel();  
        backgroundPanel.setBounds(0, 0, 800, 800);
		backgroundPanel.setLayout(new FlowLayout());      
		BufferedImage myPicture = ImageIO.read(new File("/Users/aarya/Desktop/AP_CompSci_FinalProject/untitled folder/finalProjectAPCS/Media/pacManBoard.png"));
        Image dimg = myPicture.getScaledInstance(800, 800,Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(dimg));
		backgroundPanel.add(picLabel);
		frame.add(backgroundPanel);
        //Setting start button
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBounds(0, 800, 800, 100);
        ImageIcon startImage = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/untitled folder/finalProjectAPCS/Media/startButton.jpg");
        startButton = new JButton();
        startButton.setBounds(0, 800, 800, 100);
        startButton.addActionListener(this);
        startButton.setText("START");
        startButton.setIcon(startImage);
        startButton.setHorizontalTextPosition(JButton.CENTER);
        startButton.setVerticalTextPosition(JButton.BOTTOM);
        startButton.setFocusable(false);
        frame.setVisible(true); 
        startButtonPanel.add(startButton);
        frame.add(startButtonPanel);

        //Setting animation based on user input
        JFrame temp = new JFrame();
        animationBasedOnInput playerAnimation = new animationBasedOnInput();
        frame.add(playerAnimation);
        temp.add(playerAnimation);
        temp.setVisible(true);
        temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temp.setSize(800,800);

    }*/
}