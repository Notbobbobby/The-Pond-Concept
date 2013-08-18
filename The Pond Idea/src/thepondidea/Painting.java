package thepondidea;

import java.awt.Color;

public class Painting {
	
	
	public double[] position;
	public double[] center;
	
	public int width;
	public int height;
	
	public int[] pixels;
	public float[] hues;
	
	public Painting(double[] position, int width, int height) {
		
		this.position = position;
		this.center = getCenter();
		
		this.width = width;
		this.height = height;
		
		this.pixels = new int[width * height];
		this.hues = new float[width * height];
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = Math.abs(Color.HSBtoRGB(hues[0], 0.9f, 0.9f));
		}
		
		hues[0] += 1f/10000f;
		if(hues[0] > 1) {
			hues[0] -= 1;
		}
	}
	
	public double[] getCenter() {
		double[] cent = new double[3];
		cent[0] = (position[0] + width) / 2;
		cent[1] = (position[1] + height) / 2;
		cent[2] = position[2];
		return cent;
	}
}
