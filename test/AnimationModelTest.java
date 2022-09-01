import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.awt.Color;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import org.junit.Before;
import org.junit.Test;


/**
 * This class is the JUnit test for AnimationModel.
 */
public class AnimationModelTest {

  private AnimationModel model;
  private Shape rect;
  private Shape oval;


  @Before
  public void setUp() {
    model = new AnimationModelImpl();
    rect = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50.0, 100.0, new Color(0, 0, 1), 1, 100);
    oval = new Oval("Oval", new Point2D(500, 100),
        60, 30, new Color(1, 1, 20), 6, 100);
  }

  /**
   * Test addShape method for the model.
   */
  @Test
  public void testAddShape() {
    model.addShape(rect);
    model.addShape(oval);
    assertTrue(model.getAllShapes().contains(rect));
    assertTrue(model.getAllAnimations().containsKey("Oval"));
    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n"
        + "\n";
    assertEquals(res, model.describeAnimation());
  }

  /**
   * Test invalid addShape method with repeated shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddShape() {
    model.addShape(rect);
    model.addShape(oval);
    model.addShape(rect);
  }

  /**
   * Test removeShape method.
   */
  @Test
  public void testRemoveShape() {
    model.addShape(rect);
    model.addShape(oval);
    assertTrue(model.getAllAnimations().containsKey("Oval"));
    String res1 = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n\n";
    assertEquals(res1, model.describeAnimation());

    model.removeShape(rect);
    assertFalse(model.getAllShapes().contains(rect));
    String res2 = "Shapes:\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n\n";
    assertEquals(res2, model.describeAnimation());
  }


  /**
   * Test invalid removeShape method with non-existence shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemoveShape1() {
    model.addShape(rect);
    model.removeShape(rect);
    model.removeShape(rect);
  }

  /**
   * Test invalid removeShape method with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemoveShape2() {
    model.addShape(oval);
    model.removeShape(null);
  }


  /**
   * Test moveShape method.
   */
  @Test
  public void testMoveShape() {
    model.addShape(rect);
    model.moveShape(rect, 55, 99, new Point2D(200, 200),
        new Point2D(0, 0));
    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Shape Rectangle moves from (200.0,200.0) to (0.0,0.0) from t=55.0 to t=99.0\n";
    assertEquals(res, model.describeAnimation());
  }

  /**
   * Test invalid moveShape method with non-existence shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveShape() {
    model.addShape(oval);
    model.moveShape(rect, 55, 99, new Point2D(200, 200),
        new Point2D(0, 0));
  }


  /**
   * Test rescaleShape method.
   */
  @Test
  public void testRescaleShape() {
    model.addShape(rect);
    model.rescaleShape(rect, 51, 70,
        50, 100, 25, 50);
    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Shape Rectangle scales from Width: 50.0, Height: 100.0 "
        + "to Width: 25.0, Height: 50.0 from t=51.0 to t=70.0\n";
    assertEquals(res, model.describeAnimation());
  }

  /**
   * Test invalid rescaleShape method with non-existence shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRescaleShape1() {
    model.addShape(oval);
    model.rescaleShape(rect, 51, 70,
        50, 100, 25, 50);
  }

  /**
   * Test recolorShape method.
   */
  @Test
  public void testRecolorShape() {
    model.addShape(oval);
    model.recolorShape(oval, 10, 13, 1, 1, 20,
        255, 255, 255);
    model.recolorShape(oval, 20, 36, 255, 255, 255,
        1, 3, 5);
    String res = "Shapes:\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Shape Oval changes color from (1,1,20) to (255,255,255) from t=10.0 to t=13.0\n"
        + "Shape Oval changes color from (255,255,255) to (1,3,5) from t=20.0 to t=36.0\n";
    assertEquals(res, model.describeAnimation());
  }

  /**
   * Test invalid recolorShape method with non-existence shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecolorShape() {
    model.addShape(oval);
    model.recolorShape(rect, 10, 13, 1, 1, 20,
        255, 255, 255);
  }


  /**
   * Test getAllShapes method.
   */
  @Test
  public void testGetAllShapes() {
    model.addShape(rect);
    assertTrue(model.getAllShapes().contains(rect));
    assertFalse(model.getAllShapes().contains(oval));

    model.addShape(oval);
    assertTrue(model.getAllShapes().contains(oval));
    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n\n";
    assertEquals(res, model.describeAnimation());
  }


  /**
   * Test getAllShapesAtTime method.
   */
  @Test
  public void testGetAllShapesAtTime() {
    model.addShape(rect);
    model.addShape(oval);

    model.recolorShape(rect, 3, 10, 0, 0, 1,
        255, 255, 255);
    model.moveShape(rect, 6, 35, new Point2D(200, 200),
        new Point2D(0, 0));
    model.recolorShape(rect, 14, 34, 255, 255, 255,
        1, 1, 1);
    model.rescaleShape(oval, 10, 23, 60, 30,
        60, 70);
    model.moveShape(oval, 18, 50, new Point2D(50, 100),
        new Point2D(400, 30));

    assertEquals(255, model.getAllShapesAtTick(10).get(0).getColor().getRed());
    assertEquals(0, model.getAllShapesAtTick(35).get(0).getPosition().getX(),
        0.0001);
    assertEquals(30, model.getAllShapesAtTick(10).get(3).getHeight(), 0.0001);
    assertEquals(60, model.getAllShapesAtTick(23).get(3).getWidth(), 0.0001);
    assertEquals(1, model.getAllShapesAtTick(34).get(0).getColor().getRed(),
        0.0001);
    assertEquals(400, model.getAllShapesAtTick(50).get(3).getPosition().getX(),
        0.0001);


    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (0.0,0.0), Width: 50.0, Height: 100.0, Color: (1,1,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (400.0,30.0), X radius: 60.0, Y radius: 70.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Shape Rectangle changes color from (0,0,1) to (255,255,255) from t=3.0 to t=10.0\n"
        + "Shape Rectangle changes color from (255,255,255) to (1,1,1) from t=14.0 to t=34.0\n"
        + "Shape Rectangle moves from (200.0,200.0) to (0.0,0.0) from t=6.0 to t=35.0\n"
        + "Shape Oval moves from (50.0,100.0) to (400.0,30.0) from t=18.0 to t=50.0\n"
        + "Shape Oval scales from Width: 60.0, Height: 30.0 to Width: 60.0, Height: 70.0 "
        + "from t=10.0 to t=23.0\n";
    assertEquals(res, model.describeAnimation());

  }



  /**
   * Test getAllAnimations method.
   */
  @Test
  public void testGetAllAnimations() {
    model.addShape(rect);
    model.addShape(oval);
    model.recolorShape(oval, 10, 13, 1, 1, 20,
        100, 200, 50);
    model.rescaleShape(rect, 11, 24,
        50, 100, 25, 50);
    model.moveShape(oval, 20, 36, new Point2D(500, 100),
        new Point2D(50, 80));
    String res = "{Oval=[Shape Oval changes color from (1,1,20) to (100,200,50) "
        + "from t=10.0 to t=13.0\n"
        + ", Shape Oval moves from (500.0,100.0) to (50.0,80.0) from t=20.0 to t=36.0\n"
        + "], Rectangle=[Shape Rectangle scales from Width: 50.0, Height: 100.0 to "
        + "Width: 25.0, Height: 50.0 from t=11.0 to t=24.0\n"
        + "]}";
    assertEquals(res, model.getAllAnimations().toString());
  }


  /**
   * Tests describeAnimation method.
   */
  @Test
  public void testDescribeAnimation() {
    model.addShape(rect);
    model.addShape(oval);
    model.recolorShape(oval, 10, 13, 1, 1, 20,
        100, 200, 50);
    model.rescaleShape(rect, 11, 24,
        50, 100, 25, 50);
    model.moveShape(oval, 20, 36, new Point2D(500, 100),
        new Point2D(50, 80));
    String res = "Shapes:\n"
        + "Name: Rectangle\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (0,0,1)\n"
        + "Appears at t=1.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Name: Oval\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (1,1,20)\n"
        + "Appears at t=6.0\n"
        + "Disappears at t=100.0\n"
        + "\n"
        + "Shape Rectangle scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: "
        + "50.0 from t=11.0 to t=24.0\n"
        + "Shape Oval changes color from (1,1,20) to (100,200,50) from t=10.0 to t=13.0\n"
        + "Shape Oval moves from (500.0,100.0) to (50.0,80.0) from t=20.0 to t=36.0\n";
    assertEquals(res, model.describeAnimation());
  }


  /**
   * Test setCanvas, getCanvasPos, getCanvasWidth, getCanvasHeight method.
   */
  @Test
  public void testSetCanvas() {
    model.setCanvas(new Point2D(0, 0), 1000, 500);
    assertEquals(0, model.getCanvasPos().getX(), 0.0001);
    assertEquals(0, model.getCanvasPos().getY(), 0.0001);
    assertEquals(1000.0, model.getCanvasWidth(), 0.0001);
    assertEquals(500.0, model.getCanvasHeight(), 0.0001);
  }


  /**
   * Test invalid setCanvas with non-positive width.
   */
  @Test
  public void testInvalidCanvas1() {
    for (int i = -100; i < 1; i++) {
      try {
        model.setCanvas(new Point2D(0, 0), i, 500);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid setCanvas with non-positive height.
   */
  @Test
  public void testInvalidCanvas2() {
    for (int i = -100; i < 1; i++) {
      try {
        model.setCanvas(new Point2D(0, 0), 1000, i);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

}