//////////////// FILE HEADER //////////////////////////
//
// Title: P10 Food Delivery
// Files: Delivery, Student, FoodRobot, DeliveryQueue, DeliveryQueueTester, DeliverySchedolingApp
// Course: CS300,Spring,2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE (identify each person and describe their help in detail)
// Online Sources: NONE (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * the delivery class represents a combination of a student object and a robot object
 * 
 * @implSpec Comparable interface in Delivery type of object
 */
public class Delivery implements Comparable<Delivery> {
  private int studentId;
  private String robotName;
  private int distance;

  /**
   * constructor of food robot object
   * 
   * @param student a student object with position and id information
   * @param robot   a robot object with position and name information
   */
  public Delivery(Student student, FoodRobot robot) {
    this.studentId = student.getId();
    this.robotName = robot.getName();
    this.distance = // calculate the distance by given formula and store it in the distance
        Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY());
  }

  /**
   * compare two delivery object to determine the priority
   * 
   * @implSpec Comparable interface in Delivery type of object
   * @param delivery a combination of student and robot
   * @return a integer that represents the differences between two object, determined by distance,
   *         student id, or robot name
   */
  @Override
  public int compareTo(Delivery d) {
    if (this.distance != d.distance)// firstly, check if the distance stored is different
      return this.distance - d.distance;// return the differences
    else {
      if (this.studentId != d.studentId)// if it is the same, compare the id of two students
        return this.studentId - d.studentId;
      else {
        return this.robotName.compareTo(d.robotName); // if the students are the same, compare two
                                                      // robots' names
      }
    }
  }

  /**
   * Check if two object are equal
   * 
   * @implSpec Object class
   * @param o an object that can be delivery, student, or robot type
   * @return true if they are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Delivery) {// if the input is a delivery object
      Delivery current = (Delivery) o;
      if (this.studentId == current.studentId)// check if their students' id are the same
        return true;
      if (this.robotName.equals(current.robotName))// check if their robots' name are the same
        return true;
      else
        return false;// if not, return false
    } else if (o instanceof Student) {// if the input is a student object
      Student current = (Student) o;
      if (this.studentId == current.getId())// check if their students' id are the same
        return true;
      else
        return false;
    } else if (o instanceof FoodRobot) {// if the input is a food robot object
      FoodRobot current = (FoodRobot) o;
      if (this.robotName.equals(current.getName()))// check if their students' id are the same
        return true;
      else
        return false;
    }
    return false;
  }

  /**
   * Returns a String representation of a delivery object with its student's id and robot's name
   * 
   * @implSpec Object class
   * @return a String representation of a delivery object
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }
}
