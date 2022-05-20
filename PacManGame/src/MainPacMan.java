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
 public class MainPacMan implements ActionListener{
     private ImageIcon lasagna;
     private JLabel myLabel;
     private JPanel panel;
     private JButton startButton;

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
    }*/
     private static ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
     private static int score = 0;
     private static int bluetimer = 0;
     private static int numlives = 3;
     private static javax.swing.Timer timer;
     private static Board board = new Board();
     private static Player p = new Player("", new Image[2], /*new Image[3]*/ 1, 1, 1, 1);

     public static void turn(){
         ActionListener taskPerformer = new ActionListener() {
             public void actionPerformed(ActionEvent evt){
                 for (Ghost g: ghosts){
                     if (p.collidedWithMoveable(g)){
                         if (bluetimer>0){
                             score+=200;
                         }
                         else {
                            numlives--;
                            checkLives();
                             //board.reset
                             Thread.sleep(3000);
                             //p.turnright
                            score+=10;
                            }
                    }
                 if (board.getCell(getIntX(), getIntY()).getContainsBigFood()){
                    eatFood();
                    score+=25;
                    for (Ghost h: ghosts){
                        //h.turnBlue
                    }
                    bluetimer = 20;
                }
                if (board.getCell(getIntX(), getIntY()).getContainsFood()){
                    eatFood();
                    score+=10;
                }
                 bluetimer--;
                 if (bluetimer == 0){
                     //ghost.turnNormal
                 }
                 checkExit();
                 }
             } 
     };
     timer = new javax.swing.Timer(500, taskPerformer);
    }

     public static void mainAction(){
         if (/*startbuttonclicked*/){
             //p.turnright
         }
         final int dxdy = 30;

         ghosts.add(new Ghost("one", new Image[0], dxdy, dxdy, 14, 14));
         ghosts.add(new Ghost("two", new Image[0], dxdy, dxdy, 14, 15));
         ghosts.add(new Ghost("three", new Image[0], dxdy, dxdy, 15, 14));
         ghosts.add(new Ghost("four", new Image[0], dxdy, dxdy, 15, 15));
         turn();
         timer.setRepeats(true);
         timer.start();
         
     }

     public static void checkLives(){
         if (numlives == 0){
             timer.stop();
         }
     }

     public static void checkExit(){
         if (!board.containsFood()){
             timer.stop();
         }
         //end board.display();
     }

     public static void eatFood(){
         board.getCell(getIntX(), getIntY()).setFood(false);
     } 

     public static int getIntX(){
         return (int) (p.getY()/30.0);
     }

     public static int getIntY(){
         return (int) (p.getX()/30.0);
     }

     

     public static void main(String args[]) throws IOException
     {
         //new UserInput();
         new MainPacMan();
         //mainAction();
         //new Animation();
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}