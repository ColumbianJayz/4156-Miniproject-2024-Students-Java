package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * These are where all the unit tests are.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }

/*
 * 
 * 
 * 
 * 
 */
  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void enrollStudentTest(){
    boolean enrollTest = testCourse.enrollStudent();
    boolean expectedResult = false;
    assertEquals(expectedResult, enrollTest);
  }


  @Test
  public void getCourseLocationTest(){
    String expectedLocation  = "417 IAB";
    String enrollTest = testCourse.getCourseLocation();
    assertEquals(expectedLocation, enrollTest);
  } 

  @Test
  public void getInstructorNameTest(){
    String expectedIntructorName = "Griffin Newbold";
    String test = testCourse.getInstructorName();
    assertEquals(expectedIntructorName, test);
  }

  @Test
  public void getCourseTimeSlotTest(){
    String expectedTimeSlot = "11:40-12:55";
    String timeTest = testCourse.getCourseTimeSlot();
    assertEquals(expectedTimeSlot, timeTest);
  }

  @Test
  public void reassignInstructorTest(){
    String expectedNewName = "Griffin Newbold";
    testCourse.reassignInstructor(expectedNewName);
    assertEquals(expectedNewName, testCourse.getInstructorName());
  }
  
  @Test
  public void reassignLocationTest(){
    String expectedLocationName = "417 IAB";
    testCourse.reassignLocation(expectedLocationName);
    assertEquals(expectedLocationName, testCourse.getCourseLocation());
  }

  @Test
  public void reassignTimeTest(){
    String expectedTime = "11:40-12:55";
    testCourse.reassignTime(expectedTime);
    assertEquals(expectedTime, testCourse.getCourseTimeSlot());
  }



  /** The test course instance used for testing. */
  public static Course testCourse;
}

