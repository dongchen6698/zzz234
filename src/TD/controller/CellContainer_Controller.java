package TD.controller;

import java.awt.Graphics;
import TD.model.CellContainer_Model;
import TD.model.GridCell_Model;
import TD.view.CellContainer_View;

/**
 * This is controller class for Grid Cell Container.
 * 
 */
public class CellContainer_Controller {

    CellContainer_Model theModel;
    CellContainer_View theView;
    private GridCell_Model[][] gcModel;
    private GridCell_Controller gcCont;
    /**
     * This method will initialize and bind View and model of Grid Cell Container moduel.
     * @param ccView the view object of Cell Container
     * @param ccModel the model object of Cell Container.
     */
    public CellContainer_Controller(CellContainer_View ccView, CellContainer_Model ccModel) {
        this.theModel = ccModel;
        this.theView = ccView;
    }
    
    /**
     * this method will set view object.
     * @param ccView the ccView to set
     */
    public void setCCView(CellContainer_View ccView){
        theView = ccView;
    }
    
    /**
     * this method will set model object.
     * @param ccModel  the ccModel to set
     */
    public void setCCModel(CellContainer_Model ccModel){
        theModel = ccModel;
    }
    
    /**
     * this method will return view object.
     * @return the view object
     */
    public CellContainer_View getCCView(){
        return theView;
    }
    
    /**
     * this method will return model object.
     * @return the model object
     */
    public CellContainer_Model getCCModel(){
        return theModel;
    }
    
    /**
     * @return the xC
     */
    public int getxC() {
        return theModel.getxC();
    }

    /**
     * @param xC the xC to set
     */
    public void setxC(int xC) {
        theModel.setxC(xC);
    }

    /**
     * @return the yC
     */
    public int getyC() {
        return theModel.getyC();
    }

    /**
     * @param yC the yC to set
     */
    public void setyC(int yC) {
        theModel.setyC(yC);
    }

    /**
     * this method will set model object of Grid Cell Model.
     * @param gcModel  the gcModel to set
     */
    public void setgCModel(GridCell_Model[][] gcModel) {
        this.gcModel = gcModel;
    }

    /**
     * this method will set Grid Cell Controller object.
     * @param gcCont  the Grid Cell Controller object
     */
    public void setgcCont(GridCell_Controller gcCont) {
        this.gcCont = gcCont;
        this.gcModel = gcCont.theModel;
    }
    
    /**
     * this method will return Grid Cell Controller object.
     * @return the Grid Cell Controller object
     */
    public GridCell_Controller getgcCont() {
        return gcCont;
    }
    
    /**
     * this method will return Grid Cell Controller object based on x and y.
     * @return the Grid Cell Controller object
     * @param y the y coordinate
     * @param x the x coordinate
     */
    public GridCell_Model getgcModelObj(int y, int x){
            return theModel.getGcModelObj(y, x);
    }
    
    /**
     * this method will call draw() from view class
     * @param g the Graphics
     */
    public void getDraw(Graphics g){
        if(theView != null)
            theView.draw(g);
    }
}
