package TD.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import TD.model.MainScreen_Model;
import TD.model.MapChooser_Model;
import TD.model.MapCreation_Model;
import TD.view.MainScreen_View;
import TD.view.MapChooser_View;
import TD.view.MapCreation_View;
/**
 * This Class will bind and initialize Model-View of Main Screen Module.
 * @author AlexChen
 */
public class MainScreen_Controller {
	MainScreen_View theView;
	MainScreen_Model theModel;
	
	
	/**
     * This method initialize view and model object.
     * @param view MainScreen_View object
     * @param model MainScreen_Model object 
     */
	public MainScreen_Controller(MainScreen_View view, MainScreen_Model model){
		this.theView = view;
		this.theModel = model;
		this.theView.addButtonClickListener(new ButtonActionDetector());
	}
	
	/**
     * This method will call setTopEnabled() from view class.
     */
    public void setTopEnabled(){
        theView.setTopEnabled();
    }
    
    public void initMapCreationg_Controller(){
    	MapCreation_View mcView = new MapCreation_View();
        MapCreation_Model mcModel = new MapCreation_Model();
        mcView.setVisible(true);
        //theView.setEnabled(false);
        theView.setAlwaysOnTop(false);
        mcView.setAlwaysOnTop(true);
        mcView.setFocusable(true);
        MapCreation_Controller theMapCreation = new MapCreation_Controller(mcView, mcModel, this);
        theMapCreation.startMapCreation();
    }
	
	/**
     * This class will perform action based on button pressed on Main Screen.
     */
    class ButtonActionDetector implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempBtnStr = e.getActionCommand();
            if(e.getSource() instanceof JButton)
            {
                if(tempBtnStr.equals("Start Game")){
                    MapChooser_Model mcModel = new MapChooser_Model();
                    MapChooser_View mcView = new MapChooser_View(theView, mcModel.getMapFileList());
                    MapChooser_Controller mp = new MapChooser_Controller(mcView,mcModel);
                }

                if(tempBtnStr.equals("Creat Maps")){
                	initMapCreationg_Controller();
                }

                if(tempBtnStr.equals("EXIT GAME")){
                    theView.dispose();
                    System.exit(0);
                }
            }
        }
    }

}
