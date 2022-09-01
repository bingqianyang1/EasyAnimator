package cs5004.animator.model;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents the states and updates of a animation program
 * with the shape information and its animations.
 */

public interface AnimationModel {

  /**
   * Adds a new Shape object to the animation.
   * @param shape the new shape to be added in the animation
   * @throws IllegalArgumentException if the added shape already exists.
   */
  void addShape(Shape shape) throws IllegalArgumentException;


  /**
   * Removes the Shape object in the animation.
   * @param shape the shape to be removed
   * @throws IllegalArgumentException if the shape is invalid
   */
  void removeShape(Shape shape) throws IllegalArgumentException;


  /**
   * Move the Shape object from the original position to a new position in the given time interval.
   * @param shape the shape to be moved
   * @param startTime the starting time for the moving operation
   * @param finishTime the finishing time for the moving operation
   * @param fromPos the original position to move from
   * @param toPos the new position to move to
   * @throws IllegalArgumentException if the shape is invalid
   */
  void moveShape(Shape shape, double startTime, double finishTime, Point2D fromPos, Point2D toPos)
      throws IllegalArgumentException;


  /**
   * Rescale the width and height of the shape in the given time interval.
   * @param shape the shape to be rescaled
   * @param startTime the starting time for the rescaling operation
   * @param finishTime the finishing time for the rescaling operation
   * @param fromWidth the original width of the shape
   * @param fromHeight the original height of the shape
   * @param toWidth the new width to be rescaled with
   * @param toHeight the new height to be rescaled with
   * @throws IllegalArgumentException if if the shape is invalid
   */
  void rescaleShape(Shape shape, double startTime, double finishTime,
      double fromWidth, double fromHeight, double toWidth, double toHeight)
      throws IllegalArgumentException;


  /**
   * Recolor the Shape object in the given time interval.
   * @param shape the shape to be recolored
   * @param startTime the starting time for the recoloring operation
   * @param finishTime the finishing time for the recoloring operation
   * @param fromR the original red intensity
   * @param fromG the original green intensity
   * @param fromB the original blue intensity
   * @param toR the new red intensity to be recolored with
   * @param toG the new green intensity to be recolored with
   * @param toB the new blue intensity to be recolored with
   * @throws IllegalArgumentException if the shape is invalid
   */
  void recolorShape(Shape shape, double startTime, double finishTime,
      int fromR, int fromG, int fromB, int toR, int toG, int toB) throws IllegalArgumentException;


  /**
   * Gets and returns a list of Shape objects appear in the animation.
   * @return a list of shapes appear in the animation
   */
  List<Shape> getAllShapes();


  /**
   * Gets and returns a list of Shape objects appear at the given time in the animation.
   * @param tick the given time in the animation
   * @return a list of shapes appear at given time in the animation
   */
  List<Shape> getAllShapesAtTick(int tick);


  /**
   * Gets and returns a map, map the shape name to its all changes in the animation.
   * @return a map to reflect each shape's changes during the whole animation time
   */
  HashMap<String, List<Animation>> getAllAnimations();



  /**
   * Returns the description of the information and animations of all shapes.
   * @return the the description of the whole animation
   */
  String describeAnimation();




  /**
   * Sets the canvas with the position of lower-left corner, width and height.
   * @param pos the position of the min-corner
   * @param width the width of the canvas
   * @param height the height of the canvas
   * @throws IllegalArgumentException if the given width or height is non-positive
   */
  void setCanvas(Point2D pos, int width, int height) throws IllegalArgumentException;


  /**
   * Gets and returns the position of the lower-left corner of the canvas.
   * @return the position of the canvas
   */
  Point2D getCanvasPos();

  /**
   * Gets and returns the length of width of the canvas.
   * @return the width of the canvas
   */
  int getCanvasWidth();

  /**
   * Gets and returns the length of height of the canvas.
   * @return the wdith of the canvas
   */
  int getCanvasHeight();


  /**
   * Gets and returns the shape by its name.
   * @param name the name of the shape
   * @return the shape with the given name
   * @throws IllegalArgumentException if the name doesn't exist
   */
  Shape getShapeName(String name) throws IllegalArgumentException;


  /**
   * Gets and returns the finish time of the last animation.
   * @return the finish time of the animation
   */
  double getFinishTime();


}
