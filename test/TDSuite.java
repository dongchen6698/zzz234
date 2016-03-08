import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tdgame.model.MapCreationModel;

@RunWith(Suite.class)
@Suite.SuiteClasses({CellContainerModelTest.class, CreatureViewTest.class, MapCreationModelTest.class, MapBoxViewTest.class, MapCreationViewTest.class, PlayScreenViewTest.class, ShopControllerTest.class, CreatureModelTest.class, MapValidationTest.class})
@Suite.SuiteClasses({MapCreationModelTest.class, MapBoxViewTest.class, MapCreationViewTest.class})
public class TDSuite {
  //nothing
}