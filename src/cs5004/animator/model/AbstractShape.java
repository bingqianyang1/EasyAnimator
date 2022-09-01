package cs5004.animator.model;

import java.awt.Color;


/**
 * This is an abstract shape class. It implements the Shape interface.
 */

public abstract class AbstractShape implements Shape {

  protected String name;
  protected Point2D position;
  protected double width;
  protected double height;
  protected Color color;
  protected double timeAppears;
  protected double timeDisappears;


  /**
   * Constructor 1:
   * Initializes the AbstractShape with a name, a Point2D position, a width,
   * a height, a color, an appearance time, and a disappearance time.
   * @param name the name of the shape
   * @param position the position of the shape
   * @param width the width of the shape
   * @param height the height of the shape
   * @param color the color of the shape
   * @param timeAppears the appearance time of the shape
   * @param timeDisappears the disappearance time of the shape
   * @throws IllegalArgumentException if the name is invalid, or if the width or height is invalid,
   *     or if the appearance interval is invalid.
   */
  public AbstractShape(String name, Point2D position, double width,
      double height, Color color, double timeAppears, double timeDisappears)
      throws IllegalArgumentException {
    if (name.equals("")) {
      throw new IllegalArgumentException("The shape should have a name!");
    }
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The scale of the shape must be positive!");
    }
    if (timeAppears < 0 || timeDisappears < 0 || timeAppears > timeDisappears) {
      throw new IllegalArgumentException("Invalid appearance time!");
    }
    this.name = name;
    this.position = position;
    this.width = width;
    this.height = height;
    this.color = color;
    this.timeAppears = timeAppears;
    this.timeDisappears = timeDisappears;
  }

  /**
   * Constructor 2:
   * Initializes the Shape with the name.
   * @param name the name of the shape
   */
  public AbstractShape(String name) {
    this.name = name;
  }



  @Override
  public String getName() {
    return this.name;
  }


  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public double getTimeAppears() {
    return this.timeAppears;
  }

  @Override
  public double getTimeDisappears() {
    return this.timeDisappears;
  }

  @Override
  public void setPosition(Point2D newPos) {
    this.position = newPos;

  }

  @Override
  public void setColor(Color color) {
    this.color = color;



  }

  @Override
  public void setWidth(double newWidth) {
    this.width = newWidth;

  }

  @Override
  public void setHeight(double newHeight) {
    this.height = newHeight;

  }

  @Override
  public void setTimeAppears(double timeAppears) {
    this.timeAppears = timeAppears;

  }

  @Override
  public void setTimeDisappears(double timeDisappears) {
    this.timeDisappears = timeDisappears;
  }

}
