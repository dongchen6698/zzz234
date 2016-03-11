package TD.testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CellContainer_ModelTest.class, Creature_ViewTest.class, MapCreation_ModelTest.class, MapBox_ViewTest.class, MapCreation_ViewTest.class, PlayScreen_ViewTest.class, Shop_ControllerTest.class, Creature_ModelTest.class, MapValidationTest.class})
//@SuiteClasses({MapCreation_ModelTest.class, MapBox_ViewTest.class, MapCreation_ViewTest.class})
public class TDSuite {
  //nothing
}