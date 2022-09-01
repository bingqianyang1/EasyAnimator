import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Color;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeType;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for Shape. It tests all the methods in the Shape interface.
 */

public class ShapeTest {
  private Shape rect1;
  private Shape rect2;
  private Shape oval1;
  private Shape oval2;

  @Before
  public void setUp() {
    rect1 = new Rectangle("Rectangle", new Point2D(200.0, 200.0),
        50.0, 100.0, new Color(0, 0, 1), 1, 100);
    rect2 = new Rectangle("Square", new Point2D(0, 0),
        35, 35, new Color(204, 2, 255), 8, 13);
    oval1 = new Oval("Oval", new Point2D(500, 100),
        60, 30, new Color(1, 1, 20), 6, 100);
    oval2 = new Oval("Circle", new Point2D(-8, -200),
        20, 20, new Color(33, 200, 175), 66, 77);
  }

  /**
   * Test valid constructor for rect1.
   */
  @Test
  public void testShape() {
    assertEquals("Rectangle", rect1.getName());
    assertEquals(200, rect1.getPosition().getX(), 0.0001);
    assertEquals(200, rect1.getPosition().getY(), 0.0001);
    assertEquals(50, rect1.getWidth(), 0.0001);
    assertEquals(100, rect1.getHeight(), 0.0001);
    assertEquals(0, rect1.getColor().getRed());
    assertEquals(0, rect1.getColor().getGreen());
    assertEquals(1, rect1.getColor().getBlue());
    assertEquals(1, rect1.getTimeAppears(), 0.0001);
    assertEquals(100, rect1.getTimeDisappears(), 0.0001);
  }


  /**
   * Test invalid constructor with empty name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidName() {
    new Rectangle("", new Point2D(200.0, 200.0), 50.0, 100.0,
        new Color(0, 0, 1), 1, 100);
  }

  /**
   * Test invalid constructor with non-positive width.
   */
  @Test
  public void testInvalidWidth() {
    for (int i = -100; i < 1; i++) {
      try {
        new Rectangle("rec", new Point2D(200.0, 200.0), i, 100.0,
            new Color(0, 0, 1), 1, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor with non-positive height.
   */
  @Test
  public void testInvalidHeight() {
    for (int i = -100; i < 1; i++) {
      try {
        new Rectangle("rec", new Point2D(200.0, 200.0), 100, i,
            new Color(0, 0, 1), 1, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor with invalid time appears.
   */
  @Test
  public void testInvalidTimeAppears() {
    for (int i = -100; i < 0; i++) {
      try {
        new Rectangle("square", new Point2D(200.0, 200.0), 100, 100,
            new Color(0, 0, 1), i, 100);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Test invalid constructor with invalid time disappears.
   */
  @Test
  public void testInvalidTimeDisappears() {
    for (int i = -100; i < 0; i++) {
      try {
        new Rectangle("square", new Point2D(200.0, 200.0), 100, 100,
            new Color(0, 0, 1), 1, i);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }


  /**
   * Test invalid constructor with invalid appearance interval.
   */
  @Test
  public void testInvalidAppearTime() {
    for (int i = 1; i < 100; i++) {
      try {
        new Rectangle("square", new Point2D(200.0, 200.0), 100, 100,
            new Color(0, 0, 1), i + 1, i);
        fail("An exception should been thrown!");
      }
      catch (Exception e) {
        System.out.println("Message String = " + e.getMessage());
      }
    }
  }

  /**
   * Tests getName, getPosition, getWidth, getHeight, getColor, getTimeAppears,
   * getTimeDisappears, getShape, toString methods for rect1.
   */
  @Test
  public void testGetRect1() {
    assertEquals("Rectangle", rect1.getName());
    assertEquals("(200.0,200.0)", rect1.getPosition().toString());
    assertEquals(50, rect1.getWidth(), 0.0001);
    assertEquals(100, rect1.getHeight(), 0.0001);
    assertEquals(0, rect1.getColor().getRed());
    assertEquals(0, rect1.getColor().getGreen());
    assertEquals(1, rect1.getColor().getBlue());
    assertEquals(1, rect1.getTimeAppears(), 0.0001);
    assertEquals(100, rect1.getTimeDisappears(), 0.0001);
    assertEquals(ShapeType.RECTANGLE, rect1.getShape());

    String res = "Name: Rectangle\nType: rectangle\nMin corner: (200.0,200.0), Width: "
        + "50.0, Height: 100.0, Color: (0,0,1)\nAppears at t=1.0\nDisappears at t=100.0\n\n";
    assertEquals(res, rect1.toString());
  }

  /**
   * Tests getName, getPosition, getWidth, getHeight, getColor, getTimeAppears,
   * getTimeDisappears, getShape, toString methods for rect2.
   */
  @Test
  public void testGetRect2() {
    assertEquals("Square", rect2.getName());
    assertEquals("(0.0,0.0)", rect2.getPosition().toString());
    assertEquals(35, rect2.getWidth(), 0.0001);
    assertEquals(35, rect2.getHeight(), 0.0001);
    assertEquals(204, rect2.getColor().getRed());
    assertEquals(2, rect2.getColor().getGreen());
    assertEquals(255, rect2.getColor().getBlue());
    assertEquals(8, rect2.getTimeAppears(), 0.0001);
    assertEquals(13, rect2.getTimeDisappears(), 0.0001);
    assertEquals(ShapeType.RECTANGLE, rect2.getShape());

    String res = "Name: Square\nType: rectangle\nMin corner: (0.0,0.0), Width: "
        + "35.0, Height: 35.0, Color: (204,2,255)\nAppears at t=8.0\nDisappears at t=13.0\n\n";
    assertEquals(res, rect2.toString());
  }

  /**
   * Tests getName, getPosition, getWidth, getHeight, getColor, getTimeAppears,
   * getTimeDisappears, getShape, toString methods for oval1.
   */
  @Test
  public void testGetOval1() {
    assertEquals("Oval", oval1.getName());
    assertEquals("(500.0,100.0)", oval1.getPosition().toString());
    assertEquals(60, oval1.getWidth(), 0.0001);
    assertEquals(30, oval1.getHeight(), 0.0001);
    assertEquals(1, oval1.getColor().getRed());
    assertEquals(1, oval1.getColor().getGreen());
    assertEquals(20, oval1.getColor().getBlue());
    assertEquals(6, oval1.getTimeAppears(), 0.0001);
    assertEquals(100, oval1.getTimeDisappears(), 0.0001);
    assertEquals(ShapeType.OVAL, oval1.getShape());

    String res = "Name: Oval\nType: oval\nCenter: (500.0,100.0), X radius: "
        + "60.0, Y radius: 30.0, Color: (1,1,20)\nAppears at t=6.0\nDisappears at t=100.0\n\n";
    assertEquals(res, oval1.toString());
  }

  /**
   * Tests getName, getPosition, getWidth, getHeight, getColor, getTimeAppears,
   * getTimeDisappears, getShape, toString methods for oval2.
   */
  @Test
  public void testGetOval2() {
    assertEquals("Circle", oval2.getName());
    assertEquals("(-8.0,-200.0)", oval2.getPosition().toString());
    assertEquals(20, oval2.getWidth(), 0.0001);
    assertEquals(20, oval2.getHeight(), 0.0001);
    assertEquals(33, oval2.getColor().getRed());
    assertEquals(200, oval2.getColor().getGreen());
    assertEquals(175, oval2.getColor().getBlue());
    assertEquals(66, oval2.getTimeAppears(), 0.0001);
    assertEquals(77, oval2.getTimeDisappears(), 0.0001);
    assertEquals(ShapeType.OVAL, oval2.getShape());

    String res = "Name: Circle\nType: oval\nCenter: (-8.0,-200.0), X radius: "
        + "20.0, Y radius: 20.0, Color: (33,200,175)\nAppears at t=66.0\nDisappears at t=77.0\n\n";
    assertEquals(res, oval2.toString());
  }


  /**
   * Tests setPosition, setWidth, setHeight, setColor, setTimeAppears,
   * setTimeDisappears methods for rect1.
   */
  @Test
  public void testSetRect1() {
    rect1.setPosition(new Point2D(-200, 0));
    rect1.setWidth(66.6);
    rect1.setHeight(100.199);
    rect1.setColor(new Color(1, 1, 2));
    rect1.setTimeAppears(100);
    rect1.setTimeDisappears(101);
    assertEquals("Rectangle", rect1.getName());
    assertEquals("(-200.0,0.0)", rect1.getPosition().toString());
    assertEquals(66.6, rect1.getWidth(), 0.0001);
    assertEquals(100.199, rect1.getHeight(), 0.0001);
    assertEquals(1, rect1.getColor().getRed());
    assertEquals(1, rect1.getColor().getGreen());
    assertEquals(2, rect1.getColor().getBlue());
    assertEquals(100, rect1.getTimeAppears(), 0.0001);
    assertEquals(101, rect1.getTimeDisappears(), 0.0001);
  }

  /**
   * Tests setPosition, setWidth, setHeight, setColor, setTimeAppears,
   * setTimeDisappears methods for rect2.
   */
  @Test
  public void testSetRect2() {
    rect2.setPosition(new Point2D(-1, -1.1));
    rect2.setWidth(5);
    rect2.setHeight(5);
    rect2.setColor(new Color(4, 5, 6));
    rect2.setTimeAppears(0);
    rect2.setTimeDisappears(100);
    assertEquals("Square", rect2.getName());
    assertEquals("(-1.0,-1.1)", rect2.getPosition().toString());
    assertEquals(5, rect2.getWidth(), 0.0001);
    assertEquals(5, rect2.getHeight(), 0.0001);
    assertEquals(4, rect2.getColor().getRed());
    assertEquals(5, rect2.getColor().getGreen());
    assertEquals(6, rect2.getColor().getBlue());
    assertEquals(0, rect2.getTimeAppears(), 0.0001);
    assertEquals(100, rect2.getTimeDisappears(), 0.0001);
  }


  /**
   * Tests setPosition, setWidth, setHeight, setColor, setTimeAppears,
   * setTimeDisappears methods for oval1.
   */
  @Test
  public void testSetOval1() {
    oval1.setPosition(new Point2D(500, 2.139));
    oval1.setWidth(30);
    oval1.setHeight(60);
    oval1.setColor(new Color(0, 0, 1));
    oval1.setTimeAppears(0);
    oval1.setTimeDisappears(55);
    assertEquals("Oval", oval1.getName());
    assertEquals("(500.0,2.1)", oval1.getPosition().toString());
    assertEquals(30, oval1.getWidth(), 0.0001);
    assertEquals(60, oval1.getHeight(), 0.0001);
    assertEquals(0, oval1.getColor().getRed());
    assertEquals(0, oval1.getColor().getGreen());
    assertEquals(1, oval1.getColor().getBlue());
    assertEquals(0, oval1.getTimeAppears(), 0.0001);
    assertEquals(55, oval1.getTimeDisappears(), 0.0001);
  }

  /**
   * Tests setPosition, setWidth, setHeight, setColor, setTimeAppears,
   * setTimeDisappears methods for oval2.
   */
  @Test
  public void testSetOval2() {
    oval2.setPosition(new Point2D(9.999, 8.71));
    oval2.setWidth(800);
    oval2.setHeight(800);
    oval2.setColor(new Color(255, 255, 255));
    oval2.setTimeAppears(77);
    oval2.setTimeDisappears(99);
    assertEquals("Circle", oval2.getName());
    assertEquals("(10.0,8.7)", oval2.getPosition().toString());
    assertEquals(800, oval2.getWidth(), 0.0001);
    assertEquals(800, oval2.getHeight(), 0.0001);
    assertEquals(255, oval2.getColor().getRed());
    assertEquals(255, oval2.getColor().getGreen());
    assertEquals(255, oval2.getColor().getBlue());
    assertEquals(77, oval2.getTimeAppears(), 0.0001);
    assertEquals(99, oval2.getTimeDisappears(), 0.0001);
  }



}