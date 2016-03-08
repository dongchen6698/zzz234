package TowerDefenceGame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import TD.model.ConfigModel;

/**
 * This class will take input from user via mouse and trigger the appropriate function.
 * 
 */
public class KeyController extends Observable implements MouseMotionListener, MouseListener {

    /**
     * This Method will listen mouse dragged movement and store x,y coordinates in point variable.
     * @param e the MouseEvent
     */
    public void mouseDragged(MouseEvent e) {
        ConfigModel.mse = new Point((e.getX()) - 4, e.getY() - 25);
    }

    /**
     * This Method will listen mouse moved movement and store x,y coordinates in point variable.
     * @param e the MouseEvent
     */
    public void mouseMoved(MouseEvent e) {
        ConfigModel.mse = new Point((e.getX()) - 4, e.getY() - 25);
    }

    
    public void mouseClicked(MouseEvent e) {
        
    }

    /**
     * This Method will listen mouse pressed movement and call appropriate method;
     * @param e the MouseEvent
     */
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
	    {
                setChanged();
                notifyObservers("1");
	    }	    
	    else if(e.getButton() == MouseEvent.BUTTON3)
	    {
                setChanged();
                notifyObservers("0");
	    }
        
    }

    
    public void mouseReleased(MouseEvent e) {
        
    }

    
    public void mouseEntered(MouseEvent e) {
        
    }

    
    public void mouseExited(MouseEvent e) {
        
    }
    
}
