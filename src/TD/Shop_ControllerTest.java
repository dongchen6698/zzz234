package TD.testcase;
import java.io.File;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TD.config.ConfigModel;
import TD.controller.Shop_Controller;
import TD.model.Shop_Model;
import TowerDefenceGame.GamePlay;

public class Shop_ControllerTest {

	public GamePlay gptest = new GamePlay(new File("MapFilesTest/maptest.dat"), 8, 8);
    public Shop_Controller sctest = gptest.getPsCont().getsCont();
    public Shop_Model sModel = gptest.getPsCont().getsModel();
 
    @Before
    public void setup(){
        	ConfigModel.money = 150;
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
            boolean act = sctest.placeTower(3, 7, 0);
            assertEquals(exp, act);
	}
	
	@Test
	public void testPlaceTower_path() {
            boolean exp = false;
            boolean act = sctest.placeTower(0, 1, 0);
            assertEquals(exp, act);
	}
        
    @Test
	public void testPlaceTower_true() {
            boolean exp = true;
            boolean act = sctest.placeTower(1, 1, 0);
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
            boolean act = sctest.removeTower(2, 2);
            assertEquals(exp, act);
	}
//        
//    @Test
//	public void testRemoveTower_true() {
//            boolean exp = true;
//            boolean act = sctest.removeTower(5, 5);
//            assertEquals(exp, act);
//	}
        
    @Test
	public void testIsTowerHere() {
            boolean exp = false;
            boolean act = sctest.isTowerHere(1, 1);
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
            int total_money = ConfigModel.money;
            assertEquals(exp,total_money);
	}
	
	@Test
	public void testTowerReturnCharges() {
			int exp = 140;
            boolean act = sctest.removeTower(1, 1);
            int total_money = ConfigModel.money;
            assertEquals(exp,total_money);
	}

}