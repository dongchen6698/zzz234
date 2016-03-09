package TD.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JButton;
import javax.swing.JComponent;

import TD.mapValidation.MapValidation;
import TD.model.MapBox_Model;
import TD.view.MapBox_View;

/**
 * This Class will bind and initialize Model-View of Map Box Module.
 * @author AlexChen
 */
public class MapBox_Controller {
    
    MapBox_View theView;
    MapBox_Model theModel;
    
    /**
     * This method is constructor.
     */
    public MapBox_Controller(){
        this.theModel = new MapBox_Model();
        this.theView = new MapBox_View(this);
    }
    
    /**
     * This method will return MapBoxView object
     * @return MapBoxView object
     */
    public MapBox_View getView(){
        return this.theView = new MapBox_View(this,theModel.getXBlockCount(),theModel.getYBlockCount());
    }
    
    /**
     * This method will set MapBoxView object
     * @param mbView the MapBoxView object
     */
    public void updateView(MapBox_View mbView){
        this.theView = mbView;
    }
    
    /**
     * This method will call getXBlockCount() from MapBoxModel
     * @return xBockCount
     */
    public int getXBlockCount(){
        return theModel.getXBlockCount();
    }
    
    /**
     * This method will call getYBlockCount() from MapBoxModel
     * @return yBockCount
     */
    public int getYBlockCount(){
        return theModel.getYBlockCount();
    }
    
    /**
     * This method will call setXBlockCount() from MapBoxModel and set xBlockCount
     * @param x xBockCount
     */
    public void setXBlockCount(int x){
        theModel.setXBlockCount(x);
    }
    
    /**
     * This method will call setYBlockCount() from MapBoxModel and set yBlockCount
     * @param y yBockCount
     */
    public void setYBlockCount(int y){
        theModel.setYBlockCount(y);
    }
    
    /**
     * This method will call setGridArray() from MapBoxModel
     */
    public void setGridArray(){
        theModel.setGridArray();
    }
    
     /**
     * This method will call setEntryPointFlag() from MapBoxView
     */
    public void setEntryPointFlag(){
        theView.setEntryPointFlag();
    }
    
    /**
     * This method will call setPathPointFlag() from MapBoxView
     */
    public void setPathPointFlag(){
        theView.setPathPointFlag();
    }
    
    /**
     * This method will call setExitPointFlag() from MapBoxView
     */
    public void setExitPointFlag(){
        theView.setExitPointFlag();
    }

    /**
     * This method will add Button action listener
     */
    public void setBtnGridClickListner() {
        this.theView.addButtonClickEventListner(new ButtonActionDetector());
    }
    
    /**
     * This method will return Exit Point(y index) and call getExitPointData() from MapBoxModel
     * @return the Exit Point(y index)
     */
    public int getExitPointData(){
        return this.theModel.getExitPointData();
    }
    
    /**
     * This method will return Entry Point(y index) and call getEntryPointData() from MapBoxModel
     * @return the Entry Point(y index)
     */
    public int getEentryPointData(){
        return this.theModel.getEntryPointData();
    }
    
    /**
     * This method will return Map Gird Array and call getMapGirdArray() from MapBoxModel
     * @return Map Gird Array 
     */
    public int[][] getMapGirdArray(){
        return this.theModel.getMapGirdArray();
    }
    
    /**
     * this method will set cell value with respect to x,y index in grid cell array
     * @param y y index
     * @param x x index
     * @param val value of cell
     */
    public void setmapGirdArrayElement(int y, int x, int val){
        this.theModel.setmapGirdArrayElement(y, x, val);
    }
    
    /**
     * this method will set cell value with respect to x,y index in grid cell array
     * @param y y index
     * @param x x index
     * @param val value of cell
     */
    public void setmapGirdArrayElementF(int y, int x, int val){
        this.theModel.setmapGirdArrayElementF(y, x, val);
    }
    
    /**
     * this method will return cell value with respect to x,y index of grid cell array
     * @param x x index
     * @param y y index
     * @return cell value
     */
    public int getmapGirdArrayElement(int x, int y){
        return this.theModel.getmapGirdArrayElement(x, y);
    }
    
    /**
     * this method will return file load flag
     * @return the file load flag
     */
    public boolean getFileFlag(){
        return this.theModel.getFileFlag();
    }
    
    /**
     * This method will set File Flag 
     * @param b the file flag
     */
    public void setFileFlag(boolean b){
        this.theModel.setFileFlag(b);
    }

    /**
     * This method will validate user path.
     * @param ga the Grid array
     * @return the valid flag
     */
    public String validPath(int[][] ga){
        MapValidation mapV = new MapValidation(ga);
        System.out.println("Path Validation: "+mapV.isValid());
        if(mapV.isValid()){
            return "Done";
        }else{
            return "Invalid";
        }
    }
    
    /**
     * This method will save map in file.
     * @param str file name
     */
    public void saveMap(String str){
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("MapFiles/"+str+".dat"), "utf-8"));
            writer.write(theModel.getXBlockCount()+" "+theModel.getYBlockCount());
            writer.write(System.getProperty("line.separator"));
            for(int y=0;y<theModel.getYBlockCount();y++){
                for(int x=0;x<theModel.getXBlockCount();x++){                
                    writer.write(theModel.getmapGirdArrayElement(y, x)+" ");
                }
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
        } finally {
           try {writer.close();} catch (Exception ex) {}
        }
    }
    
    /**
     * This class will perform action based on buttons pressed in Map Box GUI.
     */
    class ButtonActionDetector implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempBtnStr = e.getActionCommand();
            if(e.getSource() instanceof JButton)
            {
                String btnName = ((JComponent)e.getSource()).getName();
                System.out.println("You Clicked Grid."+btnName);
                String[] temp = new String[2];
                temp = btnName.split("_");
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);
                System.out.println("X: "+x+" Y:"+y);
                if(x==0){
                    theView.setEntryPoint(y, x);
                    theModel.setmapGirdArrayElement( y, x, 7);
                }else if(x==(theModel.getXBlockCount()-1)){
                    theView.setExitPoint(y, x);
                    theModel.setmapGirdArrayElement( y, x, 8);
                }else if(x>0 && y <= (theModel.getYBlockCount())){
                    theModel.setmapGirdArrayElement( y, x, 1);
                    theView.setPathPoint(y, x);
                }
            }
        }
    }
}

