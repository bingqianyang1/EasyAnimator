import static org.junit.Assert.assertEquals;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.View;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the svgView.
 */
public class SvgViewTest {

  private AnimationModel model;
  private AnimationBuilder<AnimationModel> builder;

  @Before
  public void setUp() {
    this.model = new AnimationModelImpl();
    this.builder = new AnimationBuilderImpl(model);
  }

  /**
   * Test the text content of svg view.
   * @throws IOException if the input file in invalid.
   */
  @Test
  public void testSvgText1() throws IOException {
    FileReader readFile = new FileReader("testInput/smalldemo.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new SvgView(model, "System.out", 2);
    view.displayText();
    String expected = "<svg width=\"360\" height=\"360\" viewBox=\"200.0 70.0 560.0 430.0\" "
        + "xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n"
        + "<rect id=\"R\" x=\"200.0\" y =\"200.0\" width=\"50.0\" height=\"100.0\" fill=\""
        + "rgb(255,0,0)\" >\n"
        + "<animate attributeName=\"x\" attributeType=\"XML\" begin=\"5.0s\" dur=\"20.0s\" "
        + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"XML\" begin=\"5.0s\" dur=\"20.0s\" "
        + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
        + "<animate attributeName=width attributeType=\"XML\" begin=\"25.5s\" dur=\"9.5s\" "
        + "fill=\"freeze\" from=\"50.0\" to=\"25.0\" />\n"
        + "<animate attributeName=\"x\" attributeType=\"XML\" begin=\"35.0s\" dur=\"15.0s\" "
        + "fill=\"freeze\" from=\"300.0\" to=\"200.0\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"XML\" begin=\"35.0s\" dur=\"15.0s\" "
        + "fill=\"freeze\" from=\"300.0\" to=\"200.0\" />\n"
        + "</rect><ellipse id=\"C\" cx=\"440.0\" cy =\"70.0\" rx=\"60.0\" ry=\"30.0\" fill=\""
        + "rgb(0,0,255)\" >\n"
        + "<animate attributeName=\"cx\" attributeType=\"XML\" begin=\"10.0s\" dur=\"15.0s\" "
        + "fill=\"freeze\" from=\"440.0\" to=\"440.0\" />\n"
        + "<animate attributeName=\"cy\" attributeType=\"XML\" begin=\"10.0s\" dur=\"15.0s\" "
        + "fill=\"freeze\" from=\"70.0\" to=\"250.0\" />\n"
        + "<animate attributeName=\"cx\" attributeType=\"XML\" begin=\"25.0s\" dur=\"10.0s\" "
        + "fill=\"freeze\" from=\"440.0\" to=\"440.0\" />\n"
        + "<animate attributeName=\"cy\" attributeType=\"XML\" begin=\"25.0s\" dur=\"10.0s\" "
        + "fill=\"freeze\" from=\"250.0\" to=\"370.0\" />\n"
        + "<animate attributeType=\"XML\" begin=\"25.0s\" dur=\"10.0s\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"XML\" begin=\"35.0s\" dur=\"5.0s\" attributeName=\"fill\" "
        + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>";
    assertEquals(expected, view.getText());
  }

  /**
   * Test the display of svg view in a file.
   * @throws IOException if the input file is invalid.
   */
  @Test
  public void testSvgText2() throws IOException {
    FileReader readFile = new FileReader("testInput/big-bang-big-crunch.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new SvgView(model, "testOutput/testSvg1.svg", 20);
    view.displayText();
    assertEquals("svg", view.getViewType());
  }

  /**
   * Test the display of svg view in a file.
   * @throws IOException if the input file is invalid.
   */
  @Test
  public void testSvgText3() throws IOException {
    FileReader readFile = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new SvgView(model, "testOutput/testSvg2.svg", 20);
    view.displayText();
    assertEquals("svg", view.getViewType());

  }



  /**
   * Test the display of svg view in a file.
   * @throws IOException if the input file is invalid.
   */
  @Test
  public void testSvgText4() throws IOException {
    FileReader readFile = new FileReader("testInput/hanoi.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new SvgView(model, "testOutput/testSvg3.svg", 35);
    view.displayText();
    assertEquals("svg", view.getViewType());

  }


  /**
   * Test invalid input file.
   * @throws IOException if the input file is invalid.
   */
  @Test
  public void testSvgText5() throws IOException {
    try {
      FileReader readFile = new FileReader("testInput/abc.txt");
      model = AnimationReader.parseFile(readFile, builder);
      View view = new SvgView(model, "testOutput/testSvg4.svg", 30);
      view.displayText();
      assertEquals("svg", view.getViewType());
    }
    catch (Exception e) {
      System.out.println("Exception!");
    }
  }

}