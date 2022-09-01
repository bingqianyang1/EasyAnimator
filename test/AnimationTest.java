import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import java.awt.Color;
import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationType;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.ChangePosition;
import cs5004.animator.model.ChangeScale;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for Animation. It tests all the methods in the Animation interface.
 */
public class AnimationTest {

  private Animation changePos;
  private Animation changeScale;
  private Animation changeColor;

  @Before
  public void setUp() {
    Shape rect1 = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50.0, 100.0, new Color(0, 0, 1), 1, 100);
    changePos = new ChangePosition(rect1, 10, 50,
        new Point2D(200, 200), new Point2D(300, 300));

    Shape rect2 = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50.0, 100.0, new Color(1, 1, 1), 1, 100);
    changeScale = new ChangeScale(rect2, 51, 70,
        50.0, 100, 25.0, 100);

    Shape oval = new Oval("Oval", new Point2D(500, 100),
        60, 30, new Color(1, 1, 20), 6, 100);
    changeColor = new ChangeColor(oval, 50, 80,
        1, 1, 20, 20, 20, 255);
  }

  /**
   * Test constructor for changePos.
   */
  @Test
  public void testChangePos() {
    assertEquals("Rectangle", changePos.getName());
    assertEquals(AnimationType.MOVE, changePos.getAnimationType());
    assertEquals(10, changePos.getStartTime(), 0.0001);
    assertEquals(50, changePos.getFinishTime(), 0.0001);
  }

  /**
   * Test constructor for changeScale.
   */
  @Test
  public void testChangeScale() {
    assertEquals("Rectangle", changeScale.getName());
    assertEquals(AnimationType.SCALE, changeScale.getAnimationType());
    assertEquals(51, changeScale.getStartTime(), 0.0001);
    assertEquals(70, changeScale.getFinishTime(), 0.0001);
  }

  /**
   * Test invalid constructor for ChangeScale with invalid fromWidth.
   */
  @Test
  public void testInvalidFromWidth() {
    Shape rect = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50.0, 100.0, new Color(1, 1, 1), 1, 100);
    for (int i = -100; i < 1; i++) {
      try {
        changeScale = new ChangeScale(rect, 51, 70,
            i, 100, 25, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor for ChangeScale with invalid fromHeight.
   */
  @Test
  public void testInvalidFromHeight() {
    Shape rect = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50, 100.0, new Color(1, 1, 1), 1, 100);
    for (int i = -100; i < 1; i++) {
      try {
        changeScale = new ChangeScale(rect, 51, 70,
            60, i, 25, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor for ChangeScale with invalid toWidth.
   */
  @Test
  public void testInvalidToWidth() {
    Shape rect = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50, 100.0, new Color(1, 1, 1), 1, 100);
    for (int i = -100; i < 1; i++) {
      try {
        changeScale = new ChangeScale(rect, 51, 70,
            50, 100, i, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor for ChangeScale with invalid toHeight.
   */
  @Test
  public void testInvalidToHeight() {
    Shape rect = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50, 100.0, new Color(1, 1, 1), 1, 100);
    for (int i = -100; i < 1; i++) {
      try {
        changeScale = new ChangeScale(rect, 51, 70,
            50, 100, 1, i);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test constructor for ChangeColor.
   */
  @Test
  public void testChangeColor() {
    assertEquals("Oval", changeColor.getName());
    assertEquals(AnimationType.COLOR, changeColor.getAnimationType());
    assertEquals(50, changeColor.getStartTime(), 0.0001);
    assertEquals(80, changeColor.getFinishTime(), 0.0001);
  }


  /**
   * Test invalid constructor for Animation with null Shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidShape() {
    Shape rect1 = null;
    changePos = new ChangePosition(rect1, 10, 50,
        new Point2D(200, 200), new Point2D(300, 300));
  }

  /**
   * Test invalid constructor for Animation with invalid startTime.
   */
  @Test
  public void testInvalidStartTime() {
    Shape oval = new Oval("Oval", new Point2D(500, 100),
        60, 30, new Color(1, 1, 20), 6, 100);
    for (int i = -100; i < 0; i++) {
      try {
        changeScale = new ChangeScale(oval, i, 70,
            50, 100, 25, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor for Animation with invalid finishTime or invalid time interval.
   */
  @Test
  public void testInvalidFinishTime() {
    Shape oval = new Oval("Oval", new Point2D(500, 100),
        60, 30, new Color(1, 1, 20), 6, 100);
    for (int i = -100; i < 0; i++) {
      try {
        changeScale = new ChangeScale(oval, 0, i,
            50, 100, 25, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test toString method for changePos.
   */
  @Test
  public void testToString1() {
    String res = "Shape Rectangle moves from (200.0,200.0) to (300.0,300.0) "
        + "from t=10.0 to t=50.0\n";
    assertEquals(res, changePos.toString());
  }

  /**
   * Test toString method for changeScale.
   */
  @Test
  public void testToString2() {
    String res = "Shape Rectangle scales from Width: 50.0, Height: 100.0 to Width: 25.0, "
        + "Height: 100.0 from t=51.0 to t=70.0\n";
    assertEquals(res, changeScale.toString());
  }

  /**
   * Test toString method for changeColor.
   */
  @Test
  public void testToString3() {
    String res = "Shape Oval changes color from (1,1,20) to (20,20,255) from t=50.0 to t=80.0\n";
    assertEquals(res, changeColor.toString());
  }

  /**
   * Test tweening method for changePos.
   */
  @Test
  public void testTweeningPos() {
    changePos.shapeTweening(20);
    assertEquals(225, changePos.getShape().getPosition().getX(), 0.0001);
    assertEquals(225, changePos.getShape().getPosition().getY(), 0.0001);
  }


  /**
   * Test tweening method for changeScale.
   */
  @Test
  public void testTweeningScale() {
    changeScale.shapeTweening(52);
    assertEquals(48.68, changeScale.getShape().getWidth(), 0.01);
    assertEquals(100.00, changeScale.getShape().getHeight(), 0.01);
  }


  /**
   * Test tweening method for changeColor.
   */
  @Test
  public void testTweeningColor() {
    changeColor.shapeTweening(66);
    assertEquals(11, changeColor.getShape().getColor().getRed(), 0.0001);
    assertEquals(11, changeColor.getShape().getColor().getGreen(), 0.0001);
    assertEquals(145, changeColor.getShape().getColor().getBlue(), 0.0001);
  }


}