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
 /*
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
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\pacManBoard.png"));
        Image dimg = myPicture.getScaledInstance(800, 800,Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(dimg));
		backgroundPanel.add(picLabel);
		frame.add(backgroundPanel);
        //Setting start button
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBounds(0, 800, 800, 100);
        ImageIcon startImage = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\startButton.jpg");
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
    }
    
     /*private static ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
     private static int score = 0;
     private static int bluetimer = 0;
     private static int numlives = 3;
     private static javax.swing.Timer timer;
     private static Board board = new Board();
     private static Player p = new Player("", new Image[2], 1, 1, 1,1);

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
                             try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                             p.turnRight();
                            score+=10;
                            }
                    }
                 if (board.getCell(getIntX(), getIntY()).getContainsBigFood()){
                    eatFood();
                    score+=25;
                    for (Ghost h: ghosts){
                        h.turnBlue();
                    }
                    bluetimer = 20;
                }
                if (board.getCell(getIntX(), getIntY()).getContainsFood()){
                    eatFood();
                    score+=10;
                }
                 bluetimer--;
                 if (bluetimer == 0){
                     for (Ghost h: ghosts){
                         h.turnNormal();
                     }
                 }
                 checkExit();
                 }
             } 
     };
     timer = new javax.swing.Timer(500, taskPerformer);
    }

     public static void mainAction(){
         if (startbuttonclicked){
             p.turnRight();
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
         board.drawBoard(g);
         //mainAction();
         //new Animation();
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}*/
public class MainPacMan extends JPanel implements KeyListener{
	private static int garfx = 0;
	private static int garfy = 25;
    private static int prevgarfx = 0;
    private static int prevgarfy = 0;
	private static int nermx = 325;
	private static int nermy = 325;
    private static int dir = 0;
	private static javax.swing.Timer timer;
	private static JFrame jf = new JFrame();
    private static Board board = new Board();
    private static int score = 0;
	
    public MainPacMan(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public static ImageIcon pickPlayerImage(int dir){
        if (dir == 0){
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Garf\\garfIdleRight.jpg");
        }
        else if (dir == 1){
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Garf\\garfIdleLeft.jpg");
        }
        return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Garf\\garfIdleUpDown.jpg");
    }

    public static ImageIcon pickGhostImage(int dir, boolean isBlue){
        if (dir == 0){
            if (isBlue){
                return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\ghostNermalMoveR.png");
            }
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\nermalIdleRight.jpg");
        }
        else if (dir == 1){
            if (isBlue){
                return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\ghostNermalMoveL.jpeg");
            }
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\nermalIdleLeft.jpg");
        }
        if (isBlue){
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\ghostNermalMoveUD.png");
        }
        return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\nermalIdleUpDown.jpg");
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon i = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\pacManBoard.png");
		i.paintIcon(this, g, 0, 0);
		ImageIcon garf = pickPlayerImage(dir);
		garf.paintIcon(this, g, garfx, garfy);
        for (int x = 0; x <28; x++) {
            for (int j = 0; j <28; j++) {
                if ((board.getCell(x, j)).getContainsFood()) {
                    ImageIcon img = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\smallLasagna.png");
                    img.paintIcon(this, g, (j*25)+5, (x*25)+5);
                }
                if ((board.getCell(x, j)).getContainsBigFood()) {
                    ImageIcon img2 = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\bigLasagna.png");
                    img2.paintIcon(this, g, j*25, x*25);
                }
            }
        }
        ImageIcon nerm = pickGhostImage(1, false);
		nerm.paintIcon(this, g, nermx, nermy);
	}
	
	public static void main(String[] args) {
		MainPacMan p = new MainPacMan();
		jf.setTitle("Pacman by AP, AV, HN, JI");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(p);
		turn();
		timer.setRepeats(true);
		timer.start();
		
	}
	
    public static void eatFood(int x, int y){
        if (board.getCell(x, y).getContainsFood()){
            score+=10;
            board.getCell(x, y).setFood(false);
        }
        if (board.getCell(x, y).getContainsBigFood()){
            score+=20;
            board.getCell(x, y).setBigFood(false);
        }
    }

    public static void movePlayer(){
        prevgarfx = garfx;
        prevgarfy = garfy;
        if (dir==0){
            garfx+=25;
        }
        else if (dir==1){
            garfx-=25;
        }
        else if (dir==2){
            garfy-=25;
        }
        else{
            garfy+=25;
        }
    }
    
	public static void turn(){
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                movePlayer();
                //nermx-=25;
                eatFood(garfy/25, garfx/25);
                jf.repaint();
                checXit();
            } 
    };
    	timer = new javax.swing.Timer(250, taskPerformer);
   }
	
   
	public static void checXit() {
        if (!board.containsFood()){
            timer.stop();
            //pull up menu page
        }
        boolean a = (garfx == nermx)&&(prevgarfx == garfx)&&(prevgarfy == nermy);
        boolean b = (garfy == nermy)&&(prevgarfy == garfy)&&(prevgarfx == nermx);
        boolean c = (garfx == nermx)&&(garfy == nermy);
		if (c||a||b){
			timer.stop();
            System.out.println(score);
		}

	}
    
    public void up(){
        dir=2;
    }

    public void down(){
        dir = 3;
    }

    public void right(){
        dir=0;
    }

    public void left(){
        dir = 1;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyVal = e.getKeyCode();
        if (keyVal == KeyEvent.VK_UP) {
            up();
        }
        if (keyVal == KeyEvent.VK_DOWN) {
            down();
        }
        if (keyVal == KeyEvent.VK_LEFT) {
            left();
        }
        if (keyVal == KeyEvent.VK_RIGHT) {
            right();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}