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
 * This class contains the constructor and methods for all button classes
 */
public class Button implements TankListener {

  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button

  /**
   * Creates a new button at a given location and sets its label
   * 
   * @param label the String to be displayed on the button
   * @param x     the x location for the button to be centered on
   * @param y     the y location for the button to be centered on
   */
  public Button(String label, float x, float y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }

  /**
   * sets the he PApplet display window where this button is displayed and handled
   * 
   * @param tank the display window used for all objects
   */
  public static void setProcessing(FishTank tank) {
    Button.tank = tank;
  }

  /**
   * Overrides the TankListener.isMouseOver() method Checks whether the mouse is over this button
   * 
   * @return true if the mouse is over this button, false otherwise.
   */
  public boolean isMouseOver() {
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }

  /**
   * Draws this button to the display window, filling with appropriate color based on if mouse is
   * over the button or not
   */
  public void draw() {
    tank.stroke(0);

    if (this.isMouseOver()) {
      tank.fill(100);
    } else
      tank.fill(200);

    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  /**
   * Overrides the TankListener.mousePressed() method Implements the default behavior of this button
   * when the mouse is pressed.
   */
  public void mousePressed() {
    if (this.isMouseOver()) {
      System.out.println("A button was pressed");
    }
  }

  /**
   * Overrides the TankListener.mouseReleased() method, implements the default behavior of this
   * button when the mouse is released.
   */
  public void mouseReleased() {
    // Leave this method empty
  }
}
