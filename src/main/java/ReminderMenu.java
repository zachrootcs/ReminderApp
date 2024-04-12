
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class ReminderMenu implements Interactable{

	
	public static int xPos = 590;
	public static int yPos = 300;
	

	static Rectangle rect = new Rectangle(xPos,yPos+100,100,20);
	static Rectangle rect2 = new Rectangle(xPos,yPos+150,100,20);
	static Rectangle rect3 = new Rectangle(xPos, yPos+200,100,20);
	static Rectangle rect4 = new Rectangle(xPos, yPos+250,100,20);
	
	public static TextInput ReminderDescription = new TextInput(rect, Color.lightGray,"Reminder Description", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static TextInput ReminderName = new TextInput(rect2, Color.lightGray,"Reminder Name", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static TextInput ReminderDate = new TextInput(rect3, Color.lightGray,"Reminder Date", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	public static TextInput ReminderImportance = new TextInput(rect4, Color.lightGray,"Reminder Importance", new Font("Serif", Font.PLAIN, (int)(rect.getWidth()/7)));
	
	public static DrawableString titleText = new DrawableString("Reminder Menu",xPos,yPos+20, 20);
	public static DrawableString phoneText= new DrawableString("Input Reminder Name",xPos,yPos+150,12);
	public static DrawableString emailText= new DrawableString("Input Reminder Description",xPos,yPos+100,12);
	public static DrawableString reminderDateText= new DrawableString("Input Reminder Date M/D/Y",xPos,yPos+200,12);
	public static DrawableString reminderImportanceText= new DrawableString("Input Reminder Importance",xPos,yPos+250,12);
	
	public static Button createReminderButton = new Button(new Rectangle(xPos+50,yPos+270,120,30),GuiComponents.ButtonColor,"Create Reminder","Create Reminder");
	
	@Override
	public void draw(Graphics g) {
		Drawable[] graphics = GuiComponents.getNotificationMenu();
		
		for(Drawable d: graphics) {
			d.draw(g);
		}
		
		
		Font temp = g.getFont();
		reminderDateText.draw(g);
		ReminderDescription.draw(g);
		ReminderName.draw(g);
		titleText.draw(g);
		phoneText.draw(g);
		emailText.draw(g);
		g.setFont(temp);
		reminderImportanceText.draw(g);
		ReminderImportance.draw(g);
		createReminderButton.draw(g);
		ReminderDate.draw(g);
	}

	@Override
	public void changeOnHover(Point p) {
		
		ReminderImportance.changeOnHover(p);
		ReminderDescription.changeOnHover(p);
		ReminderName.changeOnHover(p);
		createReminderButton.changeOnHover(p);
		ReminderDate.changeOnHover(p);
	}

	@Override
	public void changeOnRelease(Point p) {
		ReminderImportance.changeOnRelease(p);
		ReminderDescription.changeOnRelease(p);
		ReminderName.changeOnRelease(p);
		createReminderButton.changeOnRelease(p);
		ReminderDate.changeOnRelease(p);
	}

	@Override
	public void changeOnClick(Point p) {
		ReminderImportance.changeOnClick(p);
		ReminderDescription.changeOnClick(p);
		ReminderName.changeOnClick(p);
		createReminderButton.changeOnClick(p);
		ReminderDate.changeOnClick(p);
	}
}
