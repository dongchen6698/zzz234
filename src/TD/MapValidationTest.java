package TD.testcase;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import TD.mapValidation.MapValidation;
import TD.model.PlayScreen_Model;

public class MapValidationTest {
	
	PlayScreen_Model psmodeltest = new PlayScreen_Model();
	
	@Test
	public void testIsValid_withoutEntryExit() {
		boolean temp = psmodeltest.LoadMap(new File("MapFilesTest/map_noEntryANDnoExit.dat"));
		MapValidation mvtest = new MapValidation(psmodeltest.getGridCellArray());
		boolean exp = false;
		boolean act = mvtest.isValid();
		assertEquals(exp, act);
	}
	
	@Test
	public void testIsValid_withoutPath() {
		boolean temp2 = psmodeltest.LoadMap(new File("MapFilesTest/map_noPath.dat"));
		MapValidation mvtest = new MapValidation(psmodeltest.getGridCellArray());
		boolean exp = false;
		boolean act = mvtest.isValid();
		assertEquals(exp, act);
	}
	
	@Test
	public void testIsValid_brokenPath() {
		boolean temp3 = psmodeltest.LoadMap(new File("MapFilesTest/map_breakPath.dat"));
		MapValidation mvtest = new MapValidation(psmodeltest.getGridCellArray());
		boolean exp = false;
		boolean act = mvtest.isValid();
		assertEquals(exp, act);
	}
	
	@Test
	public void testIsValid_validPath() {
		boolean temp4 = psmodeltest.LoadMap(new File("MapFilesTest/maptest.dat"));
		MapValidation mvtest = new MapValidation(psmodeltest.getGridCellArray());
		boolean exp = true;
		boolean act = mvtest.isValid();
		assertEquals(exp, act);
	}
}
