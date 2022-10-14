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
 * This class implements the BlackFish class, which swims back and forth between two tank objects
 */
public class BlackFish extends Fish {

  private TankObject source;
  private TankObject destination;

  /**
   * calls Fish constructor with black fish file name, and assigns the fish source and destination
   * 
   * @param source      where fish will swim from
   * @param destination where the fish will swim to, switching off
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }

  /**
   * makes one speed move towards destination
   * 
   * algorithm code uses to determine locations was based off given class material
   */
  public void moveTowardsDestination() {
    float dx = destination.getX() - this.getX();
    float dy = destination.getY() - this.getY();
    int d = (int) Math.sqrt(dx * dx + dy * dy);
    this.setX(getX() + (speed() * (dx) / d));
    this.setY(getY() + (speed() * (dy) / d));
  }

  /**
   * returns true if this black fish is over another tank object, and false otherwise
   * 
   * @param other the object that the fish is being compared to, the current destination
   * @return true if the images of the objects are overlapping
   */
  public boolean isOver(TankObject other) {
    float x1 = this.getX() - this.getImage().width / 2;
    float x2 = this.getX() + this.getImage().width / 2;
    float x3 = other.getX() - other.getImage().width / 2;
    float x4 = other.getX() + other.getImage().width / 2;

    float y1 = this.getY() - this.getImage().height / 2;
    float y2 = this.getY() + this.getImage().height / 2;
    float y3 = other.getY() - other.getImage().height / 2;
    float y4 = other.getY() + other.getImage().height / 2;

    return (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2);
  }

  /**
   * Overrides Fish.swim() method, makes one move towards destination then checks if images are
   * overlapping, if so then the source and destinations are swapped causing the Black fish to
   * travel back and forth between them
   */
  public void swim() {
    TankObject temp;
    this.moveTowardsDestination();

    if (this.isOver(destination)) {
      temp = destination;
      destination = source;
      source = temp;
    }
  }
}
