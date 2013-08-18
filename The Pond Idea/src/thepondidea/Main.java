package thepondidea;

import java.awt.Color;


public class Main implements Runnable {
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	public static int fps = 0;
	public static int ups = 0;
	
	private Window window;
	private Screen screen;
	private Thread thread;
	private boolean running = false;
	
	public Main() {
		this.window = new Window(width, height, scale, "Drop Me");
		this.screen = new Screen(window, width, height);
		this.window.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		final double ns = 1000000000.0 / 60.0;
		long lastTime = System.nanoTime();
		double delta = 0;
		
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				updates++;
				
				delta--;
			}
			
			render();
			frames++;
			
			if((System.currentTimeMillis() - timer) > 1000) {
				timer += 1000;
				ups = updates;
				fps = frames;
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		screen.clear();
		screen.render();
	}
	
	public static void main(String[] args ) {
		System.out.println("And it begins...");
		
		Main main = new Main();
		main.start();
	}
}
