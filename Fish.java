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
 * This class serves as the default fish class implementing the constructor and the most common
 * behaviors as well as containing a generic constructor
 */
public class Fish extends TankObject {

  private int speed;
  private boolean isSwimming;

  /**
   * Constructor for Fish class that takes speed and file name, assigning each to a new TankObject
   * as well as assigning a random x and y position within the tank
   * 
   * @param speed             the set movement speed for the new fish
   * @param fishImageFileName the specific file name of fish wanted
   * @throws IllegalArgumentException if assigned the speed parameter is negative
   */
  public Fish(int speed, String fishImageFileName) throws IllegalArgumentException {
    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);

    if (speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }

    this.speed = speed;
  }

  /**
   * default Fish constructor with no parameters calls the previous constructor to make an orange
   * fish of speed 5 appear
   */
  public Fish() {
    this(5, "images" + File.separator + "orange.png");
  }

  /**
   * Overrides the draw() method implemented in the parent class. This method sets the position of
   * this fish to follow the mouse moves if it is dragging, calls its swim() method if it is
   * swimming, and draws it to the display window.
   */
  @Override
  public void draw() {

    if (isSwimming()) {
      // System.out.print("2");
      this.swim();
      tank.image(this.image, this.getX(), this.getY());
    } else {
      super.draw();
    }
  }

  /**
   * Checks whether this fish is swimming
   * 
   * @return true if the fish is swimming
   */
  public boolean isSwimming() {
    return isSwimming;
  }

  /**
   * Starts swimming this fish
   */
  public void startSwimming() {
    this.stopDragging();
    isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming() {
    isSwimming = false;
  }

  /**
   * Gets the speed of this fish
   * 
   * @return speed the current speed of the fish
   */
  public int speed() {
    return speed;
  }

  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  public void swim() {
    setX((getX() + speed) % tank.width);
  }
}
