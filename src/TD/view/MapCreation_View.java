package TD.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TD.controller.MapBox_Controller;

public class MapCreation_View extends JFrame implements WindowListener{
	JLabel row,col;
	JComboBox rowInfo,colInfo;
	JButton setMapBTN;
	JButton saveMapBTN,loadMapBTN,backBTN;
	JButton EntryBTN,PathBTN,ExitBTN;
	JPanel map_object_panel;
    JPanel map_grid_panel;
    MapBox_Controller mbCont;
    
	
	/**
     * This method is initialize GUI components for Map Creation Screen.
     */
    public MapCreation_View(){
        this.setTitle("Creat Map Window");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout(5, 5));
        
        map_object_panel = new JPanel();
        map_grid_panel = new JPanel();
        
        
        row = new JLabel("The number of Row : ");
        col = new JLabel("The number of Col : ");
        
        String[] rowdata = {"7","8","9","10","11","12","13","14","15"};
        String[] coldata = {"7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        rowInfo = new JComboBox(rowdata);
        colInfo = new JComboBox(coldata);
        
        setMapBTN = new JButton("Set Grid");
        EntryBTN = new JButton("Entry Point");
        PathBTN = new JButton("Draw Path");
        ExitBTN = new JButton("Exit Point");
        saveMapBTN = new JButton("Save Map");
        loadMapBTN = new JButton("Load Map");
        backBTN = new JButton("Exit");
        
        EntryBTN.setEnabled(false);
        PathBTN.setEnabled(false);
        ExitBTN.setEnabled(false);
        saveMapBTN.setEnabled(false);
        
        map_grid_panel.setBackground(Color.DARK_GRAY);
        map_object_panel.setLayout(new GridLayout(0,4,5,5));
        map_object_panel.setBackground(Color.GRAY);
        
        map_object_panel.add(row);
        map_object_panel.add(rowInfo);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(EntryBTN);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(loadMapBTN);
        
        map_object_panel.add(col);
        map_object_panel.add(colInfo);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(PathBTN);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(saveMapBTN);
        
        map_object_panel.add(new JLabel(""));
        map_object_panel.add(setMapBTN);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(ExitBTN);
        //map_object_panel.add(new JLabel(""));
        map_object_panel.add(backBTN);
        
        this.add(map_object_panel,BorderLayout.SOUTH);
        this.add(map_grid_panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    /**
     * This method will return value of row.
     * 
     */
    public int getRowInput(){
        if(rowInfo.getSelectedItem().equals("")){
            return 0;
        }
        else{
            int temp = 0;
            try{
                temp  = Integer.parseInt((String) rowInfo.getSelectedItem());
            } catch(Exception e){
                System.out.println("Inter exception");
                temp = 0;
            }
            return temp;
        }
    }
    
    /**
     * This method will return value of col.
     * 
     */
    public int getColInput(){
        if(colInfo.getSelectedItem().equals("")){
            return 0;
        }
        else{
            int temp = 0;
            try{
                temp  = Integer.parseInt((String) colInfo.getSelectedItem());
            } catch(Exception e){
                System.out.println("Inter exception");
                temp = 0;
            }
            return temp;
        }
    }
    
    /**
     * This method will add gridMap in Map Creation Screen.
     * @param  mbCont the controller object of map box controller.
     * @return flag
     */
    public boolean addGridMap(MapBox_Controller mbCont){
        this.mbCont = mbCont;
        MapBox_View x = this.mbCont.getView();
        map_grid_panel.add(x);
        this.mbCont.setBtnGridClickListner();
        map_grid_panel.validate();
        return true;
    }
    
    /**
     * This method will add button listener.
     * @param ListnerForButton the ActionListener
     */
    public void addButtonClickEventListner(ActionListener ListnerForButton){
        setMapBTN.addActionListener(ListnerForButton);
        EntryBTN.addActionListener(ListnerForButton);
        PathBTN.addActionListener(ListnerForButton);
        ExitBTN.addActionListener(ListnerForButton);
        loadMapBTN.addActionListener(ListnerForButton);
        saveMapBTN.addActionListener(ListnerForButton);
        backBTN.addActionListener(ListnerForButton);
    }
    
    /**
     * This method is being used to modify button properties.
     */
    public void disableSubmitButton(){
        setMapBTN.setEnabled(false);
        rowInfo.setEnabled(false);
        colInfo.setEnabled(false);
        EntryBTN.setEnabled(true);
        PathBTN.setEnabled(true);
        ExitBTN.setEnabled(true);
        saveMapBTN.setEnabled(true);
    }
    
    /**
     * this method will disable load map button
     */
    public void disableLoadButton(){
        loadMapBTN.setEnabled(false);
    }
    
    /**
     * This method create Message show dialog box.
     * @param str message string.
     */
    public void displayMessage(String str){
        JOptionPane.showMessageDialog(this, str);
    }
    
    /**
     * this method will disable load map button
     */
    public void setdisabledloadMapBTN(){
       loadMapBTN.setEnabled(false);
    }
    
    /**
     * this method will disable setMapBTN
     */
    public void setdisabledsetMapBTN(){
       setMapBTN.setEnabled(false);
    }
    
    /**
     * this method will take file name input
     * @return name of file
     */
    public String getFileName(){
        return JOptionPane.showInputDialog(this, "Enter File Name");
    }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
