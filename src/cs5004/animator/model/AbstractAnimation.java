package cs5004.animator.model;

/**
 * This abstract class represents the animations of shapes.
 * It contains the common implementations for rectangle and oval.
 * It implements the Animation interface.
 */

public abstract class AbstractAnimation implements Animation {

  protected Shape shape;
  protected double startTime;
  protected double finishTime;

  /**
   * Initializes the AbstractAnimation with inputs of shape, name,
   * moving starting time and moving finishing time.
   * @param shape the shape of the animation
   * @param startTime the starting time of the animation
   * @param finishTime the finishing time of the animation
   * @throws IllegalArgumentException if the shape, or the time of the animation is invalid
   */
  public AbstractAnimation(Shape shape, double startTime, double finishTime)
      throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("Invalid shape! ");
    }
    if (startTime < 0 || finishTime < 0 || startTime > finishTime) {
      throw new IllegalArgumentException("Invalid moving time!");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.finishTime = finishTime;
  }


  @Override
  public Shape getShape() {
    return this.shape;
  }

  @Override
  public String getName() {
    return this.shape.getName();
  }


  @Override
  public double getStartTime() {
    return this.startTime;
  }

  @Override
  public double getFinishTime() {
    return this.finishTime;
  }
}
