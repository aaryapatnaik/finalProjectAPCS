import java.awt.*;
import java.io.*;
import java.util.*:
import javax.imageio.ImageIO;
import javax.swing.*;
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
<<<<<<< HEAD
     
    public static void main(String args[]) throws IOException
    {
        //new MainPacMan();

        /*
        new UserInput();
        new MainPacMan();
        if (startbuttonclicked){
            pacman.turnright
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
                    if (pacman.getLocation().equals(g.getLocation())){
=======
    private static ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    private static int score = 0;
    private static int bluetimer = 0;
    private static int numlives = 3;
    private static javax.swing.Timer timer;

    public static void turn(){
        timer = new Timer(500, taskPerformer);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                for (Ghost g: ghosts){
                    if (/*pacman.getLocation()*/.equals(g.getLocation())){
>>>>>>> bcadb224a63559007e4f7134a4a9cc48e9890085
                        if (bluetimer>0){
                            score+=200;
                            ghosts.remove(g);
                            ghosts.add(new Ghost(14, 14));
                        }
                        else {
                            numlives--;
                            checkLives();
                            //board.reset
                            Thread.sleep(3000);
                            //pacman.turnright
                            break;
                        }
                    }
                }
                for (Ghost g: ghosts){
                    g.move();
                }
                if (user.hitkey){
                    //pacman.changedirection
                }
                //pacman.move();
                if (cell.containsBigFood()){
                    //pacman.eatfood
                    score+=25;
                    for (Ghost g: ghosts){
                        //g.turnBlue
                    }
                    bluetimer = 20;
                }
                if (cell.containsFood()){
                    //pacman.eatfood
                    score+=10;
                }
                bluetimer--;
                checkExit();
                }
            } 
    }
    public static void mainAction(){
        if (/*startbuttonclicked*/){
            //pacman.turnright
        }
        ghosts.add(new Ghost(14, 14));
        ghosts.add(new Ghost(14, 15));
        ghosts.add(new Ghost(15, 14));
        ghosts.add(new Ghost(15, 15));
        turn();
        timer.setRepeats(true);
        timer.start();

        }
    }

    public static void checkLives(){
        if (numlives == 0){
            timer.stop();
            */

        new Animation();
        }
    }
    
    public static void checkExit(){
        if (!Board.containsFood(){
            timer.stop();
        })
        //end board.display();
    }
    public static void main(String args[]) throws IOException
    {
        new UserInput();
        new MainPacMan();
        mainAction();


    

    public 
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==startButton) {
            System.out.print("clicked start button ");
            //do start button stuff
        }
    }
}
