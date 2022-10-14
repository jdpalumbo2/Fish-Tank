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
 * This class serves as the default constructor for all objects in the tank, giving object location
 * and characteristic fields, and contains many methods for lower classes to use for their own
 * operations
 */
public class TankObject implements TankListener {

  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  /**
   * Constructor for all tank objects, takes a location and file name then assigns them to the
   * objects fields, placing it there. Also sets dragging to false as default
   * 
   * @param x             x-location to place the new TankObject in
   * @param y             y-location to place the new TankObject
   * @param imageFileName the specific file name that should be looked up for the specific object
   */
  public TankObject(float x, float y, String imageFileName) {
    this.x = x;
    this.y = y;
    this.image = tank.loadImage(imageFileName);
    isDragging = false;
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank the tank reference used to assign the new TankObject to
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank; // set the PApplet Object where this decoration object will
    // be drawn
  }

  /**
   * Moves this tank object with dx and dy
   * 
   * @param dx move to the x-position of this tank object
   * @param dy move to the y-position of this tank object
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /**
   * Returns the x-position of this tank object
   *
   * @return x the current x position of the object
   */
  public float getX() {
    return x;
  }

  /**
   * Returns the y-position of this tank object
   *
   * @return y the current x position of the object
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x to set the current x position to
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y-position of this object
   * 
   * @param y to set he y position to
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Returns the image of this tank object
   *
   * @return image the image of the TankObject
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this tank object and updates old position
   */
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * updates position of object and prints repeatedly
   */
  @Override
  public void draw() {
    // TODO Auto-generated method stub
    if (this.isDragging) {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }

    // draw this decoration object at its current position
    tank.image(this.image, this.x, this.y);
  }

  /**
   * sets dragging to true for the object if it returns true for the mousePressed method
   */
  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub
    this.startDragging();
  }

  /**
   * stops dragging for object when mouse is released
   */
  @Override
  public void mouseReleased() {
    // TODO Auto-generated method stub
    this.stopDragging();
  }

  /**
   * using the image width and height, returns whether or not the mouse is over the object
   * 
   * @return true
   */
  @Override
  public boolean isMouseOver() {
    // TODO Auto-generated method stub
    // checks if the mouse is over this object
    int fishWidth = image.width;
    int fishHeight = image.height;

    return tank.mouseX >= x - fishWidth / 2 && tank.mouseX <= x + fishWidth / 2
        && tank.mouseY >= y - fishHeight / 2 && tank.mouseY <= y + fishHeight / 2;
  }
}


