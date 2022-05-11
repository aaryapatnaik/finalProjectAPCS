import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
public class MainPacMan implements ActionListener{
    private ImageIcon lasagna;
    private JLabel myLabel;
    private JPanel panel;
    private JButton startButton;

    public MainPacMan() throws IOException {
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
    }
     
    public static void main(String args[]) throws IOException
    {
        new MainPacMan();
        /*
        JPanel rpanel = new JPanel();
        rpanel.setBackground(Color.red);
        rpanel.setBounds(0,0,250,250);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.add(rpanel);
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==startButton) {
            System.out.print("clicked");
        }
    }
}
