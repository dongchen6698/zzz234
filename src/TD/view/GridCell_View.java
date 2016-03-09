package TD.view;

import java.awt.Color;
import java.awt.Graphics;

import TD.config.ConfigModel;
import TD.model.GridCell_Model;


/**
 * This is GUI class of Grid Cell Module.
 * 
 */
public class GridCell_View {
    
    /**
     * This is constructor.
     */
    public GridCell_View(){
        
    }
    
    /**
     * This method will draw GUI Components.
     * @param g the Graphics
     * @param gcModel the model object
     */
    public void draw(GridCell_Model gcModel,Graphics g){
            g.drawImage(ConfigModel.ground_level[gcModel.getgID()], gcModel.x, gcModel.y, gcModel.width, gcModel.height, null);
        
        if(gcModel.getAirID() != ConfigModel.airAir && (gcModel.getAirID() ==8)){
           g.drawImage(ConfigModel.air_level[0], gcModel.x, gcModel.y, gcModel.width, gcModel.height, null);
       }
        
        if(gcModel.getAirID() != ConfigModel.airAir && (gcModel.getAirID() == 7)){
           g.drawImage(ConfigModel.air_level[1], gcModel.x, gcModel.y, gcModel.width, gcModel.height, null);
       }
        
        if(gcModel.getAirID() != ConfigModel.airAir){
           g.drawImage(ConfigModel.air_level[gcModel.getAirID()], gcModel.x, gcModel.y, gcModel.width, gcModel.height, null);
       }
    }
    
    /**
     * This method will draw GUI Components.
     * @param g the Graphics
     * @param gcModel the model object
     */
    public void fireRangeOutline(GridCell_Model gcModel,Graphics g){
        if(true){
            for(int i=0;i<ConfigModel.airTowerLaser.length;i++){
                if(gcModel.getAirID() == ConfigModel.airTowerLaser[i]){
                    g.setColor(Color.gray);
                    g.drawRect(gcModel.getTowerRange(i).x, gcModel.getTowerRange(i).y, gcModel.getTowerRange(i).width, gcModel.getTowerRange(i).height);
                }
            }
            g.setColor(Color.white);
        }
        if(gcModel != null && gcModel.isFiring() && gcModel.getAirID() != -1){
            if(gcModel.getAirID() == 4){
                    g.drawImage(ConfigModel.fire[0], PlayScreen_View.Creatures[gcModel.getShotMob()].x, PlayScreen_View.Creatures[gcModel.getShotMob()].y, gcModel.width, gcModel.height, null);
            } else if(gcModel.getAirID() == 5){
            } else {
                g.drawImage(ConfigModel.star[0], PlayScreen_View.Creatures[gcModel.getShotMob()].x, PlayScreen_View.Creatures[gcModel.getShotMob()].y, gcModel.width, gcModel.height, null);
            }
            
            if(gcModel.getAirID() == 4){
                g.setColor(Color.yellow);
            } else if(gcModel.getAirID() == 5){
                g.setColor(Color.blue);
            } else if(gcModel.getAirID() == 6){
                g.setColor(Color.red);
            } else {
                g.setColor(Color.green);
            }
               
               g.drawLine(gcModel.x + (gcModel.width/2)+1, gcModel.y + (gcModel.height/2)+1, PlayScreen_View.Creatures[gcModel.getShotMob()].x + (PlayScreen_View.Creatures[gcModel.getShotMob()].width/2) + 1, PlayScreen_View.Creatures[gcModel.getShotMob()].y + (PlayScreen_View.Creatures[gcModel.getShotMob()].height/2) + 1);
               g.drawLine(gcModel.x + (gcModel.width/2), gcModel.y + (gcModel.height/2), PlayScreen_View.Creatures[gcModel.getShotMob()].x + (PlayScreen_View.Creatures[gcModel.getShotMob()].width/2), PlayScreen_View.Creatures[gcModel.getShotMob()].y + (PlayScreen_View.Creatures[gcModel.getShotMob()].height/2));
        }
    }
}
