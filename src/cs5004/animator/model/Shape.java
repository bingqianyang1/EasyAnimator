package cs5004.animator.model;

import java.awt.Color;

/**
 * This interface represents shapes and their information.
 * The information includes the name, the type, the position, the dimension,
 * the color of the shape, and the appear time and disappear time of the shape.
 */

public interface Shape {

  /**
   * Gets and returns the name of the shape.
   * @return the name of the shape
   */
  String getName();

  /**
   * Gets and returns the type of the shape.
   * @return the type of the shape
   */
  ShapeType getShape();

  /**
   * Gets and returns the x and y coordinates of the shape.
   * For rectangles, it returns the position of lower left corner.
   * For ovals, it returns the position of the center.
   * @return the position of the shape
   */
  Point2D getPosition();


  /**
   * Gets and returns the length of the width of the shape.
   * For oval, it returns the length of X radius.
   * @return the length of the width of the shape
   */
  double getWidth();

  /**
   * Gets and returns the height of the width of the shape.
   * For oval, it returns the length of Y radius.
   * @return the height of the width of the shape
   */
  double getHeight();


  /**
   * Gets and returns the color of the shape in the format of (red value, green value, blue value).
   * @return the color of the shape
   */
  Color getColor();


  /**
   * Gets and returns the time when the shape appears.
   * @return the time for the appearance of the shape
   */
  double getTimeAppears();

  /**
   * Gets and returns the time when the shape disappears.
   * @return the time for the disappearance of the shape
   */
  double getTimeDisappears();


  /**
   * Sets the shape to the given position.
   * @param newPos the coordinate of the given position
   */
  void setPosition(Point2D newPos);


  /**
   * Sets the color of the shape according to the intensity of color red, green, and blue.
   * @param color the intensity of (red, green, blue)
   */
  void setColor(Color color);


  /**
   * Sets the shape with the given width.
   * @param newWidth the new width for the shape to be set with
   */
  void setWidth(double newWidth);

  /**
   * Sets the shape with the given height.
   * @param newHeight the new height for the shape to be set with
   */
  void setHeight(double newHeight);

  /**
   * Sets the shape to appear at the given time.
   * @param timeAppears the given time for the shape to appear
   */
  void setTimeAppears(double timeAppears);

  /**
   * Sets the shape to disappear at the given time.
   * @param timeDisappears the given time for the shape to disappear
   */
  void setTimeDisappears(double timeDisappears);


  /**
   * Gets and returns the svg text for the shape.
   * @return the svg text for the shape
   */
  String getShapeSvg();

  /**
   * Gets and returns the ending svg text for the shape.
   * @return the ending svg text for the shape
   */
  String getShapeSvgEnd();

  /**
   * Gets and returns the svg text of x in the position of the shape.
   * @return the svg text for the field x
   */
  String getShapeSvgX();


  /**
   * Gets and returns the svg text of y in the position of the shape.
   * @return the svg text for the field y
   */
  String getShapeSvgY();



  /**
   * Gets and returns the svg text of width of the shape.
   * @return the svg text for the field width
   */
  String getShapeSvgWidth();

  /**
   * Gets and returns the svg text of height of the shape.
   * @return the svg text for the field height
   */
  String getShapeSvgHeight();


}
