//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Fish Tank 3000
// Course: CS 300 Spring 2022
//
// Author: Johnny Palumbo
// Email: jdpalumbo2@wisc.edu
// Lecturer: Michelle Jensen
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: na
// Partner Email: na
// Partner Lecturer's Name: na
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class uses the button class to add a clear button to the tank, which removes all fish from
 * the tank
 */
public class ClearTankButton extends Button {

  /**
   * calls Button constructor with label and location
   * 
   * @param x x location for button center
   * @param y y location for button center
   */
  public ClearTankButton(float x, float y) {
    super("clear", x, y);
  }

  /**
   * checks if mouse was pressed over the button and calls the tank.clear method if so
   */
  public void mousePressed() {
    tank.clear();
  }
}
