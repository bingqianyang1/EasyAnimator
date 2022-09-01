package cs5004.animator.model;



/**
 * This class represents the action of changing scale of the shape in the animation.
 * It extends the AbstractAnimation class.
 */

public class ChangeScale extends AbstractAnimation {

  private final double fromWidth;
  private final double fromHeight;
  private final double toWidth;
  private final double toHeight;

  /**
   * Initializes the ChangeScale class with inputs of shape, moving starting time,
   * moving finishing time, width and height at the begin,
   * and width and height after the animation.
   * @param shape      the shape of the animation
   * @param startTime  the starting time of the animation
   * @param finishTime the finishing time of the animation
   * @param fromWidth the beginning width of the animation
   * @param fromHeight the beginning height of the animation
   * @param toWidth the ending width of the animation
   * @param toHeight the ending height of the animation
   * @throws IllegalArgumentException if the shape, or the time of the animation is invalid
   */
  public ChangeScale(Shape shape, double startTime, double finishTime,
      double fromWidth, double fromHeight, double toWidth, double toHeight)
      throws IllegalArgumentException {
    super(shape, startTime, finishTime);
    if (fromWidth <= 0 || fromHeight <= 0 || toWidth <= 0 || toHeight <= 0) {
      throw new IllegalArgumentException("The scale of the shape must be positive!");
    }
    this.fromWidth = fromWidth;
    this.fromHeight = fromHeight;
    this.toWidth = toWidth;
    this.toHeight = toHeight;
  }

  @Override
  public AnimationType getAnimationType() {
    return AnimationType.SCALE;
  }


  @Override
  public Shape shapeTweening(double time) {
    if (time > finishTime) {
      time = finishTime;
    }
    double width = fromWidth * ((finishTime - time) / (finishTime - startTime))
        + toWidth * ((time - startTime) / (finishTime - startTime));
    double height = fromHeight * ((finishTime - time) / (finishTime - startTime))
        + toHeight * ((time - startTime) / (finishTime - startTime));
    this.shape.setWidth(width);
    this.shape.setHeight(height);
    return this.shape;
  }


  @Override
  public String getAnimationSvg(double speed) {
    double start = this.startTime / speed;
    double dur = (this.finishTime - this.startTime) / speed;
    String res = "";
    if (this.fromWidth == this.toWidth && this.fromHeight == this.toHeight) {
      return res;
    }
    else if (this.fromWidth == this.toWidth && this.fromHeight != this.toHeight) {
      res = "<animate attributeName=" + this.shape.getShapeSvgHeight()
          + " attributeType=\"XML\" begin=\"" + start + "s\" dur=\""
          + dur + "s\" fill=\"freeze\" from=\"" + this.fromHeight
          + "\" to=\"" + this.toHeight + "\" />\n";
    }
    else if (this.fromWidth != this.toWidth && this.fromHeight == this.toHeight) {
      res = "<animate attributeName=" + this.shape.getShapeSvgWidth()
          + " attributeType=\"XML\" begin=\"" + start + "s\" dur=\""
          + dur + "s\" fill=\"freeze\" from=\"" + this.fromWidth
          + "\" to=\"" + this.toWidth + "\" />\n";
    }
    else {
      res = "<animate attributeName=" + this.shape.getShapeSvgWidth()
          + " attributeType=\"XML\" begin=\"" + start + "s\" dur=\""
          + dur + "s\" fill=\"freeze\" from=\"" + this.fromWidth
          + "\" to=\"" + this.toWidth + "\" />\n"
          + "<animate attributeName=" + this.shape.getShapeSvgHeight()
          + " attributeType=\"XML\" begin=\"" + start + "s\" dur=\""
          + dur + "s\" fill=\"freeze\" from=\"" + this.fromHeight
          + "\" to=\"" + this.toHeight + "\" />\n";
    }
    return res;
  }


  /**
   * Gets and returns the beginning length of width of the shape in the animation.
   * @return the beginning width of the animation
   */
  public double getFromWidth() {
    return this.fromWidth;
  }

  /**
   * Gets and returns the beginning length of height of the shape in the animation.
   * @return the beginning height of the animation
   */
  public double getFromHeight() {
    return this.fromHeight;
  }


  /**
   * Gets and returns the resulting length of width of the shape after the animation.
   * @return the resulting width of the animation
   */
  public double getToWidth() {
    return this.toWidth;
  }

  /**
   * Gets and returns the resulting length of height of the shape after the animation.
   * @return the resulting height of the animation
   */
  public double getToHeight() {
    return this.toHeight;
  }


  /**
   * Returns the string in the format as below:
   * "Shape R scales from Width: 50.0, Height: 100.0"
   * "to Width: 25.0, Height: 100.0 from t=51 to t=70".
   * @return the formatted string
   */
  public String toString() {
    return String.format("Shape %s scales from Width: %.1f, Height: %.1f to Width: %.1f, "
            + "Height: %.1f from t=%.1f to t=%.1f\n",
        this.getName(), this.fromWidth, this.fromHeight, this.toWidth,
        this.toHeight, this.startTime, this.finishTime);

  }


}
