package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;

/**
 * Sets up the class Course.
 */
public class Course implements Serializable {

  /**
   * Constructs a new Course object with the given parameters. Initial count starts at 0.
   *
   * @param instructorName     The name of the instructor teaching the course.
   * @param courseLocation     The location where the course is held.
   * @param timeSlot           The time slot of the course.
   * @param capacity           The maximum number of students that can enroll in the course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 500;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (enrolledStudentCount < enrollmentCapacity) {
      enrolledStudentCount++;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    if (enrolledStudentCount < 1) {
      return false;
    } else {
      enrolledStudentCount--;
      return true;
    }
  }
  /**
  * Retrieves the course location if there is any.
  *
  * @return The location of the course.
  */

  public String getCourseLocation() {
    return this.courseLocation;
  }
  /**
  * Retrieves the instructor name.
  *
  * @return The instructor name.
  */

  public String getInstructorName() {
    return this.instructorName;
  }
  /**
  * Retrieves the time slot for a course.
  *
  * @return The time slot for the course.
  */

  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }
  /**
  * Creates a string with course information.
  *
  * @return A string with the instructor name, location, and time for a course.
  */
  
  @Override
  public String toString() {
    return "\nInstructor: " + instructorName +  "; Location: "  
      + courseLocation +  "; Time: " + courseTimeSlot;
  }
  /**
  * Reassigns a new instructor for a course.
  *
  * @param newInstructorName The name of the new instructor.
  */

  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }
  /**
  * Reassigns a new location for a course.
  *
  * @param newLocation The name of the new location.
  */

  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }
  /**
  * Reassigns a new time for a course.
  *
  * @param newTime The new time for a course.
  */

  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }
  /**
  * Sets the enrolled student amount to the count being passed in.
  *
  * @param count The count to set the enrolled student amount.
  */

  public void setEnrolledStudentCount(int count) {
    this.enrolledStudentCount = count;
  }
  /**
  * Checks if the course is full.
  *
  * @return False if the course isn't full, true if it is.
  */

  public boolean isCourseFull() {
    return enrollmentCapacity < enrolledStudentCount;
  }

  @Serial
  private static final long serialVersionUID = 123456L;
  private final int enrollmentCapacity;
  private int enrolledStudentCount;
  private String courseLocation;
  private String instructorName;
  private String courseTimeSlot;
}
