import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class MainPacMan{
    private JFrame frame;
    private ImageIcon lasagna;
    private JLabel myLabel;
    private JPanel panel;

    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }

    public MainPacMan() throws IOException {
        JFrame frame= new JFrame("PacMan by AP, AV, JI, HN");    
		JPanel panel=new JPanel();  
		panel.setLayout(new FlowLayout());      
		BufferedImage myPicture = ImageIO.read(new File("/Users/aarya/Desktop/AP_CompSci_FinalProject/untitled folder/finalProjectAPCS/PacManGame/src/lasagna.png"));
        Image dimg = myPicture.getScaledInstance(600, 400,Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(dimg));
		panel.add(picLabel);
		frame.add(panel);
		frame.setSize(800,800);            
		frame.setVisible(true); 


    }
    public static void main(String args[]) throws IOException
    {
        
        new MainPacMan();
    }

}
