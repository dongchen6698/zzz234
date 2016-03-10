

package TD.model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Scanner;
/**
 * This is model for Play Screen Module.
 * @author peilin
 */
public class PlayScreen_Model {
    
    private int xC;
    private int yC;
    
    private static int myWidth, myHeight;
    private static int money = 20, health = 50;
    private static int killed =0, killsToWin =0, Level =1, maxLevel =3;
    private static int winTime = 4000, winFrame =0;
    
    private static boolean isFirst = true;
    private static boolean isDebug = false;
    private static boolean isDead = false;
    private static boolean isWin = false;
    
    private static Image[] ground_level = new Image[100];
    private static Image[] air_level = new Image[100];
    private static Image[] tileset_res = new Image[100];
    private static Image[] tileset_mob = new Image[100];
    private static Image[] tileset_air = new Image[100];
    
    private static Point mse = new Point(0, 0);
    
    private static CellContainer_Model ccModel;
    
    private int[][] gridCellArray;
    
    /**
     * This is constructor method for Play Screen Model
     */
    public PlayScreen_Model(){
    }

    /**
     * This method load file, validate the map and trigger the view to draw map.
     * @param file map file path.
     * @return return true if map file is valid.
     */
    public boolean LoadMap(File file) {
    	System.out.println("load map");
        try{
            Scanner loadScanner = new Scanner(file);
            this.xC = loadScanner.nextInt();
            this.yC = loadScanner.nextInt();
            gridCellArray = new int[getyC()][getxC()];
             while(loadScanner.hasNext()){
                 Thread.sleep(100);
                for(int y=0;y<getyC();y++){
                    for(int x=0;x<getxC();x++){
                        int val = loadScanner.nextInt();
                        gridCellArray[y][x] = val;
                    }
                }
             }
            for(int y=0;y<getyC();y++){
                for(int x=0;x<getxC();x++){
                    System.out.print(getGridCellArray()[y][x]+" ");
                }
                System.out.println("\n");
            }
             loadScanner.close();
             return true;
         } catch(Exception e){
             System.out.println("Hey Buddy, Somtething is wrong in file.");
             return false;
         }
    }

    /**
     * this method will initialize Cell Container Model to crate map grid.
     */
    public void initCellContainerModel() {
        ccModel = new CellContainer_Model(getGridCellArray().length,getGridCellArray()[0].length);
    }
    
    /**
     * This method will set entryPoint, ExitPoint, PathPoint in map and draw Map.
     */
    public void setGridCellVal(){
        for(int y=0;y<getGridCellArray().length;y++){
            for(int x=0;x<getGridCellArray()[0].length;x++){
                if(getGridCellArray()[y][x] == 7 || getGridCellArray()[y][x] == 8){
                    System.out.println("ExitPoint");
                    ccModel.setGcModelObj(y, x, 1, getGridCellArray()[y][x]);
                }
                else
                    ccModel.setGcModelObj(y, x, getGridCellArray()[y][x],-1);
            }
            System.out.println("\n");
        }
    }
    
    /**
     * this method will return startX
     * @return the starting x point
     */
    public int getStartX(){
        return ((getGridCellArray()[0].length * 40)) + 100;
    }
    
    /**
     * this method will return startY
     * @return the starting y point
     */
    public int getStartY(){
        return 0;
    }
    
    /**
     * this method will return Cell Container Model
     * @return the Cell Container Model
     */
    public CellContainer_Model getCellContainer_Model(){
        return ccModel;
    }

    /**
     * this method will return xC
     * @return the xC
     */
    public int getxC() {
        return xC;
    }

    /**
     * this method will return yC
     * @return the yC
     */
    public int getyC() {
        return yC;
    }

    /**
     * this method will return Grid Cell Array
     * @return the gridCellArray
     */
    public int[][] getGridCellArray() {
        return gridCellArray;
    }
}
