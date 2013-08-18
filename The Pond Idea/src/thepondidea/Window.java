package thepondidea;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window(int width, int height, int scale, String title) {
		Dimension size = new Dimension(width * scale, height * scale);
		this.setPreferredSize(size);
		this.setTitle(title);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
