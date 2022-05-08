import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class MainPacMan {
    private JFrame frame;

    public MainPacMan() {
        JFrame frame = new JFrame("PacMan Game by AP, AV, JI, HN");
        frame.setSize(650, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        new MainPacMan();
    }
}