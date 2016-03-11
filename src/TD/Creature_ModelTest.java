package TD.testcase;

import static org.junit.Assert.*;
import org.junit.Test;

import TD.controller.CellContainer_Controller;
import TD.model.CellContainer_Model;
import TD.model.Creature_Model;
import TD.view.CellContainer_View;


public class Creature_ModelTest {
	
	CellContainer_Model ccmtest = new CellContainer_Model(10, 10);
	CellContainer_Model ccmtest2 = new CellContainer_Model(10, 10);
	CellContainer_View ccvtest = new CellContainer_View();
	CellContainer_Controller ccctest = new CellContainer_Controller(ccvtest, ccmtest);
	Creature_Model cmtest = new Creature_Model(ccmtest, ccctest);

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
