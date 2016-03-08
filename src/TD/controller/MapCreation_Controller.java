package TD.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
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
                if(tempBtnStr.equals("setMapBTN")){
                    int xC = theView.getRowInput();
                    int yC = theView.getColInput();
                    String errMsg = "";
                    if(xC == 0 || yC ==0){
                        errMsg += "Input is Invalid.";
                    }
                    if(xC < 7){
                        errMsg += "Sorry, Your Row Size is smaller than 7. Please use biger value.\n";
                    }
                    if(yC < 7){
                        errMsg += "Sorry, Your Col Size is smaller than 7. Please use biger value.\n";
                    }
                    if(xC > 20){
                        errMsg += "Sorry, Your Row Size is bigger than 20. Please use smaller value.\n";
                    }
                    if(yC > 15){
                        errMsg += "Sorry, Your Col Size is bigger than 15. Please use smaller value.\n";
                    }
                    
                    if(errMsg.equals("")){
                        theView.setdisabledloadMapBTN();
                        System.out.println("Map Grid is Created.");
                        mbCon = new MapBox_Controller();
                        mbCon.setXBlockCount(xC);
                        mbCon.setYBlockCount(yC);
                        mbCon.setGridArray();
                        theView.addGridMap(mbCon);
                        theView.disableSubmitButton();
                    }
                    else
                    {
                        LogGenerator.addLog("Invalid Map x,y parameter");
                        theView.displayMessage(errMsg);
                    }
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
                    LogGenerator.addLog("Load Map Initialized.");
                    System.out.println("Load Map: Clicked");
                    final JFileChooser  fileDialog = new JFileChooser();
                    FileFilter filter = new FileNameExtensionFilter("TDMap file", "txt");
                    fileDialog.addChoosableFileFilter(filter);
                    int returnVal = fileDialog.showOpenDialog(theView);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                       File file = fileDialog.getSelectedFile();
                       theView.setdisabledsubmitBtn();
                       mbCon = new MapBoxController();
                       LogGenerator.addLog("MapFile Selected By user : "+file.getName());
                       if(theModel.readFile(mbCon, file.getName(), file)){
                        System.out.println("Map Grid is Created from file.");
                        theView.addGridMap(mbCon);
                        theView.disableSubmitButton();
                        theView.disableLoadButton();
                        LogGenerator.addLog("Loadded Map is Valid");
                       }else{
                           LogGenerator.addLog("Loadded Map is inalid");
                           theView.displayMessage("Invalid Map File");
                       }
                    }
                    else{
                       //theView.displayMessage("Open command cancelled by user." );           
                    } 
                }

                if(tempBtnStr.equals("Save Map")){
                    LogGenerator.addLog("User wants to save map.");
                    System.out.println("Save Clicked");
                    if(mbCon.validPath(mbCon.getMapGirdArray()).equals("Done")){
                        LogGenerator.addLog("User edited map is valid.");
                        String file_name = theView.getFileName();
                        System.out.println("file "+file_name);
                        if(file_name == null){
                            
                        }else if(file_name.isEmpty()){
                             Date date = new Date();
                             SimpleDateFormat ft =  new SimpleDateFormat ("dd.MM.yyyy hh_mm_ss a");
                            System.out.println(""+ft.format(date));
                            mbCon.saveMap(ft.format(date));
                            theView.displayMessage("Thank You, Your Map is successfully saved with "+ft.format(date));
                            theView.dispose();
                            msCon.setTopEnabled();
                            LogGenerator.addLog("MapFile saved as : "+ft.format(date));
                        }else{
                            mbCon.saveMap(file_name);
                            theView.displayMessage("Thank You, Your Map is successfully saved with "+file_name);
                            theView.dispose();
                            msCon.setTopEnabled();
                            LogGenerator.addLog("MapFile saved as : "+file_name);
                        }
                    }else{
                        LogGenerator.addLog("User edited map is not valid.");
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
