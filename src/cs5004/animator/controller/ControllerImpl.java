
package cs5004.animator.controller;

import cs5004.animator.view.View;


/**
 * This class implements the Controller interface.
 * It represents the controller of the whole program.
 */

public class ControllerImpl implements Controller {

  private final View view;

  /**
   * Initializes the ControllerImpl with the inputs of model and view.
   * @param view  the view of the program
   */

  public ControllerImpl(View view) {
    this.view = view;
  }


  @Override
  public void go() {
    if (view.getViewType().equals("visual") || view.getViewType().equals("playback")) {
      view.animationPerform();
    } else if (view.getViewType().equals("text") || view.getViewType().equals("svg")) {
      view.displayText();
    }
  }





}






