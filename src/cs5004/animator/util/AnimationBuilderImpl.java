package cs5004.animator.util;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import java.awt.Color;

/**
 * This class implements the AnimationBuilder interface.
 * This class is for generate the content of the file and send it to the model.
 */

public class AnimationBuilderImpl implements AnimationBuilder<AnimationModel> {
  private AnimationModel model;


  /**
   * Initializes the AnimationBuilderImpl with the model.
   * @param model the model of the program
   */
  public AnimationBuilderImpl(AnimationModel model) {
    this.model = model;
  }

  @Override
  public AnimationModel build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
    this.model.setCanvas(new Point2D(x, y), width, height);
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
    if (type.equals("rectangle")) {
      this.model.addShape(new Rectangle(name));
    }
    if (type.equals("ellipse")) {
      this.model.addShape(new Oval(name));
    }
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1, int y1, int w1,
      int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
      int b2) {
    Shape shape = this.model.getShapeName(name);
    if (shape.getTimeAppears() == 0 && shape.getTimeDisappears() == 0) {
      shape.setTimeAppears(t1);
      shape.setPosition(new Point2D(x1, y1));
      shape.setWidth(w1);
      shape.setHeight(h1);
      shape.setColor(new Color(r1, g1, b1));
      shape.setTimeDisappears(t2);
    }

    if (x1 != x2 || y1 != y2) {
      this.model.moveShape(shape, t1, t2, new Point2D(x1, y1), new Point2D(x2, y2));
    }

    if (w1 != w2 || h1 != h2) {
      this.model.rescaleShape(shape, t1, t2, w1, h1, w2, h2);
    }

    if (r1 != r2 || g1 != g2 || b1 != b2) {
      this.model.recolorShape(shape, t1, t2, r1, g1, b1, r2, g2, b2);
    }

    return this;
  }

}
