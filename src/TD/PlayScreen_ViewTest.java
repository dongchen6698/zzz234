package TD.testcase;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

import TD.config.ConfigModel;
import TD.view.PlayScreen_View;
import TowerDefenceGame.GamePlay;

public class PlayScreen_ViewTest {
	
	
	GamePlay gptest = new GamePlay(new File("MapFilesTest/maptest.dat"), 8, 8);
	
	PlayScreen_View psviewtest = new PlayScreen_View(gptest);
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void teststartGame(){
		boolean exp = true;
		boolean act = psviewtest.startGame();
		assertEquals(exp, act);	
	}
	
	@Test
	public void testMobSpawner() {
		boolean exp = true;
		boolean act = psviewtest.mobSpawner();
		assertEquals(exp, act);
	}
	
	@Test
	public void TestinitCreatures(){
		psviewtest.setController(null);
		boolean exp = false;
		boolean act = psviewtest.initCreatures();
		assertEquals(exp, act);
    }
	
	@Test
	public void TestinitCreatures_true(){
		psviewtest.setController(gptest.getPsCont());
		boolean exp = true;
		boolean act = psviewtest.initCreatures();
		assertEquals(exp, act);
    }
	
	@Test
    public void TesthasWon() {
		ConfigModel.killed = 5;
                ConfigModel.killsToWin = 5;
                ConfigModel.maxLevel = 1;
                ConfigModel.level = 2;
		boolean exp = true;
		boolean act = psviewtest.hasWon();
		assertEquals(exp, act);
    }
	
	@Test
    public void TesthasWon_false() {
		ConfigModel.killed = 0;
		boolean exp = false;
		boolean act = psviewtest.hasWon();
		assertEquals(exp, act);
    }
	
	@Test
    public void TestisgameOver() {
		ConfigModel.health = 0;
		boolean exp = true;
		boolean act = psviewtest.isGameOver();
		assertEquals(exp, act);
    }
	
	@Test
    public void TestisgameOver_false() {
		ConfigModel.health = 3;
		boolean exp = false;
		boolean act = psviewtest.isGameOver();
		assertEquals(exp, act);
    }
}
