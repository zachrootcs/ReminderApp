
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DrawableRect implements Drawable{
	
	public Rectangle rect;
	public Color color;
	
	
	public DrawableRect(Rectangle r, Color c) {
		rect = r;
		color = c;
	}
	
	@Override
	public void draw(Graphics g) {
		Color tempColor = g.getColor();
		g.setColor(getColor());
		
		int x = (int)rect.getX();
		int y = (int)rect.getY();
		int w = (int)rect.getWidth();
		int h = (int)rect.getHeight();
		g.fillRect(x, y, w, h);
		
		g.setColor(tempColor);
	}


	public Color getColor() {
		
		return color;
	}

	public void setRect(Rectangle r) {
		this.rect = r;
	}
	

}
