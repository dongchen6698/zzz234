package TD.model;

import java.text.ParseException;

import TD.controller.GridCell_Controller;
import TD.zz.config.ConfigModel;

/**
 * This is model class of Cell Container
 * @author peilin
 */
public class CellContainer_Model {
    private int xC = 10;
    private int yC = 10;
    private int cellPixels = 44;
    
    public static GridCell_Model[][] gcModel;
    
    /**
     * this method is constructor for Cell Container Model. It will set xC and xY.
     * @param yC the y coordinate
     * @param xC the x coordinate
     */
    public CellContainer_Model(int yC, int xC) {
        this.xC = xC;
        this.yC = yC;
        gcModel = new GridCell_Model[yC][xC];
        
        for(int y=0;y<gcModel.length;y++){
            for(int x=0;x<gcModel[0].length;x++){
                gcModel[y][x] = new GridCell_Model(x*cellPixels+10, y*cellPixels+10, cellPixels, cellPixels, ConfigModel.groundGrass, ConfigModel.airAir);
            }
        }
    }
    
    /**
     * this method is constructor for Cell Container Model. It will set xC and xY.
     * @param yC the y coordinate
     * @param xC the x coordinate
     * @return successFlag
     */
    public boolean setCellContainerModel(int yC, int xC){
    	this.xC = xC;
        this.yC = yC;
        gcModel = new GridCell_Model[yC][xC];
        
        for(int y=0;y<gcModel.length;y++){
            for(int x=0;x<gcModel[0].length;x++){
                gcModel[y][x] = new GridCell_Model(x*cellPixels+10, y*cellPixels+10, cellPixels, cellPixels, ConfigModel.groundGrass, ConfigModel.airAir);
            }
        }
        return true;
    }
    
    /**
     * Creation of creatures.
     * @param cModel array of creatures object
     */
    public void physic(Creature_Model[] cModel) throws ParseException{
        for(int y=0;y<gcModel.length;y++){
            for(int x=0;x<gcModel[0].length;x++){
                gcModel[y][x].physic(cModel);
            }
        }
    }

    /**
     * @return the xC
     */
    public int getxC() {
        return xC;
    }

    /**
     * @param xC the xC to set
     */
    public void setxC(int xC) {
        this.xC = xC;
    }

    /**
     * @return the yC
     */
    public int getyC() {
        return yC;
    }

    /**
     * @param yC the yC to set
     */
    public void setyC(int yC) {
        this.yC = yC;
    }

    /**
     * @return the gcModel
     */
    public GridCell_Model[][] getGcModel() {
        return gcModel;
    }
    
    /**
     * @return the gcModel
     * @param x xCo-ordinates
     * @param y yCo-ordinates
     */
    public GridCell_Model getGcModelObj(int y, int x) {
        return gcModel[y][x];
    }
    
    /**
     * this method will set gid and airId for gcModel object
     * @param x xCo-ordinates
     * @param y yCo-ordinates
     * @param gVal the gVal
     * @param airVal the airVal
     */
    public void setGcModelObj(int y, int x, int gVal, int airVal) {
        gcModel[y][x].setgID(gVal);
        gcModel[y][x].setAirID(airVal);
    }
}
