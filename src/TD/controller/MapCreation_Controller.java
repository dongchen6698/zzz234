package TD.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import TD.model.MapCreation_Model;
import TD.view.MapCreation_View;

public class MapCreation_Controller {
	MapCreation_View theView;
    MapCreation_Model theModel;
    
    MapBox_Controller mbCon;
    MainScreen_Controller msCon;
    
    public MapCreation_Controller(){
    	
    }
    
	public MapCreation_Controller(MapCreation_View mcView, MapCreation_Model mcModel,MainScreen_Controller msCon) {
		this.theView = mcView;
		this.theModel = mcModel;
		this.msCon = msCon;
		this.theView.addButtonClickEventListner(new ButtonActionDetector());
	}
	
	/**
     * This class will perform action based on buttons pressed in Map Creation GUI.
     */
    class ButtonActionDetector implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempBtnStr = e.getActionCommand();
            if(e.getSource() instanceof JButton)
            {
                if(tempBtnStr.equals("Set Grid")){
                    int xC = theView.getColInput();
                    int yC = theView.getRowInput();                    
                    theView.setdisabledloadMapBTN();
                    mbCon = new MapBox_Controller();
                    mbCon.setXBlockCount(xC);
                    mbCon.setYBlockCount(yC);
                    mbCon.setGridArray();
                    theView.addGridMap(mbCon);
                    theView.disableSubmitButton();                   
                }
                
                if(tempBtnStr.equals("Entry Point")){
                    mbCon.setEntryPointFlag();
                }
                
                if(tempBtnStr.equals("Draw Path")){
                    mbCon.setPathPointFlag();
                }
                
                if(tempBtnStr.equals("Exit Point")){
                    mbCon.setExitPointFlag();
                }
                
                if(tempBtnStr.equals("Load Map")){
                    final JFileChooser  fileDialog = new JFileChooser("MapFiles/");
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("MapData File","dat");
                    fileDialog.addChoosableFileFilter(filter);
                    int returnVal = fileDialog.showOpenDialog(theView);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                       File file = fileDialog.getSelectedFile();
                       theView.setdisabledloadMapBTN();
                       mbCon = new MapBox_Controller();
                       if(theModel.readFile(mbCon, file.getName(), file)){
                        theView.addGridMap(mbCon);
                        theView.disableSubmitButton();
                        theView.disableLoadButton();
                       }else{
                           theView.displayMessage("Invalid Map File");
                       }
                    }
                }

                if(tempBtnStr.equals("Save Map")){
                    if(mbCon.validPath(mbCon.getMapGirdArray()).equals("Done")){
                        String file_name = theView.getFileName();
                        System.out.println("file "+file_name);
                        if(file_name == null){
                            
                        }else{
                            mbCon.saveMap(file_name);
                            theView.displayMessage("Thank You, Your Map is successfully saved with "+file_name);
                            theView.dispose();
                            msCon.setTopEnabled();
                        }
                    }else{
                        theView.displayMessage("Sorry, Your Path is invalid.");
                    }
                }

                if(tempBtnStr.equals("Exit")){
                    theView.dispose();
                    msCon.setTopEnabled();
                }
            }
        }
    }
    
    /**
     * This method will call setVisible() from View.
     */
    public void startMapCreation(){
        this.theView.setVisible(true);
    }
    
    /**
     * This method will call setXBlockCount(x) from Model.
     * @param x  the x to set
     */
    public void setXBlockCount(int x){
        theModel.setXBlockCount(x);
    }
    
    /**
     * This method will call setYBlockCount(y) from Model.
     * @param y the y to set
     */
    public void setYBlockCount(int y){
        theModel.setYBlockCount(y);
    }
    
    /**
     * This method will call getXBlockCount() from Model.
     * @return the x to get
     */
    public int getXBlockCount(){
        return theModel.getXBlockCount();
    }
    
    /**
     * This method will call getYBlockCount() from Model.
     * @return the y to get
     */
    public int getYBlockCount(){
        return theModel.getYBlockCount();
    }
}
