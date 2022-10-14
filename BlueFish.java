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

import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class contains the constructor and behavior for the blue fish, which swims in the opposite
 * direction
 */
public class BlueFish extends Fish {

  /**
   * calls the Fish constructor but changes the file name call to the blue fish file, also sets
   * speed of 2
   */
  public BlueFish() {
    super(2, "images" + File.separator + "blue.png");
  }

  /**
   * only overriding method of this class moves the fish in the reverse direction, from right to
   * left, as the blue fish faces the opposite way.
   */
  @Override
  public void swim() {
    float newX = getX() - speed();
    newX += ((newX < 0) ? tank.width : 0); // checks if new x position will be > 0, and adds a
                                           // tank's width if it will be off the screen
    setX(newX % tank.width);
  }

}
