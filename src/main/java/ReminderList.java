
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ReminderList implements Interactable{

	
	public static LinkedList<Reminder> reminders = new LinkedList<>();

	
 	private static int xPos;
	private static int yPos;
	private static int reminderButtonSpacing = -40;
	
	public ReminderList(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		
	}
	@Override
	public void draw(Graphics g) {
		Color tempColor = g.getColor();
		g.setColor(GuiComponents.BACKGROUND_COLOR);
		g.fill3DRect(xPos, yPos, 200, 400, false);
		
		for(Reminder r: reminders) {
			r.draw(g);
		}
		
		g.setColor(tempColor);
	}

	@Override
	public void changeOnHover(Point p) {
		for(Reminder r: reminders) {
			r.changeOnHover(p);
			
		}
		
	}

	@Override
	public void changeOnRelease(Point p) {
		for(Reminder r: reminders) {
			r.changeOnRelease(p);
		}
		
	}

	@Override
	public void changeOnClick(Point p) {
		for(Reminder r: reminders) {
			r.changeOnClick(p);
		}
		
	}
	public static void addReminder(Reminder r) {
		reminders.add(r);
		
		
		
	}
	public static Rectangle getNextRect() {
		reminderButtonSpacing+=45;
		return new Rectangle(xPos+5,yPos+5+reminderButtonSpacing, 120, 30);
		
	}
	
	public static Reminder getReminderFromAction(String action) {
		for(Reminder r: reminders) {
			if(r.action.equals(action)) {
				return r;
			}
		}
		return null;
	}
	public static void sortByDueDate() {
		Reminder.sortType = "DueDate";
		Collections.sort(reminders);
		reminderButtonSpacing = -40;
		for(Reminder r: reminders) {
			r.setRect(getNextRect());
		}
		return;
	}
	public static void sortByImportance() {
		Reminder.sortType = "Importance";
		Collections.sort(reminders);
		Collections.reverse(reminders);
		reminderButtonSpacing = -40;
		for(Reminder r: reminders) {
			r.setRect(getNextRect());
		}
		
		return;
	}
	public static Reminder getReminderFromString(String s) {
		for(Reminder r: reminders) {
			if(r.toString().equals(s)) {
				return r;
			}
		}
		return null;
	}
	public static void remove(Reminder r) {
		reminders.remove(r);

		
	}
	
}
