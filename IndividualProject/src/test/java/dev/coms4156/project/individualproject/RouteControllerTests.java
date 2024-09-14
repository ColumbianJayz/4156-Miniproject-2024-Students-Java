package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;


/**
 * This is the RouteController Test Suite.
 */
@SpringBootTest
@ContextConfiguration

public class RouteControllerTests {
  /**
   * Setting these up as global variables.
   */
  public static RouteController routeController;
  public static Map<String, Department> departmentMapping;
  
  /**
   * Sets up the route controller for testing.
   */
  @BeforeAll
  public static void setupDepartmentForTesting() {
    routeController = new RouteController();
    Map<String, Course> courses = new HashMap<>();
    departmentMapping = new HashMap<>();
    Course coms1004 = new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400);
    courses.put("1001", coms1004);
    String keyTest = "COMS";
    Department testDepartment = new Department("COMS", courses, "Luca Carloni", 2700);
    departmentMapping.put(keyTest, testDepartment);
    IndividualProjectApplication.myFileDatabase = new MyFileDatabase(0, "./data.txt");
    IndividualProjectApplication.myFileDatabase.setMapping(departmentMapping);
  }

  @Test
  public void retrieveDepartmentTest() {
    ResponseEntity<?> testResponse = routeController.retrieveDepartment("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void indexTest() { 
    String testResponse = 
        "Welcome, in order to make an API call direct your browser or Postman to an endpoint "
        + "\n\n This can be done using the following format: \n\n http:127.0.0"
        + ".1:8080/endpoint?arg=value";
    String actualResponse = routeController.index();
    assertEquals(testResponse, actualResponse);
  }

  @Test
  public void handleExceptionTest() {
    Exception testException = new Exception("Test Exception");
    ResponseEntity<?> response = routeController.handleException(testException);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void retrieveCourseTest() {
    ResponseEntity<?> testResponse = routeController.retrieveCourse("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void isCourseFullTest() {
    ResponseEntity<?> testResponse = routeController.isCourseFull("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void isCourseFullTesCoursetNotFoundCheck() {
    ResponseEntity<?> testResponse = routeController.isCourseFull("COMS", 3848989);
    assertEquals(HttpStatus.NOT_FOUND, testResponse.getStatusCode());
  }

  @Test
  public void isCourseFullTestDepartmentNotFoundCheck() {
    ResponseEntity<?> testResponse = routeController.isCourseFull("BABE", 1001);
    assertEquals(HttpStatus.NOT_FOUND, testResponse.getStatusCode());
  }


  @Test
  public void getMajorCountFromDeptTest() {
    ResponseEntity<?> testResponse = routeController.getMajorCtFromDept("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void identifyDeptChairTest() {
    ResponseEntity<?> testResponse = routeController.identifyDeptChair("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void findCourseLocation() {
    ResponseEntity<?> testResponse = routeController.findCourseLocation("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void findCourseInstructor() {
    ResponseEntity<?> testResponse = routeController.findCourseInstructor("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void findCourseTimeTest() {
    ResponseEntity<?> testResponse = routeController.findCourseTime("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());

  }

  @Test
  public void addMajorToDeptTest() {
    ResponseEntity<?> testResponse = routeController.addMajorToDept("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }
  
  @Test
  public void removeMajorFromDeptTest() {
    ResponseEntity<?> testResponse = routeController.removeMajorFromDept("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void dropStudentFromCourseTest() {
    ResponseEntity<?> testResponse = routeController.dropStudent("COMS", 1001);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void setEnrolledStudentCountTest() {
    ResponseEntity<?> testResponse = routeController.setEnrollmentCount("COMS", 1001, 2);
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }


  @Test
  public void changeCourseTimeTest() {
    ResponseEntity<?> testResponse = routeController.changeCourseTime("COMS", 1001, "11:40-12:55");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseTimeTestFakeCourse() {
    ResponseEntity<?> testResponse = routeController.changeCourseTime("COMS", 9999, "10:40-12:55");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseTimeFakeDepartment() {
    ResponseEntity<?> testResponse = routeController.changeCourseTime("MOMOS", 1001, "10:40-12:55");
    assertEquals(HttpStatus.NOT_FOUND, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseTimeExceptionSection() {
    ResponseEntity<?> testResponse = routeController.changeCourseTime(null, 1001, "10:40-12:55");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseTeacher() {
    ResponseEntity<?> testResponse = routeController.changeCourseTeacher("COMS", 
        1001, "Margaret Thatcher");
    assertEquals(HttpStatus.NOT_FOUND, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseLocation() {
    ResponseEntity<?> testResponse = routeController.changeCourseLocation("COMS", 1001, "PUP 305");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

}
