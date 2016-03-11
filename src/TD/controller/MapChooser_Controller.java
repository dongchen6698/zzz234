package TD.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import TD.model.MapChooser_Model;
import TD.model.PlayScreen_Model;
import TD.view.MapChooser_View;
import TowerDefenceGame.GamePlay;

/**
 * This Class will bind and initialize Model-View of Map Chooser Module.
 * @author peilin
 */
public class MapChooser_Controller {

    MapChooser_View theView = new MapChooser_View();
    MapChooser_Model theModel = new MapChooser_Model();
    
    /**
     * This is constructor of Map Chooser.
     * @param mcView the MapChooserView
     * @param mcModel the MapChooserModel
     */
    MapChooser_Controller(MapChooser_View mcView, MapChooser_Model mcModel) {
        this.theView = mcView;
        this.theModel = mcModel;
        this.theView.addButtonClickEventListner(new ButtonActionDetector());
    }
    
    /**
     * This method will call getMapFileList() from model.
     * @return the String array of MapFiles.
     */
    public String[] getMapFileList(){
        return theModel.getMapFileList();
    }
    
    /**
     * This class will perform action based on buttons pressed in Map Chooser.
     */
    class ButtonActionDetector implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempBtnStr = e.getActionCommand();
            if(e.getSource() instanceof JButton)
            {
                if(tempBtnStr.equals("Start game")){
                    if(theView.getSelectedFile().equals("NONE")){
                        theView.displayMessage("Please Select At least one file.");
                    }else{
                        PlayScreen_Model psModel = new PlayScreen_Model();
                        boolean temp = psModel.LoadMap(new File("MapFiles/"+theView.getSelectedFile()));
                        //System.out.println(temp);
                        if(temp){
                            GamePlay gp = new GamePlay(new File("MapFiles/"+theView.getSelectedFile()), psModel.getxC(), psModel.getyC());
                            theView.setMSTOp(false);
                            theView.dispose();
                        }
                        else{
                            theView.displayMessage("Incorrect Map File");
                        }
                        
                    }
                }
            }
        }
    }

}