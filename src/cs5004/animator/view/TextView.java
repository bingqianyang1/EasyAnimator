package cs5004.animator.view;

import cs5004.animator.model.AnimationModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the text view of the animation. It describes both
 * the information of all shapes and the animation of each shape.
 */

public class TextView implements View {

  private final AnimationModel model;
  private String text = "";
  private final String outFile;
  private final int speed;


  /**
   * Initializes the text view with the inputs of animation model, view text,
   * output file, and the speed.
   * @param model the animation model
   * @param outFile the name of output file
   * @param speed the speed of the animation
   */
  public TextView(AnimationModel model, String outFile, int speed) {
    this.model = model;
    this.outFile = outFile;
    this.speed = speed;
  }

  @Override
  public String getViewType() {
    return "text";
  }




  @Override
  public String getText() {
    return text;
  }


  @Override
  public void displayText() {
    text = "Displaying text view at the speed of " + speed + " ticks per second:\n\n";
    text += this.model.describeAnimation();
    if (this.outFile.equals("") || this.outFile.equals("System.out")) {
      System.out.println(text);
    } else {
      try {
        BufferedWriter output;
        output = new BufferedWriter(new FileWriter(outFile));
        output.write(text);
        output.close();
      } catch (IOException e) {
        System.out.println("Failed to show the view!");
      }
    }
  }


  @Override
  public void animationPerform() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Unsupported view!");
  }

  @Override
  public void refresh() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Unsupported view!");
  }


  @Override
  public void setCurrentTick(int tick) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Unsupported view!");
  }








}
