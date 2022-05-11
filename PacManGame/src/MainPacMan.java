import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MainPacMan {


public class MainPacMan{
    private JFrame frame;
    private ImageIcon lasagna;
    private JLabel myLabel;
    private JPanel panel;
    public MainPacMan() {
        //Lasagna
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/Users/aarya/Desktop/AP_CompSci_FinalProject/finalProjectAPCS/PacManGame/src/lasagna.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(600, 400,Image.SCALE_SMOOTH);
        ImageIcon lasagna = new ImageIcon(dimg);
        myLabel = new JLabel(lasagna);
        
        //Actual frame
        JFrame frame = new JFrame("PacMan Game by AP, AV, HN, JI");
        frame.add(myLabel);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String args[]) throws InterruptedException
    {
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

}
}
