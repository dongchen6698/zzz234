

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import tdgame.model.CreatureModel;
import tdgame.model.configModel;
import tdgame.view.CreatureView;
import tdgame.view.PlayScreenView;
import towerdefensegame.GamePlay;

public class CreatureViewTest {
	
	GamePlay gptest = new GamePlay(new File("MapFilesTest/Path4.team7"), 5, 5);
 	
	PlayScreenView psviewtest = new PlayScreenView(gptest);
	CreatureView cView = new CreatureView();
	public CreatureModel Creatures = new CreatureModel(gptest.getPsCont().getCcModel(), gptest.getPsCont().getCcCont());
	
	
	@Test
	public void testDraw_false() {
		boolean exp = false;
		boolean act = cView.draw(Creatures, 0, null);
		System.out.println("ABCD:"+psviewtest.getGraph());
		assertEquals(exp, act);
	}

}
