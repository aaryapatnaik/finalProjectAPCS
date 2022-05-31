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
                backgroundImgEnd = new ImageIcon("Media\\Garfield\\pmWinner2.jpg");
            }
            else {
                backgroundImgEnd = new ImageIcon("Media\\Garfield\\pmLoser2.jpg");
            }
            JLabel picLabel = new JLabel(backgroundImgEnd);
            backgroundPanel.add(picLabel);

            JPanel scorePanel = new JPanel();
              scorePanel.add(new JLabel("Score: "));
              scorePanel.setBackground(Color.yellow);
              backgroundPanel.setBounds(300, 700, 100, 50);
              frame.add(backgroundPanel);
            
            frame.add(backgroundPanel);
            frame.add(scorePanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(700,700));
            frame.setLocationRelativeTo(null);
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setLayout(null);
            frame.setVisible(true);
    }
}
