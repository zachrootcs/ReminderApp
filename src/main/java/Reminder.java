
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

public class Reminder extends Button implements Comparable{
	public int levelOfImportance;
	public Date dueDate;
	public String reminderName;
	public String reminderText;
	private Button reminderButton;
	private Button exitButton;
	static int reminderNum = 1;
	public static String sortType;
	
	public Reminder(String reminderName, String reminderText, Date dueDate, int levelOfImportance) {
		
		super(ReminderList.getNextRect(), 
				GuiComponents.BACKGROUND_COLOR, "Reminder " + reminderNum, reminderName);
		
		this.reminderText = reminderText;
		this.dueDate = dueDate;
		this.levelOfImportance = levelOfImportance;
		
		if(reminderName.equals("")) {
			this.reminderName = "Reminder " + reminderNum;
			this.title = this.reminderName;
		}else {
			this.reminderName = reminderName;
		}
	
		reminderNum++;
		ReminderList.addReminder(this);
		
		Rectangle rect = this.rect;
		Rectangle exitButtonRect = new Rectangle(rect.x+120,rect.y+2,75,25);
		exitButton = new Button(exitButtonRect,GuiComponents.ButtonColor,this.toString(), "        Remove");

	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		Rectangle rect = this.rect;
		Rectangle exitButtonRect = new Rectangle(rect.x+120,rect.y+2,75,25);
		exitButton = new Button(exitButtonRect,GuiComponents.ButtonColor,this.toString(), "        Remove");
		
		exitButton.draw(g);
	}

	public void changeOnHover(Point p) {
		super.changeOnHover(p);
		exitButton.changeOnHover(p);
	}
	
	public void changeOnRelease(Point p) {
		super.changeOnRelease(p);
		exitButton.changeOnRelease(p);
	
	}
	

	public void changeOnClick(Point p) {
		
		super.changeOnClick(p);
		exitButton.changeOnClick(p);
		
	
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(sortType.equals("Importance")) {
			return ((Integer)(this.levelOfImportance)).compareTo((Integer)((Reminder)o).levelOfImportance);
		}
		return this.dueDate.compareTo(((Reminder)o).dueDate);
		
	}
	
	
}
