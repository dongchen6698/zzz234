package TD.testcase;

import static org.junit.Assert.*;
import org.junit.Test;

import TD.model.CellContainer_Model;

public class CellContainer_ModelTest {

	CellContainer_Model ccModel;
	
	@Test
	public void testCellContainer_Model() {
		ccModel = new CellContainer_Model(5, 5);
		boolean exp = true;
		boolean act = ccModel.setCellContainerModel(5, 5);
		assertEquals(exp, act);
	}

}
