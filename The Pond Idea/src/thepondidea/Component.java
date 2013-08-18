package thepondidea;

import java.awt.Canvas;

public class Component extends Canvas {
	
	public Component() {
		
	}
	
	public Component(Window window) {
		
		window.add(this);
	}
}
