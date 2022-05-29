import java.awt.*;
 import java.awt.event.*;
 import java.util.*;
 import javax.swing.*;
 import javax.swing.JFrame;
 import javax.swing.ImageIcon;
public class MainPacMan extends JPanel implements KeyListener, ActionListener{
	private static int garfx = 25;
	private static int garfy = 25;
    private static int prevgarfx = 0;
    private static int prevgarfy = 0;
    private static ArrayList<Ghost> ghosts = new ArrayList<Ghost>(Arrays.asList(new Ghost(325, 350), new Ghost(350, 350), new Ghost(325, 375), new Ghost(350, 375)));
    private static int dir = 0;
	private static javax.swing.Timer timer;
	private static JFrame jf = new JFrame();
    private static Board board = new Board();
    private static int score = 0;
    private static int lives = 3;
    private static int speed = 50;
    private static int bluetimer = 0;
    private JButton easyButton;
    private JButton medButton;
    private JButton hardButton;
	
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

    public static ImageIcon pickGhostImage(int direc, boolean isBlue){
        if (direc == 0){
            if (isBlue){
                return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\ghostNermalMoveR.png");
            }
            return new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\Nermal\\nermalIdleRight.jpg");
        }
        else if (direc == 1){
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
		// ImageIcon i = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\Garfield\\pacManBoard.png");
		/*ImageIcon i = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\blackCell.jpg");
        ImageIcon k = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\blueCell.jpg");
        for (int a = 0; a < 28; a++) {
            for (int b = 0; b < 28; b++) {
                if ((board.getCell(a,b)).getWall()) {
                    k.paintIcon(this,g,(b*25), (a*25));
                } else if (!(board.getCell(a,b)).getWall()) {
                    i.paintIcon(this,g,(b*25), (a*25));
                }
            }
        }*/
        //i.paintIcon(this, g, 0, 0);
		ImageIcon i = new ImageIcon("C:\\Users\\abhir\\New folder\\finalProjectAPCS\\Media\\newBoard.png");
		// ImageIcon i = new ImageIcon("finalProjectAPCS/Media/blackCell.jpg");
        // ImageIcon k = new ImageIcon("finalProjectAPCS/Media/blueCell.jpg");
        // for (int a = 0; a < 28; a++) {
        //     for (int b = 0; b < 28; b++) {
        //         if ((board.getCell(a,b)).getWall()) {
        //             k.paintIcon(this,g,(b*25), (a*25));
        //         } else if (!(board.getCell(a,b)).getWall()) {
        //             i.paintIcon(this,g,(b*25), (a*25));
        //         }
        //     }
        // }
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
        for (Ghost G : ghosts){
            ImageIcon nerm = pickGhostImage(G.getDirection(), G.isBlue());
		    nerm.paintIcon(this, g, G.getX(), G.getY());
        }
    
	}
	
    public void initStart(){
        //Setting JFrame
        JFrame frame = new JFrame();
        JPanel backgroundPanel=new JPanel();  
        backgroundPanel.setBounds(0, 0, 700, 700);
         backgroundPanel.setLayout(new FlowLayout());      
         ImageIcon backgroundImgStart = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/new!!/finalProjectAPCS/Media/pmStart.jpg");
         JLabel picLabel = new JLabel(backgroundImgStart);
         backgroundPanel.add(picLabel);

        JPanel easyPanel = new JPanel();
        easyPanel.setBounds(100, 500, 100, 100);
        ImageIcon easyImage = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/new!!/finalProjectAPCS/Media/pmEasy.jpg");
        easyButton = new JButton(); 
        easyButton.setBounds(100, 500, 100, 100);
        easyButton.addActionListener(this);
        easyButton.setIcon(easyImage);
        easyButton.setHorizontalTextPosition(JButton.CENTER);
        easyButton.setVerticalTextPosition(JButton.BOTTOM);
        easyButton.setFocusable(false);
        easyPanel.add(easyButton);   

        JPanel medPanel = new JPanel();
        medPanel.setBounds(300, 500, 100, 100);
        ImageIcon medImage = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/new!!/finalProjectAPCS/Media/pmMed.jpg");
        medButton = new JButton(); 
        medButton.setBounds(300, 500, 100, 100);
        medButton.addActionListener(this);
        medButton.setIcon(medImage);
        medButton.setHorizontalTextPosition(JButton.CENTER);
        medButton.setVerticalTextPosition(JButton.BOTTOM);
        medButton.setFocusable(false);
        medPanel.add(medButton);   

        JPanel hardPanel = new JPanel();
        hardPanel.setBounds(500, 500, 100, 100);
        ImageIcon hardImage = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/new!!/finalProjectAPCS/Media/pmHard.jpg");
        hardButton = new JButton(); 
        hardButton.setBounds(500, 500, 100, 100);
        hardButton.addActionListener(this);
        hardButton.setIcon(hardImage);
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
     frame.getContentPane().setBackground(Color.BLACK);
     frame.setLayout(null);
     frame.setVisible(true);
    }

	public static void main(String[] args) {
        initStart();
        System.out.println("Select a speed (milliseconds per step): ");
        Scanner sc = new Scanner(System.in);
        speed = sc.nextInt();
        sc.close();
		MainPacMan p = new MainPacMan();
		jf.setTitle("Pacman (Garfield Edition)");
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
            score+=50;
            bluetimer = (1000/speed)*10;
            //isBlue = true;
            for (Ghost G : ghosts){
                G.setIsBlue(true);
            }
            board.getCell(x, y).setBigFood(false);
        }
    }

    public static void movePlayer(){
        prevgarfx = garfx;
        prevgarfy = garfy;
        if ((dir==0)&&(!board.getCell(garfy/25, (garfx/25)+1).getWall())){
            garfx+=25;
        }
        if ((dir==1)&&(!board.getCell(garfy/25, (garfx/25)-1).getWall())){
            garfx-=25;
        }
        if ((dir==2)&&(!board.getCell((garfy/25)-1, garfx/25).getWall())){
            garfy-=25;
        }
        if ((dir==3)&&(!board.getCell((garfy/25)+1, garfx/25).getWall())){
            garfy+=25;
        }
    }

    public static void moveGhost(Ghost G){
        int nermx = G.getX();
        int nermy = G.getY();
        int nermdir = G.getDirection();
        ArrayList<Integer> posposses = new ArrayList<Integer>();
        boolean rightclear = (nermx/25<=26)&&(!board.getCell(nermy/25, (nermx/25)+1).getWall());
        boolean leftclear = (nermx/25>=1)&&(!board.getCell(nermy/25, (nermx/25)-1).getWall());
        boolean downclear = (nermy/25>=1)&&(!board.getCell((nermy/25)-1, nermx/25).getWall());
        boolean upclear = (nermy/25<=26)&&(!board.getCell((nermy/25)+1, nermx/25).getWall());
        if (rightclear){
            posposses.add(0);
            if(nermdir==0)G.setLocation(nermx+25, nermy);//nermx+=25;
        }
        if (leftclear){
            posposses.add(1);
            if(nermdir==1)G.setLocation(nermx-25, nermy);//nermx-=25;
        }
        if (downclear){
            posposses.add(2);
            if(nermdir==2)G.setLocation(nermx, nermy-25);//nermy-=25;
        }
        if (upclear){
            posposses.add(3);
            if(nermdir==3)G.setLocation(nermx, nermy+25);//nermy+=25;
        }
        boolean a = nermdir==0&&!rightclear;
        boolean b = nermdir==1&&!leftclear;
        boolean c = nermdir==2&&!downclear;
        boolean d = nermdir==3&&!upclear;
        if (a||b||c||d){
            int num = (int) (Math.random()*(posposses.size()));
            G.setDirection(posposses.get(num));//nermdir = posposses.get(num);
        }
    }
    
	public static void turn(){
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                movePlayer();
                //nermx-=25;
                //moveGhost();
                for (Ghost G : ghosts){
                    moveGhost(G);
                }
                eatFood(garfy/25, garfx/25);
                jf.repaint();
                checXit();
                bluetimer--;
                if (bluetimer<=0){
                    for (Ghost G : ghosts){
                        G.setIsBlue(false);
                    }
                }
            } 
    };
    	timer = new javax.swing.Timer(speed, taskPerformer);
   }
	
   
	public static void checXit() {
        if (!board.containsFood()){
            timer.stop();
            System.out.println(score);
            //pull up victory end page
        }
        if (lives == 0){
            timer.stop();
            //pull up loser end page
        }
        for (Ghost G : ghosts){
            int nermx = G.getX();
            int nermy = G.getY();
            boolean a = (garfx == nermx)&&(prevgarfx == garfx)&&(prevgarfy == nermy);
            boolean b = (garfy == nermy)&&(prevgarfy == garfy)&&(prevgarfx == nermx);
            boolean c = (garfx == nermx)&&(garfy == nermy);
		    if (c||a||b){
                if (G.isBlue()){
                score+=200;
                G.setIsBlue(false);
                G.setLocation(325, 350);
                G.setDirection(2);
                break;
                }
                else{
                    lives--;
                    dir = 0;
                    G.setDirection(2);
                    garfx = 0;
                    garfy = 25;
                    //nermx = 325;
                    //nermy = 350;
                    ghosts.get(0).setLocation(325, 350);
                    ghosts.get(1).setLocation(350, 350);
                    ghosts.get(2).setLocation(325, 375);
                    ghosts.get(3).setLocation(350, 375);
                    for (Ghost H : ghosts){
                        H.setDirection(2);
                        H.setIsBlue(false);
                    }
                }
            }
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

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == easyButton) {
            System.out.println("easy clicked");
        }
        else if (event.getSource() == medButton) {
            System.out.println("med clicked");
        }
        else if (event.getSource() == hardButton) {
            System.out.println("hard clicked");
        }
    }

}