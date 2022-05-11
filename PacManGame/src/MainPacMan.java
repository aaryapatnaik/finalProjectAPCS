import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
public class MainPacMan {
    private JFrame frame;
    private ImageIcon lasagna;
    private JLabel myLabel;

    public MainPacMan() {

        lasagna = new ImageIcon("/Users/aarya/Desktop/AP_CompSci_FinalProject/finalProjectAPCS/PacManGame/src/lasagna.png");
        myLabel = new JLabel(lasagna);
        myLabel.setSize(400,600);

        JFrame frame = new JFrame("PacMan Game by AP, AV, JI, HN");
        frame.add(myLabel);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        private Image getScaledImage(Image srcImg, int w, int h){
           BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
          Graphics2D g2 = resizedImg.createGraphics();
    
          g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
          g2.drawImage(srcImg, 0, 0, w, h, null);
          g2.dispose();
    
        return resizedImg;
    }
    }
    public static void main(String args[])
    {
        new Display();
>>>>>>> befce51716926f859346073dbc0affe032d49ce6
    }
}