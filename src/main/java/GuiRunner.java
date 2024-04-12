import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiRunner extends JPanel{
	
	
	public final static int windowSizeX=1000;
	public final static int windowSizeY=1000;

	private static Point mouseReleasedPoint;
	private static Point mousePressedPoint;
	public static Graphics window;
	
	LinkedList<Drawable[]> graphicsList;
	
	public GuiRunner() {
		
	}
	
	public void paint(Graphics g) {
		
		graphicsList = GuiComponents.getGraphicsList();
		
	
	      Graphics2D g2 = (Graphics2D)g;
	      
	      for(Drawable[] drawableArr: graphicsList) {
	    	  
	    	  for(Drawable d: drawableArr) {
	  	 
	    		  if(d instanceof Interactable) {
	    			  Interactable f = (Interactable)d;
	    			  f.changeOnClick(mousePressedPoint);
				      f.changeOnRelease(mouseReleasedPoint);
				      f.changeOnHover(getMousePosition());
				      f.draw(g2);
	    		  }else {
				      d.draw(g2);
	    		  }
		    	
			      
		      }  
	      }
	      
	     
	    
	      
	   }
	
	public static void mouseReleasedHandler(Point p) {
		mouseReleasedPoint = p;
		//System.out.println(p);
	}

	public static void mousePressedHandler(Point p) {
		mousePressedPoint = p;
	//	System.out.println(p);
	}
	
	
	
	public static void main(String[] args) {
		
		InputListener m = new InputListener();
		JFrame f = new JFrame("Reminder App");
		
		f.addMouseListener(m);
		
		f.addKeyListener(m);
	    f.getContentPane().add(new GuiRunner());
	    f.setSize(windowSizeX, windowSizeY);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    while(true) {
	    	f.repaint();
	    }
	    
	}

}

/*


g2.setRenderingHint(
RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

Font font = new Font("Serif", Font.PLAIN, 96);
g2.setFont(font);
g2.drawString("YO", 40, 120);


*/