

import static org.junit.Assert.*;

import org.junit.Test;

import tdgame.model.CellContainerModel;

public class CellContainerModelTest {

	CellContainerModel ccModel;
	
	@Test
	public void testCellContainerModel() {
		ccModel = new CellContainerModel(5, 5);
		boolean exp = true;
		boolean act = ccModel.setCellContainerModel(5, 5);
		assertEquals(exp, act);
	}

}
