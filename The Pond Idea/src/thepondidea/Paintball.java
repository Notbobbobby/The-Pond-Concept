package thepondidea;

import java.awt.Color;

public class Paintball {
	
	public static final double GRAVITY = 9.81; 
	
	public double[] position;
	public double[] velocity;
	
	public double size; // Being volume/mass of the ball
	public double radius;
	
	private boolean hit = false;
	
	private float startHue;
	
	public Paintball(double[] position, double[] velocity, double size) {
		this.position = position;
		this.velocity = velocity;
		
		this.size = size;
		this.radius = getRadius();
		
		this.startHue = getStartHue();
	}
	
	public double getRadius() {
		return Math.pow((3 * size) / (4 * Math.PI), 1.0 / 3);
	}
	
	public float getStartHue() {
		return (float) Math.random();
	}
	
	public int getColor(float hue) {
		float realHue = hue + startHue;
		if(realHue >= 1f) realHue -= 1f;
		
		return Color.HSBtoRGB(hue, 0.9f, 0.9f);
	}
}
