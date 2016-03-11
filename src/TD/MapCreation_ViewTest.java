package TD.testcase;


import static org.junit.Assert.*;

import org.junit.Test;

import TD.controller.MapBox_Controller;
import TD.view.MapCreation_View;

public class MapCreation_ViewTest {
	// Test Case to check if Adding Grid Function after getting Inputs from User is working as expected or not	
	@Test
	public void testAddGridMap() {
		boolean exp = true;
		MapCreation_View mctest = new MapCreation_View();
		MapBox_Controller mbtest = new MapBox_Controller();
		boolean act = mctest.addGridMap(mbtest);
		assertEquals(exp, act);	
	}
}
