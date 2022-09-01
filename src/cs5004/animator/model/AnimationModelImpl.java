package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * This class implements the AnimationModel interface.
 * This class contains information of every shape in the animation
 * with their changes from the start to the end.
 */

public class AnimationModelImpl implements AnimationModel {

  private Point2D position;
  private int width;
  private int height;
  private List<Shape> allShapes;
  private HashMap<String, List<Animation>> allAnimations;

  /**
   * Initializes the AnimationModelImpl.
   * The AnimationModelImpl object has a list to store the information of all shapes,
   * and has a map to connect the shape with all its changes.
   */
  public AnimationModelImpl() {
    this.allShapes = new ArrayList<>();
    this.allAnimations = new HashMap<>();
  }


  @Override
  public void addShape(Shape shape) throws IllegalArgumentException {
    if (this.allAnimations.containsKey(shape.getName())) {
      throw new IllegalArgumentException("This shape already exists!");
    }
    this.allShapes.add(shape);
    this.allAnimations.put(shape.getName(), new ArrayList<>());
  }


  /**
   * Checks if the given shape is null or doesn't exist in the animation.
   * @param shape the shape to be checked
   * @return true if the shape is invalid, otherwise false
   */
  private boolean invalidShape(Shape shape) {
    return shape == null || (!this.allAnimations.containsKey(shape.getName()));
  }


  @Override
  public void removeShape(Shape shape) throws IllegalArgumentException {
    if (this.invalidShape(shape)) {
      throw new IllegalArgumentException("This shape is invalid");
    }
    this.allShapes.remove(shape);
    this.allAnimations.remove(shape.getName());
  }


  @Override
  public void moveShape(Shape shape, double startTime, double finishTime, Point2D fromPos,
      Point2D toPos) throws IllegalArgumentException {
    if (this.invalidShape(shape)) {
      throw new IllegalArgumentException("This shape is invalid");
    }
    Animation moveShape = new ChangePosition(shape, startTime, finishTime, fromPos, toPos);
    this.allAnimations.get(shape.getName()).add(moveShape);
    this.allAnimations.get(shape.getName()).sort(new ComparatorByTime());
  }


  @Override
  public void rescaleShape(Shape shape, double startTime, double finishTime, double fromWidth,
      double fromHeight, double toWidth, double toHeight) throws IllegalArgumentException {
    if (this.invalidShape(shape)) {
      throw new IllegalArgumentException("This shape is invalid");
    }
    Animation rescaleShape = new ChangeScale(shape, startTime, finishTime,
        fromWidth, fromHeight, toWidth, toHeight);
    this.allAnimations.get(shape.getName()).add(rescaleShape);
    this.allAnimations.get(shape.getName()).sort(new ComparatorByTime());
  }


  @Override
  public void recolorShape(Shape shape, double startTime, double finishTime, int fromR, int fromG,
      int fromB, int toR, int toG, int toB) throws IllegalArgumentException {
    if (this.invalidShape(shape)) {
      throw new IllegalArgumentException("This shape is invalid");
    }
    Animation recolorShape = new ChangeColor(shape, startTime, finishTime, fromR, fromG, fromB,
        toR, toG, toB);
    this.allAnimations.get(shape.getName()).add(recolorShape);
    this.allAnimations.get(shape.getName()).sort(new ComparatorByTime());
  }

  @Override
  public List<Shape> getAllShapes() {
    return this.allShapes;
  }

  @Override
  public List<Shape> getAllShapesAtTick(int tick) {
    List<Shape> shapesAtTime = new ArrayList<>();
    for (Shape shape: this.allShapes) {
      for (Animation animation: this.allAnimations.get(shape.getName())) {
        if (tick >= shape.getTimeAppears() && tick <= shape.getTimeDisappears()) {
          shapesAtTime.add(animation.shapeTweening(tick));
        }
      }
    }
    return shapesAtTime;
  }

  @Override
  public HashMap<String, List<Animation>> getAllAnimations() {
    return this.allAnimations;
  }


  @Override
  public String describeAnimation() {
    StringBuilder res = new StringBuilder("Shapes:\n");
    for (Shape shape: allShapes) {
      res.append(shape.toString());
    }

    for (Shape shape : allShapes) {
      for (Animation animation: allAnimations.get(shape.getName())) {
        res.append(animation.toString());
      }
    }
    return res.toString();
  }


  @Override
  public void setCanvas(Point2D pos, int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The dimensions of canvas must be positive");
    }
    this.position = pos;
    this.width = width;
    this.height = height;
  }

  @Override
  public Point2D getCanvasPos() {
    return this.position;
  }

  @Override
  public int getCanvasWidth() {
    return this.width;
  }

  @Override
  public int getCanvasHeight() {
    return this.height;
  }

  @Override
  public Shape getShapeName(String name) throws IllegalArgumentException {
    for (Shape shape: allShapes) {
      if (shape.getName().equals(name)) {
        return shape;
      }
    }
    throw new IllegalArgumentException("The name doesn't exist!");
  }


  @Override
  public double getFinishTime() {
    ArrayList finishTime = new ArrayList();
    for (Shape shape : allShapes) {
      finishTime.add(allAnimations.get(shape).get(-1).getFinishTime());
    }
    return (double) Collections.max(finishTime);
  }

}
