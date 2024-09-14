package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This is the IndividualProjectApplication Test Suite.
 */
public class IndividualProjectApplicationUnitTest {

  @BeforeAll
  public static void setUpTest() {
    IndividualProjectApplication.myFileDatabase = new MyFileDatabase(0, "./data.txt");
  }  

  @Test
  public void resetDataFileTest() {
    IndividualProjectApplication test = 
        new IndividualProjectApplication();
    test.resetDataFile();
    Map<String, Department> departmentMapping = 
        IndividualProjectApplication.myFileDatabase.getDepartmentMapping();
    assertTrue(departmentMapping.containsKey("COMS"));
    assertTrue(departmentMapping.containsKey("ECON"));
    assertTrue(departmentMapping.containsKey("CHEM"));
    assertTrue(departmentMapping.containsKey("PSYC"));
  }
}
