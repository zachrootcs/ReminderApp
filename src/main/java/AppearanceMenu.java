

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class AppearanceMenu implements Interactable
{
	public static int xPos = 590;
	public static int yPos = 300;
	public static Button CycleAppearance = new Button(new Rectangle(xPos+50,yPos+25,100,30), GuiComponents.ButtonColor, "CycleAppearance","CycleAppearance");
	
	static Rectangle rect = new Rectangle(xPos,yPos+100,100,20);
	static Rectangle rect2 = new Rectangle(xPos,yPos+150,100,20);
	static Rectangle rect3 = new Rectangle(xPos,yPos+200,100,20);

	public static TextInput BackGroundColorInput = new TextInput(rect, Color.lightGray,"Background COLOR", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static TextInput BodyColorInput = new TextInput(rect2, Color.lightGray,"Body COLOR", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static TextInput ButtonColorInput = new TextInput(rect3, Color.lightGray,"Button COLOR", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	
	public static DrawableString titleText = new DrawableString("Appearance Menu",xPos,yPos+20, 20);
	public static DrawableString backgroundColorText= new DrawableString("Input RBG for Background",xPos,yPos+100,12);
	public static DrawableString bodyColorText= new DrawableString("Input RBG for Body",xPos,yPos+150,12);
	public static DrawableString buttonColorText= new DrawableString("Input RBG for Buttons",xPos,yPos+200,12);
	
	public void draw(Graphics g) {
		Drawable[] graphics = GuiComponents.getAppearanceMenu();
		
		for(Drawable d: graphics) {
			d.draw(g);
		}
		CycleAppearance.draw(g);
		Font temp = g.getFont();
		BackGroundColorInput.draw(g);
		BodyColorInput.draw(g);
		bodyColorText.draw(g);
		backgroundColorText.draw(g);
		titleText.draw(g);
		ButtonColorInput.draw(g);
		buttonColorText.draw(g);
		g.setFont(temp);
	}

	
	public void changeOnHover(Point p) {
		CycleAppearance.changeOnHover(p);
		BackGroundColorInput.changeOnHover(p);
		BodyColorInput.changeOnHover(p);
		ButtonColorInput.changeOnHover(p);
	}

	
	public void changeOnRelease(Point p) {
		CycleAppearance.changeOnRelease(p);
		BackGroundColorInput.changeOnRelease(p);
		BodyColorInput.changeOnRelease(p);
		ButtonColorInput.changeOnRelease(p);
	}

	
	public void changeOnClick(Point p) {
		CycleAppearance.changeOnClick(p);
		BackGroundColorInput.changeOnClick(p);
		BodyColorInput.changeOnClick(p);
		ButtonColorInput.changeOnClick(p);
		
	}

}
