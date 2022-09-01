package cs5004.animator.model;

/**
 * This interface represents the changes of the shapes
 * as the animation proceeds from start to finish.
 */
public interface Animation {

  /**
   * Gets and returns the shape on the moving shape.
   * @return the shape of the animation
   */
  Shape getShape();

  /**
   * Gets and returns the name of the moving shape.
   * @return the name of the animation
   */
  String getName();



  /**
   * Gets and returns the one of the 3 types of animation.
   * @return the type of animation
   */
  AnimationType getAnimationType();

  /**
   * Gets and returns the starting time of the moving process.
   * @return the starting time of the animation
   */
  double getStartTime();

  /**
   * Gets and returns the finishing time of the moving process.
   * @return the finishing time of the animation
   */
  double getFinishTime();


  /**
   * Returns the shape at the given tick during the animation.
   * @param time the given time during the animation
   * @return the Shape object
   */
  Shape shapeTweening(double time);


  /**
   * Gets and returns the svg text of the animation changes.
   * @param speed the speed of animation per second
   * @return the svg text of the animation
   */
  String getAnimationSvg(double speed);


}
