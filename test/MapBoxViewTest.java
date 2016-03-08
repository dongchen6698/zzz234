package test;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import tdgame.controller.MapBoxController;
import tdgame.view.MapBoxView;

public class MapBoxViewTest {
	
	private static final String expected = null;
	private static final String ArrayIndexOutOfBoundsException = null;
	MapBoxView mbvtest;
	MapBoxController mbctest;
	MapBoxView mbvtest2;
	
	@Before
	public void SetupClassFiles(){
	mbctest = new MapBoxController();
	
	mbvtest = new MapBoxView(mbctest, 10, 10 );
	mbvtest2 = new MapBoxView(mbctest, 25, 20 );
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
