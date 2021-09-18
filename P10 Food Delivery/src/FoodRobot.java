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
 * the food robot class represents a robot who has a special name and a position
 * 
 */
public class FoodRobot {
  private int x;
  private int y;
  private String name;

  /**
   * constructor of food robot object
   * 
   * @param x    the horizontal position of a student
   * @param y    the vertical position of a student
   * @param name the special name for a student
   */
  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  /**
   * Accessor to the x position of a robot
   * 
   * @return x the horizontal position of a robot
   */
  public int getX() {
    return x;
  }

  /**
   * Accessor to the y position of a robot
   * 
   * @return y the horizontal position of a robot
   */
  public int getY() {
    return y;
  }

  /**
   * Accessor to the name of a robot
   * 
   * @return name a string represents the name of a robot
   */
  public String getName() {
    return name;
  }

  /**
   * Returns a String representation of a robot with its position and name
   * 
   * @return a String representation of a robot's position and its name
   */
  @Override
  public String toString() {
    return getName() + "(" + getX() + ", " + getY() + ")";
  }
}
