package cs5004.animator.view;

import cs5004.animator.model.AnimationModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * This class represents the visual view of the animation.
 * It implements the View interface.
 */

public class VisualView extends JFrame implements View {
  private final AnimationModel model;
  private final AnimationPanel panel;
  private int tick = 0;
  private final int speed;


  /**
   * Initializes the visual view with model and speed.
   * Initializes the display of view such as set layout, set panel, set scrollPane.
   * @param model the model of animation
   * @param speed the speed of the animation
   */
  public VisualView(AnimationModel model, int speed) {
    super("Easy Animation");
    this.model = model;
    this.speed = speed;

    this.setLocation(200, 200);
    this.setSize(1000, 800);
    this.setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panel = new AnimationPanel(model);
    this.panel.setPreferredSize(new Dimension(800, 600));
    this.add(panel, BorderLayout.CENTER);

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setAutoscrolls(true);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(50, 30, 300, 50);
    this.add(scrollPane, BorderLayout.EAST);

    this.pack();
    this.setVisible(true);
  }



  @Override
  public String getViewType() {
    return "visual";
  }

  @Override
  public void refresh() {
    panel.repaint();
  }

  @Override
  public void setCurrentTick(int tick) {
    model.getAllShapesAtTick(tick);
  }


  public void animationPerform() {
    ActionListener a = e -> {
      if (tick < model.getFinishTime()) {
        this.setCurrentTick(tick);
        this.refresh();
        tick++;
      }
    };
    Timer timer = new Timer(1000 / speed, a);
    timer.start();

  }


  @Override
  public void displayText() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Unsupported view!");
  }

  @Override
  public String getText() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Unsupported view!");
  }




}
