

import static org.junit.Assert.*;

import org.junit.Test;

import tdgame.controller.CellContainerController;
import tdgame.model.CellContainerModel;
import tdgame.model.CreatureModel;
import tdgame.view.CellContainerView;

public class CreatureModelTest {
	
	
	CellContainerModel ccmtest = new CellContainerModel(10, 10);
	CellContainerModel ccmtest2 = new CellContainerModel(10, 10);
	CellContainerView ccvtest = new CellContainerView();
	CellContainerController ccctest = new CellContainerController(ccvtest, ccmtest);
	
	CreatureModel cmtest = new CreatureModel(ccmtest, ccctest);

	@Test
	public void testSpawnCreature() {
		boolean exp = true;
		boolean act = cmtest.spawnCreature(-1);
		assertEquals(exp, act);
	}
	
	@Test
	public void testDeleteCreature() {
		boolean exp = true;
		boolean act = cmtest.deleteCreature();
		assertEquals(exp, act);
	}

	
	@Test
	public void testLoosHealth() {
		boolean exp = true;
		boolean act = cmtest.loosHealth();
		assertEquals(exp, act);
	}

	@Test
	public void testLoseHealth() {
		boolean exp = true;
		boolean act = cmtest.loseHealth(5);
		assertEquals(exp, act);
	}

	@Test
	public void testCheckDeath() {
		boolean exp = true;
		boolean act = cmtest.checkDeath();
		assertEquals(exp, act);
	}

	@Test
	public void testIsDead() {
		boolean exp = true;
		boolean act = cmtest.isDead();
		assertEquals(exp, act);
	}

	
}
