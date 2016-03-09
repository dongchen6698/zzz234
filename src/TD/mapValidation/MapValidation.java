package TD.mapValidation;

import TD.config.ConfigModel;

/**
 * This controller will used to validation of Map.
 * @author AlexChen
 */
public class MapValidation {
    static int enX = 0;
    static int enY = 0;
    static int exX = 0;
    static int exY = 0;
    static int width = 5;
    static int height = 17;
    static int lastCheckX =0;
    static int lastCheckY =0;

    /**
     * @return the final_array
     */
    public int[][] getFinal_array() {
        return final_array;
    }
    String flag = "f";
    public static int[][] GridArray;
    public static int[][] GridArray_temp;
    private static int[][] final_array;
    public String[] stcn = new String[5000];
    boolean validFlag = false;
    public static int ekInt = 0;
    public static int ekInt2 = 0;
    
    /**
     * This method is constructor for Map Validation.
     * @param GridA the grid map array
     */
    public MapValidation(int[][] GridA){
        stcn[0] = "s";
        stcn[1] = "s";
        stcn[2] = "s";
        stcn[3] = "s";
        ekInt = 3;
        width = GridA.length;
        height = GridA[0].length;
        GridArray = new int[width][height];
        final_array = new int[width][height];
        final_array = GridA;
        ConfigModel.gridX = height;
        ConfigModel.gridY = width;
        System.out.println("gridX"+ConfigModel.gridX);
        System.out.println("gridY"+ConfigModel.gridY);
        for(int y=0;y < width; y++){
                    for(int x=0;x < height; x++){
                        GridArray[y][x] = GridA[y][x];
                        //final_array[y][x] = GridA[y][x];
                    }
                }
        
        GridArray_temp = new int[width][height];
        
        for(int y=0;y < width; y++){
            if(GridArray[y][0]==7){
                enX = y; //enX = 0
                enY = 0;
            }
            if(GridArray[y][height-1]==8){
                exX = y; //enX = 0
                exY = width-1;
            }
        }
        start();
    }
    
    /**
     * This method will return pathValidFlag
     * @return the validFlag
     */
    public boolean isValid(){
        return validFlag;
    }
    
    /**
     * This method will set validFalg
     * @param f the validFalg
     */
    public void setValid(boolean f){
        validFlag = f;
    }
    
    /**
     * This method will start map validation.
     */
    public void start(){
            if(!flag.equals("e")){
                lastCheckX = enX;
                lastCheckY = enY;
                flag = "a";
                for(int y=0;y < width; y++){
                    for(int x=0;x < height; x++){
                        GridArray_temp[y][x] = 0;
                    }
                }
                if(checkRight() == 0){
                    System.out.println("Path Not Found.");
                    setValid(false);
                } else{
                    right();
                }
            }
    }
    
    /**
     * This method will moved pointer to right.
     */
    public void right(){
        if(!flag.equals("l") && !flag.equals("e" ) && !flag.equals("f")){
                flag = "r";
                if(checkRight() == 1){
                    right();
                }else if(checkRight() == 8){
                    
                    setArray();
                    
                    System.out.println("Path Found.");
                    flag = "e";
                    setValid(true);
                }else if(checkUp() == 1){
                    up();
                }else if(checkDown() == 1){
                    down();
                }else{
                    GridArray[lastCheckX][lastCheckY] = -2;
                    start();
                }
            }
    }
    
    /**
     * This method will moved pointer to left.
     */
    public void left(){
        if(!flag.equals("r") && !flag.equals("e") && !flag.equals("f")){
                flag = "l";
                if(checkUp() == 1){
                    up();
                }else if(checkDown() == 1){
                    down();
                }else if(checkLeft() == 1){
                    left();
                }else{
                    GridArray[lastCheckX][lastCheckY] = -2;
                    start();
                }
            }
    }
    
    /**
     * This method will moved pointer to up.
     */
    public void up(){
        System.out.println(""+flag.equals("d"));
        if(!flag.equals("d") && !flag.equals("e" ) && !flag.equals("f")){
                flag = "u";
                if(checkUp() == 1){
                    up();
                }else if(checkRight() == 1){
                    right();
                }else if(checkRight()==8){
                    setArray();
                System.out.println("Path Found.");
                    flag = "e";
                    setValid(true);
                }else if(checkLeft() == 1){
                    left();
                }else{
                    GridArray[lastCheckX][lastCheckY] = -2;
                    start();
                }
            }
    }
    
    /**
     * This method will moved pointer to down.
     */
    public void down(){
        if(!flag.equals("u") && !flag.equals("e" ) && !flag.equals("f")){
                flag = "d";
                if(checkDown() == 1){
                    down();
                }else if(checkRight()==1){
                    right();
                }else if(checkRight() == 8){
                    setArray();
                    System.out.println("Path Found.");
                    flag = "e";
                    setValid(true);
                }else if(checkLeft() == 1){
                    left();
                }
                else{
                    GridArray[lastCheckX][lastCheckY] = -2;
                    start();
                }
            }
    }
    /**
     * This method will check ending point on right direction
     * @return the value of cell
     */
    public int checkRight(){
        if(lastCheckY+1 < height){
            if(GridArray_temp[lastCheckX][lastCheckY+1] != 3){
                ekInt2 = ekInt -1;
                if(GridArray[lastCheckX][lastCheckY+1] == 1 && !stcn[ekInt2].equals("l")){
                    ekInt++;
                    stcn[ekInt] = "r";
                    lastCheckY++;
                    GridArray_temp[lastCheckX][lastCheckY] = 3;
                    return 1;
                }else if(GridArray[lastCheckX][lastCheckY+1]==8){
                    return 8;
                }else{
                    return 0;
                }
            }
            else
                return 0;
        }
        else
            return 0;
    }
    /**
     * This method will check ending point on left direction
     * @return the value of cell
     */
    public int checkLeft(){
        if(lastCheckY-1 > 0){
            if(GridArray_temp[lastCheckX][lastCheckY-1] != 3){
                ekInt2 = ekInt - 1;
                if(GridArray[lastCheckX][lastCheckY-1] == 1 && !stcn[ekInt2].equals("r")){
                    ekInt++;
                    stcn[ekInt] = "l";
                    lastCheckY--;
                    GridArray_temp[lastCheckX][lastCheckY] = 3;
                    return 1;
                }else{
                    return 0;
                }
            }
            else
                return 0;
        }
        else
            return 0;
    }
    /**
     * This method will check ending point on up direction
     * @return the value of cell
     */
    public int checkUp(){
        if(lastCheckX-1 >= 0){
            if(GridArray_temp[lastCheckX-1][lastCheckY] != 3){
                ekInt2 = ekInt - 1;
                if(GridArray[lastCheckX-1][lastCheckY] == 1 && !stcn[ekInt2].equals("d")){
                    ekInt++;
                    stcn[ekInt] = "u";
                    lastCheckX--;
                    GridArray_temp[lastCheckX][lastCheckY] = 3;
                    return 1;
                }else{
                    return 0;
                }
            }
            else
                return 0;
        }
        else
            return 0;
    }
    /**
     * This method will check ending point on down direction
     * @return the value of cell
     */
    public int checkDown(){
        if(lastCheckX+1 < width){
            if(GridArray_temp[lastCheckX+1][lastCheckY] != 3){
                ekInt2 = ekInt -1;
                if(GridArray[lastCheckX+1][lastCheckY] == 1 && !stcn[ekInt2].equals("u")){
                    ekInt++;
                    stcn[ekInt] = "d";
                    lastCheckX++;
                    GridArray_temp[lastCheckX][lastCheckY] = 3;
                    return 1;
                }else{
                    return 0;
                }
            }
            else
                return 0;
        }
        else
            return 0;
    }
    
    /**
     * It will set final array with one path.
     */
    public void setArray(){
        for(int y = 0;y < width; y++){
                    for(int x=0;x < height; x++){
                        System.out.print("  "+GridArray_temp[y][x]);
                    }
                    System.out.println("");
                }
        for(int y=0;y < width ; y++){
                        for(int x=0;x < height; x++){
                            if(getFinal_array()[y][x] == 1){
                                final_array[y][x] = 0;
                            }
                            
                            if(GridArray_temp[y][x] == 3){
                                GridArray_temp[y][x] = 1;
                                final_array[y][x] = 1;
                            }
                        }
                    }
    }
}
