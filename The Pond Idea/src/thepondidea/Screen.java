package thepondidea;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas {
	
	private int width;
	private int height;
	
	public BufferedImage image;
	public int[] pixels; // These will become pixels
	
	private Painting canvas;
	
	public Screen(Window window, int width, int height) {
		window.add(this);
		
		this.width = width;
		this.height = height;
		this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		double[] position = {10, 10, 10};
		this.canvas = new Painting(position, width, height);
		
		this.setBackground(Color.WHITE);
	}
	
	float itt = 0;
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		canvas.render();
		
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = canvas.pixels[i];
		}
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.WHITE);
		g.drawString(Main.ups + "UPS, " + Main.fps + "FPS", 20, 20);
		
		g.dispose();
		bs.show();
	}
	
	public void clear() {
		canvas.clear();
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
}
