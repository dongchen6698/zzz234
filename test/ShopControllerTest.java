import java.io.File;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tdgame.controller.ShopController;
import tdgame.model.ShopModel;
import tdgame.model.configModel;
import towerdefensegame.GamePlay;

public class ShopControllerTest {
	
	public GamePlay gptest = new GamePlay(new File("MapFiles/20 15.team7"), 5, 5);
        public ShopController sctest = gptest.getPsCont().getsCont();
        public ShopModel sModel = gptest.getPsCont().getsModel();
        
        
        
        @Before
        public void setup(){
            //gptest = new GamePlay(new File("MapFiles/20 15.team7"), 5, 5);
            //sctest = gptest.getPsCont().getsCont();
        	configModel.money = 150;
            sModel.setHeldID(3);
            sctest.placeTower(5, 5, 0);
        }

	@Test
	public void testPlaceTower_entry() {
            boolean exp = false;
            boolean act = sctest.placeTower(0, 0, 0);
            assertEquals(exp, act);
	}
	
	@Test
	public void testPlaceTower_exit() {
            boolean exp = false;
            boolean act = sctest.placeTower(0, 15, 0);
            assertEquals(exp, act);
	}
	
	@Test
	public void testPlaceTower_path() {
            boolean exp = false;
            boolean act = sctest.placeTower(0, 7, 0);
            assertEquals(exp, act);
	}
        
        @Test
	public void testPlaceTower_true() {
            boolean exp = true;
            boolean act = sctest.placeTower(2, 4, 0);
            assertEquals(exp, act);
	}
        
        @Test
	public void testPlaceTower_replaceTower() {
            boolean exp = false;
            boolean act = sctest.placeTower(5, 5, 0);
            assertEquals(exp, act);
	}

	@Test
	public void testRemoveTower() {
            boolean exp = false;
            boolean act = sctest.removeTower(0, 0);
            assertEquals(exp, act);
	}
        
        @Test
	public void testRemoveTower_true() {
            boolean exp = true;
            boolean act = sctest.removeTower(5, 5);
            assertEquals(exp, act);
	}
        
        @Test
	public void testIsTowerHere() {
            boolean exp = false;
            boolean act = sctest.isTowerHere(0, 0);
            assertEquals(exp, act);
	}

	@Test
	public void testIsTowerHere_true() {
            boolean exp = true;
            boolean act = sctest.isTowerHere(5, 5);
            assertEquals(exp, act);
	}
	
	@Test
	public void testTowerCharges() {
			int exp = 140;
            boolean act = sctest.placeTower(5, 5, 0);
            int total_money = configModel.money;
            assertEquals(exp,total_money);
	}
	
	@Test
	public void testTowerReturnCharges() {
			int exp = 148;
            boolean act = sctest.removeTower(5, 5);
            int total_money = configModel.money;
            assertEquals(exp,total_money);
	}

}