

import static org.junit.Assert.*;

import org.junit.Test;

import tdgame.controller.MapBoxController;
import tdgame.view.MapCreationView;

public class MapCreationViewTest {
	
	
	// Test Case to check if Adding Grid Function after getting Inputs from User is working as expected or not
	
	@Test
	public void testAddGridMap() {
		boolean exp = true;
		MapCreationView mctest = new MapCreationView();
		MapBoxController mbtest = new MapBoxController();
		boolean act = mctest.addGridMap(mbtest);
		assertEquals(exp, act);
		
		
	}

}
