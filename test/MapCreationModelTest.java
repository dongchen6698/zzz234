

import java.io.File;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




import tdgame.controller.MapBoxController;
import tdgame.model.MapCreationModel;

public class MapCreationModelTest {

	private static final String String = null;
	MapCreationModel mctest;
	MapBoxController mbtest;
	

	@Before                        
	public void setUp() {
		
		mctest = new MapCreationModel();
		mbtest = new MapBoxController();
		
	}
	
	
	//Testing the ReadFile Function to check if the map is able to determine invalid mapfiles with strings.

	@Test
	public void testReadFile() {
		boolean ans = true;
		File path = new File("MapFilesTest/Rahul.team7");
		boolean org = mctest.readFile(mbtest,"Rahul" ,path);
		assertEquals(ans, org);
	}	
	
	
	
	@After
	public void teardown() {
		
		
	}

}
