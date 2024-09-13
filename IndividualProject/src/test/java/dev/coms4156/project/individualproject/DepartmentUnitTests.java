package dev.coms4156.project.individualproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.HashMap;

@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  public static Department testDepartment;

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
  public void getNumberOfMajorsTest(){
    int expectedNumberTest = 2700;
    int actualNumber = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumberTest, actualNumber);
  }

  @Test
  public void getDepartmentChairTest(){
    String expectedDepartmentChair = "Luca Carloni";
    String actualDepartmentChair = testDepartment.getDepartmentChair();
    assertEquals(actualDepartmentChair, expectedDepartmentChair);
  }


  @Test
  public void addPersonToMajorTest(){
    int expectedNumberOfMajors  = 2700;
    testDepartment.addPersonToMajor();
    int newNumberOfMajors = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumberOfMajors, newNumberOfMajors);
  }

  @Test
  public void dropPersonFromMajorTest(){
    int expectedNumOfMajors = 2699;
    testDepartment.dropPersonFromMajor();
    int newNumberOfMajors = testDepartment.getNumberOfMajors();
    assertEquals(expectedNumOfMajors, newNumberOfMajors);
  }

  @Test
  public void addCourseTest(){
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String courseIDTest = "4018";
    Course phys4018 = new Course("James W McIver", "307 PUP", times[3], 30);
    testDepartment.addCourse(courseIDTest, phys4018);
    assertTrue(testDepartment.getCourseSelection().containsKey(courseIDTest));
  }

  @Test
  public void createCourseTest(){
    String courseIDTest = "4019";
    String testName = "James W McIver";
    String testCourseLocation = "307 PUP";
    String testCourseTimeSlot = "11:40-12:55";
    int testCapacity = 15;
    testDepartment.createCourse(courseIDTest, testName, testCourseLocation, testCourseTimeSlot, testCapacity);
    assertTrue(testDepartment.getCourseSelection().containsKey(courseIDTest));
  }

  @Test 
  public void toStringTest(){
    String expectedString = "COMS 1001: \nInstructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55\n";
    String actualString = testDepartment.toString();
    assertEquals(expectedString, actualString);
  }
  
}
