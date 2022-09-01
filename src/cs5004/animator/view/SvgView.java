package cs5004.animator.view;


import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.Shape;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class represent the svg View.
 * It implements the View interface.
 */
public class SvgView implements View {
  private final AnimationModel model;
  private String svg = "";
  private final String outFile;
  private final int speed;

  /**
   * Initializes the svg view with the inputs of animation model, view text,
   * output file, and the speed.
   * @param model the animation model
   * @param outFile the name of output file
   * @param speed the speed of the animation
   */
  public SvgView(AnimationModel model, String outFile, int speed) {
    this.model = model;
    this.outFile = outFile;
    this.speed = speed;
  }


  @Override
  public String getViewType() {
    return "svg";
  }

  @Override
  public void displayText() {
    svg = "<svg width=\"" + model.getCanvasWidth() + "\" height=\"" + model.getCanvasHeight()
        + "\" viewBox=\"" + model.getCanvasPos().getX() + " " + model.getCanvasPos().getY()
        + " " + (model.getCanvasPos().getX() + model.getCanvasWidth()) + " "
        + (model.getCanvasPos().getY() + model.getCanvasHeight())
        + "\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n";

    for (Shape shape: model.getAllShapes()) {
      svg += shape.getShapeSvg();

      for (Animation animation: model.getAllAnimations().get(shape.getName())) {
        svg += animation.getAnimationSvg(speed);
      }
      svg += shape.getShapeSvgEnd();
    }


    svg += "\n</svg>";

    if (this.outFile.equals("") || this.outFile.equals("System.out")) {
      System.out.println(svg);
    }
    else {
      try {
        BufferedWriter output;
        output = new BufferedWriter(new FileWriter(outFile));
        output.write(svg);
        output.close();
      }
      catch (IOException e) {
        System.out.println("Failed to show the view!");
      }
    }
  }



  @Override
  public String getText() {
    return svg;
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

