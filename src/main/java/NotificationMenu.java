
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class NotificationMenu implements Interactable{

	
	public static int xPos = 590;
	public static int yPos = 300;
	
	static Rectangle rect = new Rectangle(xPos,yPos+100,100,20);
	static Rectangle rect2 = new Rectangle(xPos,yPos+150,100,20);
	static Rectangle rect3 = new Rectangle(xPos,yPos+200,100,20);

	public static TextInput EmailInput = new TextInput(rect, Color.lightGray,"Email Input", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static Button PhoneNumberInput = new Button(rect2, Color.lightGray,"Disable Notifications", "DisableNotifications");
	public static Button testNotifications = new Button(rect3, Color.lightGray,"Send Reminder", "Send Reminder");

	
	public static DrawableString titleText = new DrawableString("Notification Menu",xPos,yPos+20, 20);
	public static DrawableString enterEmailTest= new DrawableString("Enter Email",xPos,yPos+100,12);
	@Override
	public void draw(Graphics g) {
		Drawable[] graphics = GuiComponents.getNotificationMenu();
		
		for(Drawable d: graphics) {
			d.draw(g);
		}
		
		
		Font temp = g.getFont();
		EmailInput.draw(g);
		PhoneNumberInput.draw(g);
		titleText.draw(g);
		enterEmailTest.draw(g);
		testNotifications.draw(g);
		g.setFont(temp);
	}

	@Override
	public void changeOnHover(Point p) {
		
		EmailInput.changeOnHover(p);
		PhoneNumberInput.changeOnHover(p);
		testNotifications.changeOnHover(p);
	}

	@Override
	public void changeOnRelease(Point p) {
		
		EmailInput.changeOnRelease(p);
		PhoneNumberInput.changeOnRelease(p);
		testNotifications.changeOnRelease(p);
	}

	@Override
	public void changeOnClick(Point p) {
	
		EmailInput.changeOnClick(p);
		PhoneNumberInput.changeOnClick(p);
		testNotifications.changeOnClick(p);
	}
}
