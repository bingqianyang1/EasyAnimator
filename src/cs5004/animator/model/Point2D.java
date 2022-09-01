package cs5004.animator.model;

/**
 * This class represent the x and y coordinates of a point.
 */

public class Point2D {

  private double x;
  private double y;

  /**
   * Initializes the position of the given point with x coordinate and y coordinate.
   * @param x the x coordinate of the point
   * @param y the y coordinate of the point
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets and returns the x coordinate.
   * @return x coordinate of the point
   */
  public double getX() {
    return this.x;
  }

  /**
   * Gets and returns the y coordinate.
   * @return y coordinate of the point
   */
  public double getY() {
    return this.y;
  }

  /**
   * The method sets the x coordinate of the point.
   * @param x the given x coordinate
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * This method sets the y coordinate of the point.
   * @param y the given x coordinate
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Returns the string in the format of "(x,y)".
   * @return the formatted string representation
   */
  public String toString() {
    return String.format("(%.1f,%.1f)", this.x, this.y);
  }

}
