package TD.testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import TD.controller.MapBox_Controller;
import TD.view.MapBox_View;

public class MapBox_ViewTest {
	
	MapBox_View mbvtest;
	MapBox_Controller mbctest;
	MapBox_View mbvtest2;
	
	@Before
	public void SetupClassFiles(){
		mbctest = new MapBox_Controller();	
		mbvtest = new MapBox_View(mbctest, 10, 10 );
		mbvtest2 = new MapBox_View(mbctest, 25, 20 );
	}
	
	@Test
	public void testSetEntryPointFlag() {
		boolean exp = true;
		boolean act = (boolean) mbvtest.setEntryPointFlag();
		assertEquals(exp, act);
	}

	@Test
	public void testSetPathPointFlag() {
		boolean exp = true;
		boolean act = (boolean) mbvtest.setPathPointFlag();
		assertEquals(exp, act);
	}

	@Test
	public void testSetExitPointFlag() {
		boolean exp = true;
		boolean act = (boolean) mbvtest.setEntryPointFlag();
		assertEquals(exp, act);
	}

	@Test
	public void testSetSlectedCell() {
		boolean exp = true;
		boolean act = (boolean) mbvtest.setSlectedCell();
		assertEquals(exp, act);
		
	}
	
	// Testing the Entry Point Location

	@Test
	public void testSetEntryPoint() {
		boolean act = (boolean) mbvtest.setEntryPoint(8,0);
		assertTrue(act);
	}
	
	@Test
	public void testSetEntryPoint2() {
		boolean act = (boolean) mbvtest2.setEntryPoint(19,24);
		assertFalse(act);
	}

	
  // Testing the Exit Point Location
	
	@Test
	public void testSetExitPoint() {
		boolean act = (boolean) mbvtest.setExitPoint(3, 9);
		assertTrue(act);
	}
	
	@Test
	public void testSetExitPoint2() {
		
		boolean act = (boolean) mbvtest2.setExitPoint(19, 24);
		assertTrue(act);
		
	}

}
