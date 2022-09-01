package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents the action of changing color of the shape in the animation.
 * It extends the AbstractAnimation class.
 */


public class ChangeColor extends AbstractAnimation {
  private int fromRed;
  private int fromGreen;
  private int fromBlue;
  private int toRed;
  private int toGreen;
  private int toBlue;

  /**
   * Initializes the ChangeColor class with the inputs of shape, moving starting time,
   * moving finishing time, beginning color (combination of rgb intensity) of the shape,
   * and the ending color (combination of rgb intensity) of shape after the animation.
   * @param shape      the shape of the animation
   * @param startTime  the starting time of the animation
   * @param finishTime the finishing time of the animation
   * @param fromRed the intensity of red in the beginning color of the shape
   * @param fromGreen the intensity of green in the beginning color of the shape
   * @param fromBlue the intensity of blue in the beginning color of the shape
   * @param toRed the intensity of red of the shape's color after animation
   * @param toGreen the intensity of green of the shape's color after animation
   * @param toBlue the intensity of blue of the shape's color after animation
   * @throws IllegalArgumentException if the shape, or the time of the animation is invalid
   */
  public ChangeColor(Shape shape, double startTime, double finishTime,
      int fromRed, int fromGreen, int fromBlue, int toRed, int toGreen, int toBlue)
      throws IllegalArgumentException {
    super(shape, startTime, finishTime);
    this.fromRed = fromRed;
    this.fromGreen = fromGreen;
    this.fromBlue = fromBlue;
    this.toRed = toRed;
    this.toGreen = toGreen;
    this.toBlue = toBlue;
  }

  @Override
  public AnimationType getAnimationType() {
    return AnimationType.COLOR;

  }



  @Override
  public Shape shapeTweening(double time) {
    if (time > finishTime) {
      time = finishTime;
    }
    int red = (int) (fromRed * ((finishTime - time) / (finishTime - startTime))
        + toRed * ((time - startTime) / (finishTime - startTime)));
    if (red > 255) {
      red = 255;
    }
    if (red < 0) {
      red = 0;
    }
    int green = (int) (fromGreen * ((finishTime - time) / (finishTime - startTime))
        + toGreen * ((time - startTime) / (finishTime - startTime)));
    if (green > 255) {
      green = 255;
    }
    if (green < 0) {
      green = 0;
    }
    int blue = (int) (fromBlue * ((finishTime - time) / (finishTime - startTime))
        + toBlue * ((time - startTime) / (finishTime - startTime)));
    if (blue > 255) {
      blue = 255;
    }
    if (blue < 0) {
      blue = 0;
    }
    this.shape.setColor(new Color(red, green, blue));
    return this.shape;
  }

  @Override
  public String getAnimationSvg(double speed) {
    double start = this.startTime / speed;
    double dur = (this.finishTime - this.startTime) / speed;
    return "<animate attributeType=\"XML\" begin=\"" + start + "s\" dur=\""
        + dur + "s\" attributeName=\"fill\" from=\"rgb(" + this.fromRed + ","
        + this.fromGreen + "," + this.fromBlue + ")\" to=\"rgb(" + this.toRed + ","
        + this.toGreen + "," + this.toBlue + ")\" fill=\"freeze\" />\n";

  }



  /**
   * Gets and returns the beginning color's red intensity.
   * @return the beginning red intensity of the animation
   */
  public int getFromRed() {
    return this.fromRed;
  }

  /**
   * Gets and returns the beginning color's green intensity.
   * @return the beginning green intensity of the animation
   */
  public int getFromGreen() {
    return this.fromGreen;
  }

  /**
   * Gets and returns the beginning color's blue intensity.
   * @return the beginning blue intensity of the animation
   */
  public int getFromBlue() {
    return this.fromBlue;
  }

  /**
   * Gets and returns the ending color's red intensity.
   * @return the ending red intensity of the animation
   */
  public int getToRed() {
    return this.toRed;
  }

  /**
   * Gets and returns the ending color's green intensity.
   * @return the ending green intensity of the animation
   */
  public int getToGreen() {
    return this.toGreen;
  }

  /**
   * Gets and returns the ending color's blue intensity.
   * @return the ending blue intensity of the animation
   */
  public int getToBlue() {
    return this.toBlue;
  }

  /**
   * Returns the string in the format as below:
   * "Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80".
   * @return the formatted string
   */
  @Override
  public String toString() {
    return "Shape " + this.getName() + " changes color from " + "(" + this.fromRed + ","
        + this.fromGreen + "," + this.fromBlue + ") to (" + this.toRed + "," + this.toGreen + ","
        + this.toBlue + ") from t=" + this.startTime + " to t=" + this.finishTime + "\n";
  }


}
