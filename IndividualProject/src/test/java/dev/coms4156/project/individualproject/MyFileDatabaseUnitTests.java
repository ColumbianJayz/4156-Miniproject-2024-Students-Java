package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This the MyFileDatabase Test Suite.
 */
public class MyFileDatabaseUnitTests {
  public static MyFileDatabase testDatabase;
  public static Map<String, Department> testMapping;

  /**
   * Sets us for a test database.
   */
  @BeforeAll
  public static void setupDatabaseForTesting() {
    testDatabase = new MyFileDatabase(0, "./data.txt");
    testMapping = new HashMap<>();
    Map<String, Course> courses = new HashMap<>();
    Department comsDept = new Department("COMS", courses, "Luca Carloni", 2700);
    testMapping.put("COMS", comsDept);
  }
  
  @Test
  public void toStringTest() {
    String expectedString = "For the COMS department: \n" + testMapping.get("COMS").toString();
    String actualString = testDatabase.toString();
    assertEquals(expectedString, actualString);
  }

 






  
}
