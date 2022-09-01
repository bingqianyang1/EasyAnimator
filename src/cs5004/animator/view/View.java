package cs5004.animator.view;


/**
 * This interface represents the view.
 */

public interface View {

  /**
   * Gets and returns the type of view (text, svg, visual, playback).
   * @return the view type
   */
  String getViewType();


  /**
   * Display the content of the view.
   * @throws UnsupportedOperationException if the view type does not support this
   */
  void displayText();



  /**
   * Gets and returns the text from the view.
   * @return the text content from the view.
   * @throws UnsupportedOperationException if the view type does not support this
   */
  String getText();


  /**
   * Gets the states of all shapes on the given tick.
   * @param tick a time unit, describes as number of ticks per second
   */
  void setCurrentTick(int tick);


  /**
   * This method is for starting the animation.
   * @throws UnsupportedOperationException if the view type does not support this
   */
  void animationPerform();


  /**
   * This method is to refresh the paint and reload the view of animation.
   * @throws UnsupportedOperationException if the view type does not support this
   */
  void refresh();








}
