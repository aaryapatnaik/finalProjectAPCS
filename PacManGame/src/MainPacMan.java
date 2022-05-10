<<<<<<< HEAD
public class MainPacMan{
    public static void main(String[] args) {
        
=======
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
    }
    public static void main(String args[])
    {
        new MainPacMan();
>>>>>>> befce51716926f859346073dbc0affe032d49ce6
    }
}