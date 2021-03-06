import java.awt.*;
 import java.awt.event.*;
 import java.util.*;
 import javax.swing.*;
import javax.swing.Timer;
import javax.swing.plaf.DimensionUIResource;
public class MainPacMan extends JPanel implements KeyListener{
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
    private static javax.swing.Timer t2;
	
    public MainPacMan(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public static ImageIcon pickPlayerImage(int dir){
        if (dir == 0){
            return new ImageIcon("Media\\Garfield\\Garf\\garfIdleRight.jpg");
        }
        else if (dir == 1){
            return new ImageIcon("Media\\Garfield\\Garf\\garfIdleLeft.jpg");
        }
        return new ImageIcon("Media\\Garfield\\Garf\\garfIdleUpDown.jpg");
    }

    public static ImageIcon pickGhostImage(int direc, boolean isBlue){
        if (direc == 0){
            if (isBlue){
                return new ImageIcon("Media\\Garfield\\Nermal\\ghostNermalMoveR.png");
            }
            return new ImageIcon("Media\\Garfield\\Nermal\\nermalIdleRight.jpg");
        }
        else if (direc == 1){
            if (isBlue){
                return new ImageIcon("Media\\Garfield\\Nermal\\ghostNermalMoveL.jpeg");
            }
            return new ImageIcon("Media\\Garfield\\Nermal\\nermalIdleLeft.jpg");
        }
        if (isBlue){
            return new ImageIcon("Media\\Garfield\\Nermal\\ghostNermalMoveUD.png");
        }
        return new ImageIcon("Media\\Garfield\\Nermal\\nermalIdleUpDown.jpg");
    }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon i = new ImageIcon("Media\\newBoard.png");
        i.paintIcon(this, g, 0, 0);
		ImageIcon garf = pickPlayerImage(dir);
		garf.paintIcon(this, g, garfx, garfy);
        for (int x = 0; x <28; x++) {
            for (int j = 0; j <28; j++) {
                if ((board.getCell(x, j)).getContainsFood()) {
                    ImageIcon img = new ImageIcon("Media\\smallLasagna.png");
                    img.paintIcon(this, g, (j*25)+5, (x*25)+5);
                }
                if ((board.getCell(x, j)).getContainsBigFood()) {
                    ImageIcon img2 = new ImageIcon("Media\\bigLasagna.png");
                    img2.paintIcon(this, g, j*25, x*25);
                }
            }
        }
        for (Ghost G : ghosts){
            ImageIcon nerm = pickGhostImage(G.getDirection(), G.isBlue());
		    nerm.paintIcon(this, g, G.getX(), G.getY());
        }
    
	}

	public static void main(String[] args) {
        StartGame sb = new StartGame();
        ActionListener taskPerformer2 = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if (sb.gameHasStarted()){
                    t2.stop();
                    speed = sb.getSpeed();
                    MainPacMan p = new MainPacMan();
                    jf.setTitle("Pacman (Garfield Edition)");
                    jf.setSize(new Dimension(700, 700));
                    jf.setVisible(true);
                    jf.setLocationRelativeTo(null);
                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf.add(p);
                    turn();
                    timer.setRepeats(true);
                    timer.start();
                }
            } 
        };
        t2 = new javax.swing.Timer(1000, taskPerformer2);
        t2.start();
        
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
                /*boolean temp = true;
                temp = temp && board.notInSpawn(garfy/25, garfx/25);
                for (Ghost gh : ghosts){
                    temp = temp && board.notInSpawn(gh.getY()/25, gh.getX()/25);
                }
                if (temp){
                    board.closeWall();
                }*/
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
            jf.setVisible(false);
            EndGame eg = new EndGame(true);
            System.out.println("Score "+score);
            //pull up victory end page
        }
        if (lives == 0){
            timer.stop();
            jf.setVisible(false);
            EndGame eg = new EndGame(false);
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

}