package TD.testcase;


import java.io.File;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import TD.controller.MapBox_Controller;
import TD.model.MapCreation_Model;
public class MapCreation_ModelTest {

	MapCreation_Model mctest;
	MapBox_Controller mbtest;	

	@Before                        
	public void setUp() {	
		mctest = new MapCreation_Model();
		mbtest = new MapBox_Controller();		
	}
	
	
	//Testing the ReadFile Function to check if the map is able to determine invalid mapfiles with strings.

	@Test
	public void testReadFile() {
		boolean ans = true;
		File path = new File("MapFilesTest/maptest.dat");
		boolean org = mctest.readFile(mbtest,"maptest.dat",path);
		assertEquals(ans, org);
	}	
		
	@After
	public void teardown() {
		
		
	}

}
