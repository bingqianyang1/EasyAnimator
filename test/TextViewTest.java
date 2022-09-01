import static org.junit.Assert.assertEquals;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the View.
 */

public class TextViewTest {
  private AnimationModel model;
  private AnimationBuilder<AnimationModel> builder;

  @Before
  public void setUp() {
    this.model = new AnimationModelImpl();
    this.builder = new AnimationBuilderImpl(model);
  }

  /**
   * Test the textView object if the output is "System.out".
   * @throws IOException if the file cannot be read
   */
  @Test
  public void testViewText1() throws IOException {
    FileReader readFile = new FileReader("testInput/smalldemo.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new TextView(model, "System.out", 2);
    view.displayText();
    String expected = "Displaying text view at the speed of 2 ticks per second:\n"
        + "\n"
        + "Shapes:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=10.0\n"
        + "\n"
        + "Name: C\n"
        + "Type: oval\n"
        + "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=20.0\n"
        + "\n"
        + "Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10.0 to t=50.0\n"
        + "Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 "
        + "from t=51.0 to t=70.0\n"
        + "Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70.0 to t=100.0\n"
        + "Shape C moves from (440.0,70.0) to (440.0,250.0) from t=20.0 to t=50.0\n"
        + "Shape C moves from (440.0,250.0) to (440.0,370.0) from t=50.0 to t=70.0\n"
        + "Shape C changes color from (0,0,255) to (0,170,85) from t=50.0 to t=70.0\n"
        + "Shape C changes color from (0,170,85) to (0,255,0) from t=70.0 to t=80.0\n";
    assertEquals(expected, view.getText());
  }

  /**
   * Test the textView object if the output is a file.
   * @throws IOException if the file cannot be read
   */
  @Test
  public void testViewText2() throws IOException {
    FileReader readFile = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new TextView(model, "testOutput/testText.txt", 50);
    view.displayText();
    assertEquals("text", view.getViewType());
  }


  /**
   * Test the textView object if the output is a file.
   * @throws IOException if the file cannot be read
   */
  @Test
  public void testViewText3() throws IOException {
    FileReader readFile = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new TextView(model, "", 50);
    view.displayText();
    assertEquals("text", view.getViewType());
  }

  /**
   * Test invalid input file.
   * @throws IOException if the input file is invalid.
   */
  @Test
  public void testSvgText4() throws IOException {
    try {
      FileReader readFile = new FileReader("testInput/abc.txt");
      model = AnimationReader.parseFile(readFile, builder);
      View view = new SvgView(model, "testOutput/testText2.txt", 30);
      view.displayText();
      assertEquals("text", view.getViewType());
    }
    catch (Exception e) {
      System.out.println("Exception!");
    }
  }

}

