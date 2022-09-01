package cs5004.animator.view;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * This class represents the panel for the visual animation.
 */
public class AnimationPanel extends JPanel {

  private final AnimationModel model;

  /**
   * Initializes the AnimationPanel object with model.
   * @param model the animation model
   */
  public AnimationPanel(AnimationModel model) {
    super(true);
    this.model = model;
    this.setBackground(Color.white);
    this.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.setBorder(new LineBorder(Color.BLACK, 2));

  }


  @Override
  public void paintComponent(Graphics g) {
    //Tell the JPanel to prepare its paint capabilities for customized things
    super.paintComponent(g);
    //Create a new graphics context based on the original one
    Graphics2D g2d = (Graphics2D) g;

    for (Shape shape : model.getAllShapes()) {
      g2d.setColor(shape.getColor());
      if (shape.getShape().equals(ShapeType.RECTANGLE)) {
        g2d.fillRect((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getWidth(), (int) shape.getHeight());

      }
      else {
        g2d.fillOval((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getWidth() / 2, (int) shape.getHeight() / 2);
      }
    }
  }


}
