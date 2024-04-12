

import java.awt.Font;
import java.awt.Graphics;

public class DrawableString implements Drawable{

	private String s;
	private Font f;
	private int x;
	private int y; 
	
	public DrawableString(String s,int x,int y, int size) {
		
		f = new Font("Serif", Font.PLAIN, size);
		this.x = x;
		this.y = y;
		this.s = s;
	}

	
	public void draw(Graphics g) {
		g.setFont(f);
		g.drawString(s, x, y);
		
	}
	public void setString(String s) {
		this.s = s;
	}
	

}
