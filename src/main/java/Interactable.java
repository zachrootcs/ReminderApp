
import java.awt.Point;

public interface Interactable extends Drawable{
	public void changeOnHover(Point p);
	public void changeOnRelease(Point p);
	public void changeOnClick(Point p);
	
}
