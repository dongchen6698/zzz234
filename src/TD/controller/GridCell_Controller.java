package TD.controller;

import java.awt.Graphics;
import TD.model.GridCell_Model;
import TD.view.GridCell_View;

/**
 * This Class will bind and initialize Model-View of Play Screen Module.
 * @author peilin
 */
public class GridCell_Controller {

    GridCell_View theView;
    GridCell_Model[][] theModel;
   
    /**
     * This method will set GridCellView and GridCellModel
     * @param gcView the GridCellView
     * @param gcModel the GridCellModel
     */
    public GridCell_Controller(GridCell_View gcView, GridCell_Model[][] gcModel) {
        this.theModel = gcModel;
        this.theView = gcView;
    }
    
    /**
     * This method will call fireRangeOutline() method of Cell Container view
     * @param gcModelObj the GridCellModel
     * @param g the Graphics
     */
    public void getfireRangeOutline(GridCell_Model gcModelObj, Graphics g){
        this.theView.fireRangeOutline(gcModelObj, g);
    }
    
    /**
     * This method will call draw() method of Cell Container view
     * @param g the Graphics
     * @param gcModelObj the GridCellModel
     */
    public void getDraw(GridCell_Model gcModelObj, Graphics g) {
        this.theView.draw(gcModelObj,g);
    }
}
