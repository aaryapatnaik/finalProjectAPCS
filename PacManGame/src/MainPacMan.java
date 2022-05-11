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
        JFrame frame = new JFrame("PacMan Game by AP, AV, JI, HN");
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
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if (/*startbuttonclicked*/){
                    //pacman.moveright
                }
                ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
                for (int i = 0; i<4; i++){
                    ghosts.add(new Ghost());
                }
            }
        }
        Timer timer = new Timer(500, taskPerformer);
        timer.setRepeats(true);
        timer.start();
        Thread.sleep(2500);
        timer.stop();
    }

}
}
