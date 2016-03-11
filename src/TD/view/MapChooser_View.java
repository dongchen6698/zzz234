package TD.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import TD.view.MainScreen_View;


/**
 * This is GUI class of Map Chooser Module.
 * @author peilin
 *
 */
public class MapChooser_View extends JFrame {
    
    private JButton showButton;
    private JList fruitList;
    MainScreen_View msView;
    
    /**
     * This method is constructor.
     */
    public MapChooser_View(){
    }
    
    /**
     * This method will initialize GUI components for Map Chooser.
     * @param msView the view object Main Screen
     * @param fileList array of map files
     */
    public MapChooser_View(MainScreen_View msView, String[] fileList){
        this.setTitle("Select Your Map");
        this.setSize(300,400);
        this.msView = msView;
        listMapFiles(fileList);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    
    /**
     * this method will set top properties of JFrame.
     * @param f the boolean value
     */
    public void setMSTOp(boolean f){
        msView.setAlwaysOnTop(f);
    }
    
    /**
     * this method will read all files from MapFiles folder and list in JList Box.
     * @param fileList the array of map files
     */
    public void listMapFiles(String[] fileList){
        
        this.setLayout(new BorderLayout(5, 5));
        final DefaultListModel fruitsName = new DefaultListModel();

        for(int i=0;i<fileList.length;i++){
            fruitsName.addElement(fileList[i]);
        }

        fruitList = new JList(fruitsName);
        fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fruitList.setSelectedIndex(0);
        fruitList.setVisibleRowCount(3);        

        JScrollPane fruitListScrollPane = new JScrollPane(fruitList);    

        showButton = new JButton("Start game");
        this.add(fruitListScrollPane,BorderLayout.CENTER);  
        this.add(showButton,BorderLayout.SOUTH);
    }
    
    /**
     * this method will add button action listener to button.
     * @param ListnerForButton the ActionListener
     */
    public void addButtonClickEventListner(ActionListener ListnerForButton){
        showButton.addActionListener(ListnerForButton);
    }
    
    /**
     * This method will return the name of file that selected by user.
     * @return the file name
     */
    public String getSelectedFile(){
        if (fruitList.getSelectedIndex() != -1) {                     
                 return fruitList.getSelectedValue().toString();
        }
        else
            return "NONE";
    }
    
    /**
     * This method create Message show dialog box.
     * @param str message string.
     */
    public void displayMessage(String str){
        JOptionPane.showMessageDialog(this, str);
    }
}

