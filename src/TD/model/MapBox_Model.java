package TD.model;
/**
 * This is model for Map Box Module.
 * @author peilin
 */
public class MapBox_Model {
    
    private int xBlockCount;
    private int yBlockCount;
    private static int[][] mapGirdArray;
    
    private boolean fileFlag = false;
    /**
     * This is constructor method for Map Box Model.
     */
    public MapBox_Model(){
    	
    }
    
    /**
     * this method will return xBlockCount
     * @return the xBlockCount
     */
    public int getXBlockCount(){
        return xBlockCount;
    }
    
    /**
     * this method will return yBlockCount
     * @return the yBlockCount
     */
    public int getYBlockCount(){
        return yBlockCount;
    }
    
    /**
     * This method will set value to xBlockCount
     * @param x the xBlockCount
     */
    public void setXBlockCount(int x){
        xBlockCount = x;
    }
    
    /**
     * This method will set value to yBlockCount
     * @param y the yBlockCount
     */
    public void setYBlockCount(int y){
        yBlockCount = y;
    }
    
    /**
     * This method will set value to Grid Cell with respect to x,y index.
     * @param y y index
     * @param x x index
     * @param val value of cell
     */
    public void setmapGirdArrayElement(int y, int x, int val){
        if(val == 7){
            for(int yt=0;yt<yBlockCount;yt++){
                mapGirdArray[yt][0] = 0;
            }
        }else if(val == 8){
            for(int yt=0;yt<yBlockCount;yt++){
                mapGirdArray[yt][xBlockCount-1] = 0;
            }
        } 
        if(mapGirdArray[y][x] == 1)
            mapGirdArray[y][x] = 0;
        else
            mapGirdArray[y][x] = val;
    }
    
    /**
     * This method will set value to Grid Cell with respect to x,y index.
     * @param y y index
     * @param x x index
     * @param val value of cell
     */
    public void setmapGirdArrayElementF(int y, int x, int val){
        if(x == 0){
            for(int yt=0;yt<yBlockCount;yt++){
                if(mapGirdArray[yt][0] != 7)
                    mapGirdArray[yt][0] = 0;
            }
            if(val == 7)
                mapGirdArray[y][x] = val;
        }else if(x == xBlockCount-1){
            for(int yt=0;yt<yBlockCount;yt++){
                if(mapGirdArray[yt][xBlockCount-1] != 8)
                    mapGirdArray[yt][xBlockCount-1] = 0;
            }
            if(val == 8)
                mapGirdArray[y][x] = val;
        }
        else{
            mapGirdArray[y][x] = val;
        }
    }
    
    /**
     * this method will return mapGirdArray[y][x]
     * @return the mapGirdArray[y][x]
     * @param x x index
     * @param y y index
     */
    public int getmapGirdArrayElement(int y, int x){
        return mapGirdArray[y][x];
    }
    
    /**
     * this method will return entryPoint y index
     * @return the entryPoint y index
     */
    public int getEntryPointData(){
        for(int y=0;y<yBlockCount;y++){
            if(mapGirdArray[y][0] == 7)
                return y;
        }
        return 9;
    }
    
    /**
     * this method will return exitPoint y index
     * @return the exitPoint y index
     */
    public int getExitPointData(){
        for(int y=0;y<yBlockCount;y++){
            if(mapGirdArray[y][xBlockCount-1] == 8)
                return y;
        }
        return 9;
    }
    
    /**
     * this method will return Grid Map Array
     * @return the Grid Map Array
     */
    public int[][] getMapGirdArray(){
        return mapGirdArray;
    }
    
    /**
     * This method will set Grid Array and 0 to all grid cells
     */
    public void setGridArray(){
        mapGirdArray = new int[yBlockCount][xBlockCount];
        for(int x=0;x<xBlockCount;x++){
          for(int y=0;y<yBlockCount;y++){
                mapGirdArray[y][x] = 0;
          }
      }
    }
    
    /**
     * this method will return fileFlag
     * @return the fileFlag
     */
    public boolean getFileFlag(){
        return fileFlag;
    }
    
    /**
     * This method will set FileFlag
     * @param b the file flag
     */
    public void setFileFlag(boolean b){
        fileFlag = b;
    }
}
