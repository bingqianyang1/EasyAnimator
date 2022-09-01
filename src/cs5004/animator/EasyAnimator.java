
package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is the entry point of this program.
 * It takes command-line arguments as inputs.
 * The argument is in the format of:
 * <-in "name-of-animation-file" -view "type-of-view"
 * -out "where-output-show-go" -speed "integer-ticks-per-second">.
 */

public final class EasyAnimator {

  /**
   * This is the main method of the program.
   * @param args the command-line argument
   * @throws IOException if the input is invalid
   */

  public static void main(String[] args) throws IOException {

    //args = (new String[]{"-in", "buildings.txt", "-view", "visual"});
    //args = (new String[]{"-in", "buildings.txt", "-view", "playback", "-speed", "40"});

    AnimationModel model = new AnimationModelImpl();
    String inFile = "";
    String viewType = "";
    String outFile = "";
    String speed = "";

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        inFile = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-view")) {
        viewType = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-out")) {
        outFile = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-speed")) {
        speed = args[i + 1];
      }
    }



    if (outFile.equals("")) {
      outFile = "System.out";
    }
    if (speed.equals("")) {
      speed = "1";
    }



    if (inFile.equals("") || viewType.equals("")) {
      JOptionPane.showMessageDialog(new JFrame(),
          "The command-line arguments are invalid");
    }



    AnimationBuilder<AnimationModel> builder = new AnimationBuilderImpl(model);
    FileReader readInput = new FileReader("testInput/" + inFile);

    //Constructs the view.
    model = AnimationReader.parseFile(readInput, builder);
    View view = new ViewFactory().constructView(viewType, model, outFile, Integer.parseInt(speed));

    //Constructs the controller.
    Controller controller = new ControllerImpl(view);
    controller.go();
  }
}







