package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents the shape Oval. It extends the AbstractShape class.
 */

public class Oval extends AbstractShape {

  /**
   * Initializes the Oval with a name, a Point2D position, a width, a height, a color, an
   * appearance time, and a disappearance time.
   * @param name           the name of the shape
   * @param position       the position of the shape
   * @param width          the width of the shape
   * @param height         the height of the shape
   * @param color          the color of the shape
   * @param timeAppears    the appearance time of the shape
   * @param timeDisappears the disappearance time of the shape
   * @throws IllegalArgumentException if the name is invalid, or if the width or height is invalid,
   *                                  or if the appearance interval is invalid.
   */
  public Oval(String name, Point2D position, double width, double height,
      Color color, double timeAppears, double timeDisappears) throws IllegalArgumentException {
    super(name, position, width, height, color, timeAppears, timeDisappears);
  }


  /**
   * Initializes the Oval with a name.
   * @param name the name of the Oval
   */
  public Oval(String name) {
    super(name);
  }

  @Override
  public ShapeType getShape() {
    return ShapeType.OVAL;
  }


  @Override
  public String getShapeSvg() {
    return "<ellipse id=\"" + this.name + "\" cx=\"" + this.position.getX()
        + "\" cy =\"" + this.position.getY() + "\" rx=\"" + this.width / 2
        + "\" ry=\"" + this.height / 2 + "\" fill=\"rgb(" + this.color.getRed() + ","
        + this.color.getGreen() + "," + this.color.getBlue() + ")\" >\n";
  }

  @Override
  public String getShapeSvgEnd() {
    return "</ellipse>";
  }

  @Override
  public String getShapeSvgX() {
    return "cx";
  }

  @Override
  public String getShapeSvgY() {
    return "cy";
  }

  @Override
  public String getShapeSvgWidth() {
    return "rx";
  }

  @Override
  public String getShapeSvgHeight() {
    return "ry";
  }


  /**
   * Returns the string in the format as below:
   * "Name: C"
   * "Type: oval"
   * "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)"
   * "Appears at t=6"
   * "Disappears at t=100"
   * @return the formatted string
   */
  @Override
  public String toString() {
    String res = "Name: " + this.name + "\nType: oval\nCenter: ";
    res += this.position.toString();
    res += String.format(", X radius: %.1f, Y radius: %.1f,", this.width, this.height);
    res += " Color: (" + this.color.getRed() + "," + this.color.getGreen() + ","
        + this.color.getBlue() + ")" + "\nAppears at t=" + this.timeAppears + "\nDisappears at t="
        + this.timeDisappears + "\n\n";

    return res;
  }


}
