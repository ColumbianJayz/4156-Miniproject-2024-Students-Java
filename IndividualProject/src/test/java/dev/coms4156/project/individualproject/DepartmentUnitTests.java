package dev.coms4156.project.individualproject;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Sets up the testDepartment test suite.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {
  /**
   * Makes testDepartment a global variable.
   */
  public static Department testDepartment;

  /**
   * Sets Department up for testing.
   */
  @BeforeAll
  public static void setupDepartmentForTesting() {
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String[] locations = {"417 IAB", "309 HAV", "301 URIS"};
    Course coms1004 = new Course("Adam Cannon", locations[0], times[0], 400);
    coms1004.setEnrolledStudentCount(249);
    HashMap<String, Course> courses = new HashMap<>();
    courses.put("1001", coms1004);

    testDepartment = new Department("COMS", courses, "Luca Carloni", 2700);
  }

  @Test
  public void getNumberOfMajorsTest() {
    int expectedNumberTest = 2700;
    int actualNumber = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumberTest, actualNumber);
  }

  @Test
  public void getDepartmentChairTest() {
    String expectedDepartmentChair = "Luca Carloni";
    String actualDepartmentChair = testDepartment.getDepartmentChair();
    assertEquals(actualDepartmentChair, expectedDepartmentChair);
  }


  @Test
  public void addPersonToMajorTest() {
    int expectedNumberOfMajors  = 2700;
    testDepartment.addPersonToMajor();
    int newNumberOfMajors = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumberOfMajors, newNumberOfMajors);
  }

  @Test
  public void dropPersonFromMajorTest() {
    int expectedNumOfMajors = 2699;
    testDepartment.dropPersonFromMajor();
    int newNumberOfMajors = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumOfMajors, newNumberOfMajors);
  }

  @Test
  public void addCourseTest() {
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String courseIdTest = "4018";
    Course phys4018 = new Course("James W McIver", "307 PUP", times[3], 30);
    testDepartment.addCourse(courseIdTest, phys4018);
    assertTrue(testDepartment.getCourseSelection().containsKey(courseIdTest));
  }

  @Test
  public void createCourseTest() {
    String courseIdTest = "4019";
    String testName = "James W McIver";
    String testCourseLocation = "307 PUP";
    String testCourseTimeSlot = "11:40-12:55";
    int testCapacity = 15;
    testDepartment.createCourse(courseIdTest, testName, 
        testCourseLocation, 
        testCourseTimeSlot, testCapacity);
    assertTrue(testDepartment.getCourseSelection().containsKey(courseIdTest));
  }

  @Test 
  public void toStringTest() {
    String expectedString =
        "COMS 1001: \nInstructor: Adam Cannon;" 
        + "Location: 417 IAB; Time: 11:40-12:55\n";
    String actualString = testDepartment.toString();
    assertEquals(expectedString, actualString);
  }
  
}
