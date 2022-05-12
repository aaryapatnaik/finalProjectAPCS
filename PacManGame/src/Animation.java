import java.awt.*;
import javax.swing.*;
public class Animation extends JFrame {
    MyPanel panel;

    Animation(){
        panel = new MyPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
