
import static org.junit.Assert.assertEquals;


import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the controller.
 */


public class ControllerTest {

  private AnimationModel model;
  AnimationBuilderImpl builder;

  @Before
  public void setUp() {
    model = new AnimationModelImpl();
    builder = new AnimationBuilderImpl(model);
  }

  /**
   * Tests the controller for the text view.
   */

  @Test
  public void testText() throws IOException {
    Readable input = new FileReader("testInput/smalldemo.txt");
    model = AnimationReader.parseFile(input, builder);
    View view = new TextView(model, "testOutput/testTextContr.txt", 50);
    Controller controller = new ControllerImpl(view);
    controller.go();
    assertEquals(view.getViewType(), "text");

  }


  /**
   * Tests the controller for the svg view.
   */

  @Test
  public void testSvg() throws IOException {
    Readable input = new FileReader("testInput/toh-8.txt");
    model = AnimationReader.parseFile(input, builder);
    View view = new SvgView(model, "testOutput/testSvgContr.svg", 55);
    Controller controller = new ControllerImpl(view);
    controller.go();
    assertEquals(view.getViewType(), "svg");
  }


  /**
   * Tests the controller for the visual view.
   */

  @Test
  public void testVisual() throws IOException {
    Readable input = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(input, builder);
    View view = new VisualView(model, 45);
    Controller controller = new ControllerImpl(view);
    controller.go();
    assertEquals(view.getViewType(), "visual");
  }


  /**
   * Tests the controller for the playback view.
   */

  @Test
  public void testPlayback() throws IOException {
    Readable input = new FileReader("testInput/toh-5.txt");
    model = AnimationReader.parseFile(input, builder);
    View view = new PlaybackView(model, 45);
    Controller controller = new ControllerImpl(view);
    controller.go();
    assertEquals(view.getViewType(), "playback");
  }


}


