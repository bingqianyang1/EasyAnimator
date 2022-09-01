package cs5004.animator.view;

import cs5004.animator.model.AnimationModel;

/**
 * This class represents the 3 different types of view object.
 * Implement a factory of views, with a single static method that takes in a String name for a
 * view—“text”, “svg”, or “visual”, or "playback",
 * and constructs an instance of the appropriate concrete view.
 */

public class ViewFactory {


  /**
   * Constructs the view according to the view type.
   * @param viewName view type
   * @param model model of the program
   * @param outFile the name of output file
   * @param speed the speed of animation
   * @return the specific view object
   * @throws IllegalArgumentException if the view type is invalid
   */
  public View constructView(String viewName, AnimationModel model,
      String outFile, int speed) throws IllegalArgumentException {
    return switch (viewName) {
      case "text" -> new TextView(model, outFile, speed);
      case "svg" -> new SvgView(model, outFile, speed);
      case "visual" -> new VisualView(model, speed);
      case "playback" -> new PlaybackView(model, speed);
      default -> throw new IllegalArgumentException("Invalid view format!");
    };
  }


}
