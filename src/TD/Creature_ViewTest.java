package TD.testcase;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import TD.model.Creature_Model;
import TD.view.Creature_View;
import TD.view.PlayScreen_View;
import TowerDefenceGame.GamePlay;

public class Creature_ViewTest {
	
	GamePlay gptest = new GamePlay(new File("MapFilesTest/Creature_ViewTestMap.dat"), 8, 8);	
	PlayScreen_View psviewtest = new PlayScreen_View(gptest);
	Creature_View cView = new Creature_View();
	public Creature_Model Creatures = new Creature_Model(gptest.getPsCont().getCcModel(), gptest.getPsCont().getCcCont());	
	
	@Test
	public void testDraw_false() {
		boolean exp = false;
		boolean act = cView.draw(Creatures, 0, null);
		assertEquals(exp, act);
	}

}
