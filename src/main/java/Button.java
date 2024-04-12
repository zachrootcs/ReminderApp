
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Button extends DrawableRect implements Interactable{

	
	public boolean hovered = false;
	public boolean clicked = false;
	public String action = "";
	public String title = "";
	public Button(Rectangle r, Color c, String action)  {
		super(r,c);
		this.action = action;
	}
	
	public Button(Rectangle r, Color c, String action, String title)  {
		super(r,c);
		this.action = action;
		this.title = title;
	}
	

	public void changeOnHover(Point p) {
		if(p==null) return;
		
		if(rect.contains(p)) {
			hovered = true;
		}else {
			hovered = false;
		}
		
	}
	
	public void changeOnRelease(Point p) {
		
		if(p==null) {
	
			return;
		}
		
		if(rect.contains(p)) {
			
			if(!GuiComponents.commandSet.contains(action)) {
				GuiComponents.commandSet.add(action);
			}else {
				GuiComponents.commandSet.remove(action);
			}
			
			GuiRunner.mouseReleasedHandler(null);
			GuiRunner.mousePressedHandler(null);
			return;
		}else {
			clicked = false;
		}
		
	
	}
	

	public void changeOnClick(Point p) {
		if(p==null) {
			clicked = false;
			return;
		}
		
		if(rect.contains(p)) {
			clicked = true;
		}else {
			clicked = false;
		}
		
		
		
	}
	@Override
	public void draw(Graphics g) {
	
		Color tempColor = g.getColor();
		g.setColor(getColor());
		
		int x = (int)rect.getX();
		int y = (int)rect.getY();
		int w = (int)rect.getWidth();
		int h = (int)rect.getHeight();
		g.fill3DRect(x,y,w,h,true);
		
		
		g.setColor(Color.BLACK);
		Font temp = g.getFont();
		g.setFont(new Font("Serif", Font.PLAIN, (int)(super.rect.getWidth()/8)));
		g.drawString(title, x, y+15);
		
		
		g.setFont(temp);
		g.setColor(tempColor);
	}
	
	public Color getColor() {
		Color outputColor = new Color(color.getRed(),color.getGreen(), color.getBlue());
		if(hovered) {
			outputColor = outputColor.darker();
		}
		if(clicked) {
			outputColor = outputColor.darker();
		}
		return outputColor;
	}

	
}
