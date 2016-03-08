package TD.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import TD.controller.MapBox_Controller;

/**
 * This is GUI class of Map Box Module.
 * @author AlexChen
 */
public class MapBox_View extends JPanel {

    int xC=0;
    int yC=0;
    JButton[][] cellBtn;
    
    boolean entryPointFlag = false;
    boolean pathPointFlag = false;
    boolean exitPointFlag = false;
    
    MapBox_Controller mbCon;
    
    /**
     * This method will initialize Map Box Controller
     * @param mbCon the Map Box Controller
     */
    public MapBox_View(MapBox_Controller mbCon){
        this.mbCon = mbCon;
    }
    
    /**
     * This method will initialize GUI components for Map Box and Controller
     * @param mbCon the Map Box Controller
     * @param xC x coordinate
     * @param yC y coordinate
     */
    public MapBox_View(MapBox_Controller mbCon,int xC, int yC) {
        this.mbCon = mbCon;
        boolean FileLoadedFlag = mbCon.getFileFlag();
        int[][] temp_MapGridArray = new int[yC][xC];
        temp_MapGridArray = mbCon.getMapGirdArray();
        this.xC = xC;
        this.yC = yC;
        cellBtn = new JButton[yC][xC];
      GridBagLayout layout = new GridBagLayout();
      this.setLayout(layout);        
      GridBagConstraints gbc = new GridBagConstraints();
      
      for(int y=0;y<yC;y++){
            for(int x=0;x<xC;x++){
                cellBtn[y][x] = new JButton();
                cellBtn[y][x].setName(x+"_"+y);
                cellBtn[y][x].setBackground(Color.green);
          }
      }
        for(int y=0;y<yC;y++){
          gbc.fill = GridBagConstraints.HORIZONTAL;
            for(int x=0;x<xC;x++){
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.ipady = 20;
                this.add(cellBtn[y][x],gbc);
                if(FileLoadedFlag){
                    System.out.println("X:"+x+" y:"+y+" "+temp_MapGridArray[y][x]);
                    if(temp_MapGridArray[y][x] == 7)
                        setEntryPoint(y, x);
                    if(temp_MapGridArray[y][x] == 8)
                        setExitPoint(y, x);
                    if(temp_MapGridArray[y][x] == 1)
                        setPathPoint(y, x);
                }
          }
      }
    }
    
    /**
     * This method will add button action listener to all different buttons that used in view.
     * @param ListnerForButton the ActionListener
     */
    public void addButtonClickEventListner(ActionListener ListnerForButton){
        //x,y order doesn't matter becuase array already init
        for(int x=0;x<mbCon.getXBlockCount();x++){
          for(int y=0;y<mbCon.getYBlockCount();y++){
                cellBtn[y][x].addActionListener(ListnerForButton);
                cellBtn[y][x].setEnabled(false);
          }
      }
    }
    
    /**
     * This method will enable Entry Point Grid cells
     * @return flag
     */
    public boolean setEntryPointFlag(){
        for(int y=0;y<mbCon.getYBlockCount();y++){
            for(int x=0;x<mbCon.getXBlockCount();x++){
              if(x==0){
                  cellBtn[y][0].setBackground(Color.gray);
                  cellBtn[y][0].setEnabled(true);
              }
              else{
                  cellBtn[y][x].setEnabled(false);
                  cellBtn[y][x].setBackground(Color.white);
              }
            }
        }
        setSlectedCell();
        return true;
    }
    
    /**
     * This method will enable Path Point Grid cells
     * @return flag
     */
    public boolean setPathPointFlag(){
        for(int y=0;y<mbCon.getYBlockCount();y++){
            for(int x=0;x<mbCon.getXBlockCount();x++){
              if(x==0){
                  cellBtn[y][0].setBackground(Color.white);
                  cellBtn[y][0].setEnabled(false);
              } else if(x==mbCon.getXBlockCount()-1)
              {
                  cellBtn[y][mbCon.getXBlockCount()-1].setBackground(Color.white);
                  cellBtn[y][mbCon.getXBlockCount()-1].setEnabled(false);
              }
              else{
                  cellBtn[y][x].setEnabled(true);
                  cellBtn[y][x].setBackground(Color.green);
              }
            }
        }
        setSlectedCell();
        return true;
    }
    
    /**
     * This method will enable Exit Point Grid cells
     */
    public void setExitPointFlag(){
        for(int x=0;x<mbCon.getXBlockCount();x++){
          for(int y=0;y<mbCon.getYBlockCount();y++){
              if(x==mbCon.getXBlockCount()-1)
              {
                  cellBtn[y][mbCon.getXBlockCount()-1].setBackground(Color.gray);
                  cellBtn[y][mbCon.getXBlockCount()-1].setEnabled(true);
              }
              else{
                  cellBtn[y][x].setEnabled(false);
                  cellBtn[y][x].setBackground(Color.white);
              }
            }
        }
        setSlectedCell();
    }
    
    /**
     * This method will set color of all grid cells
     * @return flag
     */
    public boolean setSlectedCell(){
        if(mbCon.getEentryPointData() != 9)
            cellBtn[mbCon.getEentryPointData()][0].setBackground(new Color(165, 42, 42));
        if(mbCon.getExitPointData() != 9)
            cellBtn[mbCon.getExitPointData()][mbCon.getXBlockCount()-1].setBackground(new Color(165, 42, 42));
        int[][] temp = mbCon.getMapGirdArray();
        for(int x=0;x<mbCon.getXBlockCount();x++){
            for(int y=0;y<mbCon.getYBlockCount();y++){
                if(temp[y][x] == 1)
                    cellBtn[y][x].setBackground(Color.yellow);
            }
        }
        return true;
    }
    
    /**
     * This method will set Entry Point
     * @param yC y coordinate
     * @param xC x coordinate
     * @return flag
     */
    public boolean setEntryPoint(int yC, int xC){
        if(xC != 0) {
            return false;
        }
        for(int y=0;y<mbCon.getYBlockCount();y++){
            cellBtn[y][0].setBackground(Color.gray);
        }
        cellBtn[yC][xC].setBackground(new Color(165, 42, 42));
        return true;
    }
    
    /**
     * This method will set Path Point
     * @param yC y coordinate
     * @param xC x coordinate
     */
    public void setPathPoint(int yC, int xC){
        int[][] temp = mbCon.getMapGirdArray();
        for(int x=0;x<mbCon.getXBlockCount();x++){
            for(int y=0;y<mbCon.getYBlockCount();y++){
                if(temp[yC][xC] == 1)
                    cellBtn[yC][xC].setBackground(Color.yellow);
                else
                    cellBtn[yC][xC].setBackground(Color.green);
            }
        }
    }
    
    /**
     * This method will set Exit Point
     * @param yC y coordinate
     * @param xC x coordinate
     * @return flag
     */
    public boolean setExitPoint(int yC, int xC){
        if(xC != (this.xC-1) ) {
            return false;
    	}
        for(int y=0;y<mbCon.getYBlockCount();y++){
            cellBtn[y][mbCon.getXBlockCount()-1].setBackground(Color.gray);
        }
        cellBtn[yC][xC].setBackground(new Color(165, 42, 42));
        return true;
    }
    
    /**
     * This method create Message show dialog box.
     * @param str message string.
     */
    public void displayMessage(String str){
        JOptionPane.showMessageDialog(this, str);
    }
}
