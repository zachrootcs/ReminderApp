
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class TextInput extends Button{

	public Font font;
	
	public TextInput(Rectangle r, Color c, String action, Font f) {
		super(r, c, action);
		this.font = f;
	}
	
	@Override
	public void changeOnRelease(Point p) {
		return;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Font temp = g.getFont();
		g.setFont(font);
		if(super.clicked) {
			g.drawString(GuiComponents.keyboardInput, rect.x+1, rect.y+13);
			GuiComponents.currentKeyboardCommand = super.action;
		}else {
			g.drawString("", rect.x+1, rect.y+13);
		}
		g.setFont(temp);
	}
}
