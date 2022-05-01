import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;


public class BejeweledGame {

	private JFrame frame = new JFrame("Bejeweled");
	private JPanel panel;
	private final Dimension DIM = new Dimension(800,700);
	private BejeweledGrid grid = new BejeweledGrid();
	private Image background;
	private Timer timer = new Timer(50,null);
	public static void main(String[] args) {
		new BejeweledGame().start();
	}

	private void start() {
		try {
			File f = new File("images/backgrounds/gemVault.png");
			background = ImageIO.read(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		panel = new JPanel() {
			@Override 
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background, 0,0,null);
				grid.draw(g);
			}
		};
		panel.setBackground(Color.BLACK);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);
			}
		});
		panel.setPreferredSize(DIM);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		//timer
		timer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.repaint();
			}
		});
		timer.start();

	}

	protected void clickedAt(MouseEvent me) {
		System.out.println("You just clicked "+me);	
		grid.justClicked(me);
		panel.repaint();
	}

}
