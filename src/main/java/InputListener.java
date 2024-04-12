
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputListener implements MouseListener, KeyListener{

	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY()-29);
		GuiRunner.mousePressedHandler(p);
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Point p = new Point(e.getX(),e.getY()-29);
		GuiRunner.mouseReleasedHandler(p);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==16) return;
		if((int)(e.getKeyChar())==8){
			GuiComponents.keyboardInput = GuiComponents.keyboardInput.substring(0,GuiComponents.keyboardInput.length()-1);
		}else if((int)(e.getKeyChar())==10){
			GuiComponents.keyboardEntered = GuiComponents.keyboardInput;
			GuiComponents.keyboardInput = "";
			GuiComponents.commandSet.add(GuiComponents.currentKeyboardCommand);
		}else {
			GuiComponents.keyboardInput+=e.getKeyChar();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
