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
 * the Student class represents a student who has a special ID and a position
 * 
 */
public class Student {
  private int x;// the horizontal position of a student
  private int y;// the vertical position of a student
  private int id;// the special number for a student

  /**
   * constructor of student object
   * 
   * @param x  the horizontal position of a student
   * @param y  the vertical position of a student
   * @param id the special number for a student
   */
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * Accessor to the x position of a student
   * 
   * @return x the horizontal position of a student
   */
  public int getX() {
    return x;
  }

  /**
   * Accessor to the y position of a student
   * 
   * @return y the vertical position of a student
   */
  public int getY() {
    return y;
  }

  /**
   * Accessor to the x position of a student
   * 
   * @return id the special number for a student
   */
  public int getId() {
    return id;
  }

  /**
   * Returns a String representation of a student with its position and id
   * 
   * @return a String representation of a student's position and id number
   */
  @Override
  public String toString() {
    return getId() + "(" + getX() + ", " + getY() + ")";
  }
}
