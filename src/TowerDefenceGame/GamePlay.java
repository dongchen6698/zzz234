package TowerDefenceGame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import TD.config.ConfigModel;
import TD.controller.PlayScreen_Controller;
import TD.mapValidation.MapValidation;
import TD.model.CellContainer_Model;
import TD.model.GridCell_Model;
import TD.model.PlayScreen_Model;
import TD.model.Shop_Model;
import TD.view.CellContainer_View;
import TD.view.GridCell_View;
import TD.view.PlayScreen_View;
import TD.view.Shop_View;


/**
 * This class initialize the game play screen.
 * 
 */
public class GamePlay extends JFrame implements WindowListener {
    
    private PlayScreen_Controller psCont;
    /**
     * This method will initialize JFrame and set some basic properties(Title, Size, Background Color, Location).
     * @param f Map file which is selected by user from list box.
     * @param w Width of Play screen based on map size
     * @param h Height of Play screen based on map size
     */
    public GamePlay(File f, int w, int h)
    {
        int width = w*40 + 350;
        int height = h*40 + 120;
        this.setTitle("Tower Defence Game");
        this.setSize(width,height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setBackground(Color.darkGray);
        init_elements(f);
        this.addWindowListener(this);
    }
    
    /**
     * This method will check the Map file and based on the type of map, it will bind the model to the controller and create the play view using the View.
     * @param f Map file which is selected by user from list box.
     */
    public void init_elements(File f)
    {
        this.setLayout(new GridLayout(1, 1, 0, 0));
        
        PlayScreen_Model psModel = new PlayScreen_Model();
                        boolean temp = psModel.LoadMap(f);
                        if(temp){
                            MapValidation mv = new MapValidation(psModel.getGridCellArray());
                            if(mv.isValid()){
                                System.out.println("Map is Valid");
                                ConfigModel cModel = new ConfigModel(); 
                            
                                psModel.initCellContainerModel();
                                psModel.setGridCellVal();

                                Shop_Model sModel = new Shop_Model(psModel.getStartX(),psModel.getStartY());
                                Shop_View sView = new Shop_View();

                                CellContainer_View ccView = new CellContainer_View();
                                CellContainer_Model ccModel = psModel.getCellContainer_Model();

                                GridCell_View gcView = new GridCell_View();
                                GridCell_Model[][] gcModel = ccModel.getGcModel();

                                PlayScreen_View psView = new PlayScreen_View(this);
                                add(psView);
                                psCont = new PlayScreen_Controller(psView, psModel, gcView, gcModel, ccView, ccModel, sView, sModel);
                                psView.setController(getPsCont());
                                psView.startGame();
                                this.setVisible(true);
                            }else{
                                System.out.println("Map Is Invalid");
                                JOptionPane.showMessageDialog(this,"Map is Invalid", null, WIDTH);
                            }  
                        }else{
                            this.dispose();
                            JOptionPane.showMessageDialog(this, "Invalid Map File", null, WIDTH);
                        }
    }

    /**
     * @return the psCont
     */
    public PlayScreen_Controller getPsCont() {
        return psCont;
    }

    @Override
    public void windowOpened(WindowEvent e) {
       // LogGenerator.addLog("Game Play Start");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //LogGenerator.addLog("Game Play Window Closed.");
       // LogGenerator.addLog("Game Closed");
        //LogGenerator.closeLog();
       // LogGenerator.towerLog();
        //this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
       // LogGenerator.addLog("Game Play Window Closed.");
      // LogGenerator.addLog("Game Closed");
       // LogGenerator.closeLog();
       // LogGenerator.towerLog();
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
