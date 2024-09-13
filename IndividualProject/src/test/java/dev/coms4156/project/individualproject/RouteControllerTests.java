package dev.coms4156.project.individualproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@ContextConfiguration

public class RouteControllerTests {
  /**
   * Setting these up as global variables.
   */
  public static RouteController routeController;
  public static HashMap<String, Department> departmentMapping;
  
  @BeforeAll
  public static void setupDepartmentForTesting() {
    routeController = new RouteController();
    HashMap<String, Course> courses = new HashMap<>();
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
  public void removeMajorFromDeptTest(){
    ResponseEntity<?> testResponse = routeController.removeMajorFromDept("COMS");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void dropStudentFromCourseTest(){
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
  public void changeCourseTeacher() {
    ResponseEntity<?> testResponse = routeController.changeCourseTeacher("COMS", 1001, "Margaret Thatcher");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }

  @Test
  public void changeCourseLocation() {
    ResponseEntity<?> testResponse = routeController.changeCourseLocation("COMS", 1001, "PUP 305");
    assertEquals(HttpStatus.OK, testResponse.getStatusCode());
  }
  
}
