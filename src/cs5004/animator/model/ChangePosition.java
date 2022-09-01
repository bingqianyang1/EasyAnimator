package cs5004.animator.model;

/**
 * This class represents the action of changing position of the shape in the animation.
 * It extends the AbstractAnimation class.
 */

public class ChangePosition extends AbstractAnimation {
  private final Point2D fromPos;
  private final Point2D toPos;

  /**
   * Initializes the ChangePosition class with the inputs of shape, moving starting time,
   * moving finishing time, moving departure, and moving destination.
   * @param shape      the shape of the animation
   * @param startTime  the starting time of the animation
   * @param finishTime the finishing time of the animation
   * @param fromPos the starting position of the animation
   * @param toPos the destination position of the animation
   * @throws IllegalArgumentException if the shape, or the time of the animation is invalid
   */
  public ChangePosition(Shape shape, double startTime, double finishTime,
      Point2D fromPos, Point2D toPos)
      throws IllegalArgumentException {
    super(shape, startTime, finishTime);
    this.fromPos = fromPos;
    this.toPos = toPos;
  }

  @Override
  public AnimationType getAnimationType() {
    return AnimationType.MOVE;
  }


  @Override
  public Shape shapeTweening(double time) {
    if (time > finishTime) {
      time = finishTime;
    }
    double xPos = fromPos.getX() * ((finishTime - time) / (finishTime - startTime))
        + toPos.getX() * ((time - startTime) / (finishTime - startTime));
    double yPos = fromPos.getY() * ((finishTime - time) / (finishTime - startTime))
        + toPos.getY() * ((time - startTime) / (finishTime - startTime));
    this.shape.setPosition(new Point2D(xPos, yPos));
    return this.shape;
  }



  @Override
  public String getAnimationSvg(double speed) {
    double start = this.startTime / speed;
    double dur = (this.finishTime - this.startTime) / speed;

    return "<animate attributeName=\"" + this.shape.getShapeSvgX()
        + "\" attributeType=\"XML\" begin=\"" + start + "s\" dur=\"" + dur
        + "s\" fill=\"freeze\" from=\"" + this.fromPos.getX()  + "\" to=\"" + this.toPos.getX()
        + "\" />\n"
        + "<animate attributeName=\"" + this.shape.getShapeSvgY()
        + "\" attributeType=\"XML\" begin=\"" + start + "s\" dur=\"" + dur
        + "s\" fill=\"freeze\" from=\"" + this.fromPos.getY() + "\" to=\"" + this.toPos.getY()
        + "\" />\n";
  }

  /**
   * Gets and returns the starting position of the moving shape in Point2D.
   * @return the starting position of the animation
   */
  public Point2D getFromPos() {
    return this.fromPos;
  }


  /**
   * Gets and returns the ending position of the moving shape in Point2D.
   * @return the ending position of the animation
   */
  public Point2D getToPos() {
    return this.toPos;
  }

  /**
   * Returns the string in the format as below:
   * "Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50".
   * @return the formatted string
   */
  public String toString() {
    return "Shape " + this.getName() + " moves from " + this.fromPos.toString() + " to "
        + this.toPos.toString() + " from t=" + this.startTime + " to t=" + this.finishTime + "\n";
  }




}
