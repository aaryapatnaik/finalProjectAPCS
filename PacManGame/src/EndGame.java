import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EndGame {
    public EndGame(boolean userWon){
            JFrame frame = new JFrame();
            JPanel backgroundPanel=new JPanel();  
            backgroundPanel.setBounds(0, 0, 700, 700);
            backgroundPanel.setLayout(new FlowLayout());
            ImageIcon backgroundImgEnd;
            if (userWon == true) {      
                backgroundImgEnd = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/ccheck/pm.jpg");
            }
            else {
                backgroundImgEnd = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/final final/finalProjectAPCS/Media/pmWinner.jpg");
            }
            JLabel picLabel = new JLabel(backgroundImgEnd);
            backgroundPanel.add(picLabel);
            frame.add(backgroundPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(700,700));
            frame.setLocationRelativeTo(null);
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setLayout(null);
            frame.setVisible(true);
    }
}
