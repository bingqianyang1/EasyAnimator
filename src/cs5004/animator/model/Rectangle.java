package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents the shape Rectangle. It extends the AbstractShape class.
 */

public class Rectangle extends AbstractShape {

  /**
   * Initializes the Rectangle with a name, a Point2D position, a width, a height, a color, an
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
  public Rectangle(String name, Point2D position, double width, double height,
      Color color, double timeAppears, double timeDisappears) throws IllegalArgumentException {
    super(name, position, width, height, color, timeAppears, timeDisappears);
  }


  /**
   * Initializes the Rectangle with a name.
   * @param name the name of the Rectangle
   */
  public Rectangle(String name) {
    super(name);
  }



  @Override
  public ShapeType getShape() {
    return ShapeType.RECTANGLE;
  }


  @Override
  public String getShapeSvg() {
    return "<rect id=\"" + this.name + "\" x=\"" + this.position.getX()
        + "\" y =\"" + this.position.getY() + "\" width=\"" + this.width
        + "\" height=\"" + this.height + "\" fill=\"rgb(" + this.color.getRed() + ","
        + this.color.getGreen() + "," + this.color.getBlue() + ")\" >\n";
  }

  @Override
  public String getShapeSvgEnd() {
    return "</rect>";
  }

  @Override
  public String getShapeSvgX() {
    return "x";
  }

  @Override
  public String getShapeSvgY() {
    return "y";
  }

  @Override
  public String getShapeSvgWidth() {
    return "width";
  }

  @Override
  public String getShapeSvgHeight() {
    return "height";
  }


  /**
   * Returns the string in the format as below:
   * "Name: R"
   * "Type: rectangle"
   * "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)"
   * "Appears at t=1"
   * "Disappears at t=100".
   * @return the formatted string
   */
  @Override
  public String toString() {
    String res = "Name: " + this.name + "\nType: rectangle\nMin corner: ";
    res += this.position.toString();
    res += String.format(", Width: %.1f, Height: %.1f,", this.width, this.height);
    res += " Color: (" + this.color.getRed() + "," + this.color.getGreen() + ","
        + this.color.getBlue() + ")" + "\nAppears at t=" + this.timeAppears + "\nDisappears at t="
        + this.timeDisappears + "\n\n";
    return res;
  }
}
