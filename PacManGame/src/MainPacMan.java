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
        //new MainPacMan();

        //Layered pane base code
        /*
        JLabel labelOne = new JLabel();
        labelOne.setOpaque(true);
        labelOne.setBackground(Color.RED);
        labelOne.setBounds(50,50,200,200);

        JLabel labelTwo = new JLabel();
        labelTwo.setOpaque(true);
        labelTwo.setBackground(Color.BLUE);
        labelTwo.setBounds(150,150,200,200);

        JLabel labelThree = new JLabel();
        labelThree.setOpaque(true);
        labelThree.setBackground(Color.GREEN);
        labelThree.setBounds(250,250,200,200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        layeredPane.add(labelOne);
        layeredPane.add(labelTwo);
        layeredPane.add(labelThree);

        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setLayout(null);
        frame.setVisible(true);
        */

        new UserInput();
        new MainPacMan();
        if (/*startbuttonclicked*/){
            //pacman.turnright
        }
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        ghosts.add(new Ghost(14, 14));
        ghosts.add(new Ghost(14, 15));
        ghosts.add(new Ghost(15, 14));
        ghosts.add(new Ghost(15, 15));
        int score = 0;
        int bluetimer = 0;
        int livesleft = 3;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                for (ghost g: ghosts){
                    if (/*pacman.getLocation()*/.equals(g.getLocation())){
                        if (bluetimer>0){
                            score+=200;
                            ghosts.remove(g);
                            ghosts.add(new Ghost(14, 14));
                        }
                        else {
                            numlives--;
                            //board.reset
                            Thread.sleep(3000);
                            //pacman.turnright
                            break;
                        }
                    }
                }
                for (ghost g: ghosts){
                    g.move();
                }
                if (/*user.hitkey*/){
                    //pacman.changedirection
                }
                //pacman.move();
                if (cell.containsBigFood()){
                    //pacman.eatfood
                    //
                }
            }
        }
        Timer timer = new Timer(500, taskPerformer);
        timer.setRepeats(true);
        timer.start();
        if (livesleft == 0){
            Thread.sleep(2500);
            timer.stop();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==startButton) {
            System.out.print("clicked start button ");
            //do start button stuff
        }
    }
}
