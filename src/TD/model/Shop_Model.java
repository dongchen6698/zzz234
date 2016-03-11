package TD.model;

import java.awt.Rectangle;

import TD.config.ConfigModel;

/**
 * This is model for Shop(Tower) Module. Tower properties, user health, money.
 * @author peilin
 */
public class Shop_Model {

    /**
     * @return the buttonSize
     */
    public static int getButtonSize() {
        return buttonSize;
    }
    
    private int health = 5;
    private int money = 150;
    
    private int startX = 0;
    private int startY = 0;
    
    public static int shopWidth = 4;
    private static int buttonSize = 52;
    public static int cellSpace = 3;
    public static int iconSize = 20;
    public static int icon_space = 30;
    public static int itemIn = 4;
    private static int heldID = -1;
    private static int realID = -1;
    public static int[] buttonID = {ConfigModel.airTowerLaser[0], ConfigModel.airTowerLaser[1], ConfigModel.airTowerLaser[2], ConfigModel.airTowerLaser[3]};
    private static int[] buttonPrice = {10, 20, 30, 40};
    
    public Rectangle[] button  = new Rectangle[shopWidth];
    public Rectangle btn_health;
    public Rectangle btn_coins;
    
    public Rectangle towerUpgrade;
    
    private boolean holdsItem = false;
    
    private int towerID = 0;
    private boolean towerInfo = false;
    
    /**
     * This is constructor method for shop. set x,y coordinate to set position of tower shop and tower detail.
     * @param startX x coordinate
     * @param startY y coordinate
     */
    public Shop_Model(int startX, int startY){
        this.startX = startX;
        this.startY = startY;
        //System.out.println("shop model "+startX+" and "+startY);
        define();
    }
    
    /**
     * this method initialize basic parameter for tower shop.
     */
    public void define(){
        for(int i=0;i<button.length;i++){
            button[i] = new Rectangle( startX +(i * (cellSpace+getButtonSize())), startY+getButtonSize()+cellSpace, getButtonSize(), getButtonSize());
        }
        towerUpgrade = new Rectangle(startX - 5, 240, 226, 20);
        btn_health = new Rectangle(startX, 14, iconSize, iconSize);
        btn_coins = new Rectangle(startX + button[0].y + 60, 14, iconSize, iconSize);
    }
    
    /**
     * this method will return no of towers in shop.
     * @return no of towers
     */
    public int getbuttonLength(){
        return button.length;
    }
    /**
     * this method will send id of tower.
     * @param x id of tower.
     * @return tower id
     */
    public int getButtonId(int x){
        return buttonID[x];
    }
    /**
     * this method will return tower properties.
     * @param x tower id.
     * @return tower properties
     */
    public Rectangle getButtonObj(int x){
        return button[x];
    }

    /**
     * this method will return value of hoodItem flag.
     * @return the holdsItem
     */
    public boolean isHoldsItem() {
        return holdsItem;
    }

    /**
     * this method will set value to hoodItem flag.
     * @param holdsItem the holdsItem to set
     */
    public void setHoldsItem(boolean holdsItem) {
        this.holdsItem = holdsItem;
    }
    
    /**
     * this method will return value of HoldID.
     * @return the heldID
     */
    public int getHeldID() {
        return heldID;
    }

    /**
     * this method will set value of HoldID.
     * @param aHeldID the heldID to set
     */
    public void setHeldID(int aHeldID) {
        heldID = aHeldID;
    }

    /**
     * this method will return value of realID.
     * @return the realID
     */
    public int getRealID() {
        return realID;
    }

    /**
     * this method will set value of realID.
     * @param aRealID the realID to set
     */
    public void setRealID(int aRealID) {
        realID = aRealID;
    }

    /**
     * this method will set value of health.
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * this method will return value of health.
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * this method will return value of money.
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**\
     * this method will set value of money.
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }
    
    /**
     * this method will return value of tower price.
     * @return the buttonPrice
     * @param i TowerID 
     */
    public int getButtonPrice(int i) {
        return buttonPrice[i];
    }

    /**
     * this method will set value of tower price.
     * @param aButtonPrice the buttonPrice to set
     * @param i Tower id
     */
    public void setButtonPrice(int i, int aButtonPrice) {
        buttonPrice[i] = aButtonPrice;
    }

    /**
     * this method will check towerInfo flag.
     * @return the towerInfo
     */
    public boolean isTowerInfo() {
        return towerInfo;
    }

    /**
     * this method will set value of tower price.
     * @param towerInfo the towerInfo to set
     */
    public void setTowerInfo(boolean towerInfo) {
        this.towerInfo = towerInfo;
    }

    /**
     * this method will return tower id.
     * @return the towerID
     */
    public int getTowerID() {
        return towerID;
    }

    /**
     * this method will set tower id.
     * @param towerID the towerID to set
     */
    public void setTowerID(int towerID) {
        this.towerID = towerID;
    }

    /**
     * this method will set startX.
     * @param startX the startX to set
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * this method will set startY.
     * @param startY the startY to set
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }
}
