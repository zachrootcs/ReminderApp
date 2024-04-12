
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;


import java.util.Random;
import java.util.Set;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
public class GuiComponents {
	
	
	public static Set<String> commandSet = new HashSet<>();
	
	
	public static Color BACKGROUND_COLOR = new Color(220,234,229);
	public static Color BODY_COLOR = new Color(170,188,182);
	
	//public static Color ButtonColor =  new Color(150,199,186);
	public static Color ButtonColor =  new Color(219, 240, 226);
	
	public static String currentKeyboardCommand = "";
	public static String keyboardInput = "";
	public static String keyboardEntered = "";
	
	public static String reminderDescription = "";
	public static String reminderName = "";
	public static Date reminderDate = new Date();
	public static int reminderImportance = 0;

	public static String emailEntered = "";
	public static Drawable[] getHeader() {
		Drawable[] header = new Drawable[3];
		header[0] = new DrawableRect(new Rectangle(0,0,GuiRunner.windowSizeX, GuiRunner.windowSizeY), BACKGROUND_COLOR);
		
		header[1] = new DrawableRect(new Rectangle(50,40,800,50), ButtonColor);
		header[2] = new DrawableString("Reminder App", 75,80,45);
		
		
		return header;
	}
	
	public static Drawable[] getBody() {
		Drawable[] body = new Drawable[4];
		body[0] = new DrawableRect(new Rectangle(100,100,700,600), BODY_COLOR);
		body[1] = new ReminderList(200,200);
		body[2] = new Button(new Rectangle(200,600,100,30),ButtonColor, "SortImportance", "Sort Importance");
		body[3] = new Button(new Rectangle(300,600,100,30),ButtonColor, "SortDueDate", "SortDueDate");
		return body;
	}
	
	public static Drawable[] getFooter() {
		Drawable[] footer = new Drawable[3];
		footer[0] = new Button(new Rectangle(450,300,120,30), ButtonColor,"NotificationMenu","Notification Menu");
		footer[1] = new Button(new Rectangle(450,350,120,30), ButtonColor,"AppearanceMenu", "Appearance Menu");
		footer[2] = new Button(new Rectangle(450,400,120,30), ButtonColor,"ReminderMenu","Add Reminder");
		
		return footer;
	}
	public static Drawable[] getGrid() {
		Random rand = new Random();
		
		
		Drawable[] grid = new Drawable[100];
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				float r = (float)(rand.nextFloat()*0.25);
				float g = (float)(rand.nextFloat()*0.25);
				float b = (float)(rand.nextFloat()*0.25);
				grid[j+10*i] = new DrawableRect(new Rectangle(i*100, j*100,100,100),new Color(r,g,b));
				
				
			}
		}
		
		
		return grid;
	}
	
	public static Drawable[] getAppearanceMenu() {
		
		Drawable[] AppearanceMenuDrawable = new Drawable[1];
		AppearanceMenuDrawable[0] = new DrawableRect(new Rectangle(AppearanceMenu.xPos,AppearanceMenu.yPos,200,300), BODY_COLOR.brighter());
	
		return AppearanceMenuDrawable;
	}
	public static Drawable[] getNotificationMenu() {
		
		Drawable[] NotificationMenuDrawable = new Drawable[1];
		NotificationMenuDrawable[0] = new DrawableRect(new Rectangle(NotificationMenu.xPos,NotificationMenu.yPos,200,300), BODY_COLOR.brighter());
		
		
		return NotificationMenuDrawable;
	}
	
	
	public static LinkedList<Drawable[]> getGraphicsList() {
		
		LinkedList<Drawable[]> graphicsList = new LinkedList<Drawable[]>();
		
		graphicsList.add(getHeader());
		graphicsList.add(getBody());
		
		if(commandSet.contains("SortDueDate")) {
			ReminderList.sortByDueDate();
			System.out.println("Sort");
			commandSet.remove("SortDueDate");
		}
		if(commandSet.contains("SortImportance")) {
			ReminderList.sortByImportance();
			System.out.println("SortImp");
			commandSet.remove("SortImportance");
		}
		if(commandSet.contains("AppearanceMenu")) {
			graphicsList.add(new Drawable[] {new AppearanceMenu()});
		}
		if(commandSet.contains("CycleAppearance")) {
			GuiComponents.cycleAppearance();
			commandSet.remove("CycleAppearance");
		}
		if(commandSet.contains("NotificationMenu")) {
			
			graphicsList.add(new Drawable[] {new NotificationMenu()});
			
		}
		if(commandSet.contains("ReminderMenu")) {
			graphicsList.add(new Drawable[] {new ReminderMenu()});
		}
		if(commandSet.contains("Background COLOR")) {
			
			
				int[] rgb = new int[3];
				String[] rgbStrings = keyboardEntered.split(" ");
				keyboardEntered = "";
				
				try {
					for(int i = 0; i<3; i++) {
						rgb[i] = Integer.parseInt(rgbStrings[i]);
					}
					BACKGROUND_COLOR = new Color(rgb[0],rgb[1], rgb[2]);
				}catch(Exception e){
					
				}
			commandSet.remove("Background COLOR");
		}
		if(commandSet.contains("Body COLOR")) {
			
			try {
				int[] rgb = new int[3];
				String[] rgbStrings = keyboardEntered.split(" ");
				keyboardEntered = "";
				for(int i = 0; i<3; i++) {
					rgb[i] = Integer.parseInt(rgbStrings[i]);
				}
				
				BODY_COLOR = new Color(rgb[0],rgb[1], rgb[2]);
			
			}catch(Exception e){
				
			}
		
			commandSet.remove("Body COLOR");
		}
		//Button COLOR
	if(commandSet.contains("Button COLOR")) {
			
			try {
				int[] rgb = new int[3];
				String[] rgbStrings = keyboardEntered.split(" ");
				keyboardEntered = "";
				for(int i = 0; i<3; i++) {
					rgb[i] = Integer.parseInt(rgbStrings[i]);
				}
				
				ButtonColor = new Color(rgb[0],rgb[1], rgb[2]);
				
			}catch(Exception e){
				
			}
		
			commandSet.remove("Body COLOR");
		}
		if(commandSet.contains("Create Reminder")) {
			
			Reminder reminder = new Reminder(reminderName,reminderDescription,reminderDate,reminderImportance);
			commandSet.remove("Create Reminder");
		}
		if(commandSet.contains("Reminder Name")) {
			reminderName = keyboardEntered;
			keyboardEntered = "";
			commandSet.remove("Reminder Name");
		}
		
		if(commandSet.contains("Reminder Description")) {
			reminderDescription = keyboardEntered;
			keyboardEntered = "";
			commandSet.remove("Reminder Description");
		}
		if(commandSet.contains("Email Input")) {
			emailEntered = keyboardEntered;
			keyboardEntered = "";
			commandSet.remove("Email Input");
		}
		if(commandSet.contains("Phone Input")) {
			System.out.println("Phone Input");
			commandSet.remove("Phone Input");
		}
		if(commandSet.contains("Reminder Date")) {
			String[] arr = keyboardEntered.split("/");
			int[] dateNums = new int[3];
			
			try {
				for(int i = 0; i<3; i++) {
					
					dateNums[i] = Integer.parseInt(arr[i]);
				}
			}catch(Exception e) {
				dateNums = new int[] {1,1,1};
			}
			
			Calendar  cal = Calendar.getInstance();
			cal.set(dateNums[2], dateNums[0]-1, dateNums[1]);
			
			reminderDate = cal.getTime();
			
			System.out.println(reminderDate);
			commandSet.remove("Reminder Date");
		}
		
		//System.out.println(commandList);
		//graphicsList.add(GuiComponents.getGrid());
		if(commandSet.contains("Reminder Importance")) {
			try {
				reminderImportance = Integer.parseInt(keyboardEntered);
			}catch(Exception e) {
				
			}
			
			keyboardEntered  = "";
			System.out.println(reminderImportance);
			commandSet.remove("Reminder Importance");
		}
		for(String s: commandSet) {
			Reminder r = ReminderList.getReminderFromAction(s);
			if(r!=null) {
				
				DrawableRect rect = new DrawableRect(new Rectangle(500,120,290,150),BACKGROUND_COLOR);
				DrawableString strTitle = new DrawableString("Reminder Title: "+r.title,500,150,25);
				DrawableString strDesc = new DrawableString("Reminder Description:" +r.reminderText,500,200,15);
				DrawableString strDate = new DrawableString("Reminder Date: "+r.dueDate.toString(),500,225,15);
				DrawableString strimp = new DrawableString("Reminder Importance:" +r.levelOfImportance,500,250,15);
				
				graphicsList.add(new Drawable[]{rect,strTitle,strDesc,strDate,strimp});
			}
		}
		for(String s: commandSet) {
			Reminder r = ReminderList.getReminderFromString(s);
			if(r!=null) {
				ReminderList.remove(r);
			}
		}
		graphicsList.add(getFooter());
		if(commandSet.contains("Send Reminder")) {
			try {
				SendEmail.sendEmail("");
			} catch (IOException e) {
				e.printStackTrace();
			}
			commandSet.remove("Send Reminder");
		}
	
		return graphicsList;
		
	}
	
	public static void cycleAppearance() {
		BACKGROUND_COLOR = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		ButtonColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		BODY_COLOR =new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
	}
}
