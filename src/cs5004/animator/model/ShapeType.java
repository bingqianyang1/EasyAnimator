package cs5004.animator.model;

/**
 * This enum represents the 2 possible options for the type of shape:
 * rectangle, or oval.
 */

public enum ShapeType {
  RECTANGLE, OVAL;

  /**
   * Returns the type of the shape.
   * @return "rectangle" or "oval" accordingly
   */
  @Override
  public String toString() {
    if (this == RECTANGLE) {
      return "rectangle";
    }
    else {
      return "oval";
    }
  }

}
