import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartGame implements ActionListener{
    private JFrame frame;
    private JButton easyButton = new JButton();
    private JButton medButton = new JButton();
    private JButton hardButton = new JButton();
    private int speed = 50;
    private boolean started = false;
    public StartGame(){
        frame = new JFrame();
        JPanel backgroundPanel=new JPanel();  
        backgroundPanel.setBounds(0, 0, 700, 700);
         backgroundPanel.setLayout(new FlowLayout());      
         ImageIcon backgroundImgStart = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\pmStart.jpg");
         JLabel picLabel = new JLabel(backgroundImgStart);
         backgroundPanel.add(picLabel);

        JPanel easyPanel = new JPanel();
        easyPanel.setBounds(100, 500, 100, 100);
        ImageIcon easyImage = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\pmEasy.jpg");
        easyButton.setBounds(100, 500, 100, 100);
        easyButton.setIcon(easyImage);
        easyButton.addActionListener(this);
        easyButton.setHorizontalTextPosition(JButton.CENTER);
        easyButton.setVerticalTextPosition(JButton.BOTTOM);
        easyButton.setFocusable(false);
        easyPanel.add(easyButton);   

        JPanel medPanel = new JPanel();
        medPanel.setBounds(300, 500, 100, 100);
        ImageIcon medImage = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\pmMed.jpg");
        medButton.setBounds(300, 500, 100, 100);
        medButton.setIcon(medImage);
        medButton.addActionListener(this);
        medButton.setHorizontalTextPosition(JButton.CENTER);
        medButton.setVerticalTextPosition(JButton.BOTTOM);
        medButton.setFocusable(false);
        medPanel.add(medButton);   

        JPanel hardPanel = new JPanel();
        hardPanel.setBounds(500, 500, 100, 100);
        ImageIcon hardImage = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\pmHard.jpg"); 
        hardButton.setBounds(500, 500, 100, 100);
        hardButton.setIcon(hardImage);
        hardButton.addActionListener(this);
        hardButton.setHorizontalTextPosition(JButton.CENTER);
        hardButton.setVerticalTextPosition(JButton.BOTTOM);
        hardButton.setFocusable(false);
        hardPanel.add(hardButton);   
        
     frame.add(backgroundPanel);
     frame.add(easyPanel);
     frame.add(medPanel);
     frame.add(hardPanel);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(new Dimension(700,700));
     frame.setLocationRelativeTo(null);
     frame.getContentPane().setBackground(Color.BLACK);
     frame.setLayout(null);
     frame.setVisible(true);
    }

    public int getSpeed(){
        return speed;
    }

    public boolean gameHasStarted(){
        return started;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == easyButton) {
            speed = 150;
            started = true;
            frame.setVisible(false);
        }
        else if (event.getSource() == medButton) {
            speed = 100;
            started = true;
            frame.setVisible(false);
        }
        else if (event.getSource() == hardButton) {
            speed = 50;
            started = true;
            frame.setVisible(false);
        }
    }
}
