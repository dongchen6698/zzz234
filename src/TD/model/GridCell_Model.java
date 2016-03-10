package TD.model;

import java.awt.Rectangle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import TD.view.PlayScreen_View;
import TD.zz.config.ConfigModel;

/**
 * This is model for Grid Cells Module.
 * @author peilin
 */
public class GridCell_Model extends Rectangle{
    
    private Rectangle[] towerRange;
    public String[] towerLog;
    public int[] towerActiveTime;
    public int[] towerCKilled;
    
    private int towerRangeSize = 100;
    private int gID;
    private int airID;
    private int loseTime = 100, loseFrame = 0;
    
    private int shotMob = -1;
    private int[] MobList = new int[100];
    private boolean freeze = false;
    private boolean fire = false;
    private boolean firing = false;
    
    private int xC=0,yC=0;
    
    private String startTime;
    private boolean startFlag = false;
    private String endTime;

    /**
     * * This is constructor method for Grid Cell. It will set different properties for each grid cell.
     * @param x x point
     * @param y y point
     * @param width width of cell
     * @param height height of cell
     * @param gId ground id of cell
     * @param airId  air id of cell
     */
    GridCell_Model(int x, int y, int width, int height, int gId, int airId) {
        Arrays.fill(MobList, 0);
        setBounds(x, y, width, height);
        towerRange = new Rectangle[ConfigModel.airTowerLaser.length];
        towerLog = new String[ConfigModel.airTowerLaser.length];
        towerActiveTime = new int[ConfigModel.airTowerLaser.length];
        towerCKilled = new int[ConfigModel.airTowerLaser.length];
        for(int i=0;i<ConfigModel.airTowerLaser.length;i++){
            towerRange[i] = new Rectangle(x - ((ConfigModel.airTowerRanger[i])/2), y - ((ConfigModel.airTowerRanger[i])/2), width + ConfigModel.airTowerRanger[i], height + ConfigModel.airTowerRanger[i]);
            towerActiveTime[i] = 0;
            towerCKilled[i] = 0;
        }
        this.gID = gID;
        this.airID = airID;
       
    }
    
    public void physic(Creature_Model[] cModel) throws ParseException{
        
        for(int i=0;i<ConfigModel.airTowerLaser.length;i++){
                if(getShotMob() != -1 && getTowerRange()[gID].intersects(cModel[getShotMob()])){
                    setFiring(true);
                }
                else{
                    setFiring(false);
                }
        }
        for(int tid=0;tid<ConfigModel.airTowerLaser.length;tid++){
                if(airID == 5){
                    for(int i=0;i<cModel.length;i++){
                        if(cModel[i].isInGame()){
                            if(getTowerRange()[tid].contains(cModel[i])){
                                setFiring(false);
                            }
                        }
                    }
                }
            }
        if(!isFiring()){
            for(int tid=0;tid<ConfigModel.airTowerLaser.length;tid++){
                if(airID == ConfigModel.airTowerLaser[tid]){
                    for(int i=0;i<cModel.length;i++){
                        if(cModel[i].isInGame()){
                            if(getTowerRange()[tid].intersects(cModel[i])){
                                setFiring(true);
                                shotMob = i;
                                if(!startFlag){
                                    startTime = getCurrentTime();
                                    System.out.println("Start");
                                    startFlag = true;
                                } else
                                    endTime();
                            }
                        }
                    }
                }
            }
        }
        
        if(isFiring() && getAirID() != -1){
            if(loseFrame >= loseTime){
                if(getAirID() != 5){
                    //System.out.println("Air Id: "+getAirID()+" Rate:"+ConfigModel.TowerFiringRate[getAirID()-3]);
                    cModel[getShotMob()].loseHealth(ConfigModel.TowerFiringRate[getAirID()-3]);
                } else if(getAirID()==5) {
                    if(cModel[getShotMob()].walkSpeed < 20+ConfigModel.TowerFiringRate[getAirID()-3]){
                        cModel[getShotMob()].walkSpeed++;
                    }
                }
                loseFrame = 0;
            }else {
                loseFrame +=1;
            }
            if(cModel[getShotMob()].isDead()){
                towerCKilled[getAirID()-3]++;
                setFiring(false);
                shotMob = -1;
                PlayScreen_View.hasWon();
            }
        }
        
        if(!isFiring() && startFlag && getAirID() != -1){
                System.out.println("End");
                endTime();
            }
    }
    
    public void endTime() throws ParseException{
        endTime = getCurrentTime();
                System.out.println("sT: "+startTime);
                System.out.println("eT: "+endTime);
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date date1 = format.parse(startTime);
                    Date date2 = format.parse(endTime);
                    long difference = date2.getTime() - date1.getTime();
                    System.out.println("diff: "+(long)difference);
                    towerActiveTime[getAirID()-3] += difference;
                startFlag = false;
    }

    /**
     * @param gID the gID to set
     */
    public void setgID(int gID) {
        this.gID = gID;
    }

    /**
     * @param airID the airID to set
     */
    public void setAirID(int airID) {
        this.airID = airID;
    }

    /**
     * @return the gID
     */
    public int getgID() {
        return gID;
    }

    /**
     * @return the airID
     */
    public int getAirID() {
        return airID;
    }

    /**
     * @return the towerRange
     * @param x x index
     */
    public Rectangle getTowerRange(int x) {
        return getTowerRange()[x];
    }
    
    public void getMoney(int mobID){
        System.out.println("Money Is increased");
        ConfigModel.money += ConfigModel.deathReward[0];
    }

    /**
     * @return the shotMob
     */
    public int getShotMob() {
        return shotMob;
    }

    /**
     * @return the firing
     */
    public boolean isFiring() {
        return firing;
    }

    /**
     * @param firing the firing to set
     */
    public void setFiring(boolean firing) {
        this.firing = firing;
    }

    /**
     * @return the towerRange
     */
    public Rectangle[] getTowerRange() {
        return towerRange;
    }

    /**
     * @param towerRange the towerRange to set
     * @param i the towerRange ID
     */
    public void setTowerRange(int i,Rectangle towerRange) {
        this.towerRange[i] = towerRange;
    }
    
    /**
     * this method is get current time
     * @return string
     */
    public String getCurrentTime(){
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	return sdf.format(cal.getTime());
    }
}
