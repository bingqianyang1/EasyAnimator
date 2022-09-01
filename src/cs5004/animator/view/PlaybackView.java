package cs5004.animator.view;

import cs5004.animator.model.AnimationModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * This class represent the playback view.
 * It implements the View interface.
 * It adds extra functionalities on the Visual View.
 */
public class PlaybackView extends JFrame implements View, ActionListener {

  private final AnimationModel model;
  private final AnimationPanel panel;
  private int tick;
  private int speed;

  private Timer timer;
  private final JCheckBox loop;

  /**
   * Initializes the playback view object with the model and the speed.
   * @param model the model of the animation
   * @param speed the speed of the animation
   */
  public PlaybackView(AnimationModel model, int speed) {
    super("Playback Animation");
    this.model = model;
    this.speed = speed;
    this.setSize(1000, 850);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    this.panel = new AnimationPanel(model);
    this.panel.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(panel, BorderLayout.CENTER);

    //add scroll pane
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setAutoscrolls(true);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(50, 30, 300, 50);
    scrollPane.setBackground(Color.darkGray);
    this.add(scrollPane, BorderLayout.EAST);

    //add playback controls
    JPanel control = new JPanel();
    control.setLayout(new FlowLayout());
    control.setPreferredSize(new Dimension(1000, 50));
    control.setBackground(Color.lightGray);

    JButton play = new JButton("Play");
    JButton restart = new JButton("Restart");
    JButton pause = new JButton("Pause");
    this.loop = new JCheckBox("Loop");
    JButton accelerate = new JButton("Accelerate");
    JButton decelerate = new JButton("Decelerate");

    play.setActionCommand("Play");
    restart.setActionCommand("Restart");
    pause.setActionCommand("Pause");
    loop.setSelected(false);
    accelerate.setActionCommand("Accelerate");
    decelerate.setActionCommand("Decelerate");

    play.addActionListener(this);
    restart.addActionListener(this);
    pause.addActionListener(this);
    loop.addActionListener(this);
    accelerate.addActionListener(this);
    decelerate.addActionListener(this);


    control.add(play);
    control.add(restart);
    control.add(pause);
    control.add(loop);
    control.add(accelerate);
    control.add(decelerate);
    this.add(control, BorderLayout.SOUTH);

    this.pack();
    this.setVisible(true);

  }




  @Override
  public String getViewType() {
    return "playback";
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
    ActionListener actionListener = e -> {
      if (tick < model.getFinishTime()) {
        this.setCurrentTick(tick);
        this.refresh();
        tick++;
      }
      if (loop.isSelected() && tick >= model.getFinishTime()) {
        tick = 0;
      }
    };
    timer = new Timer(1000 / speed, actionListener);
  }



  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Play":
        timer.start();
      case "Restart":
        tick = 0;
        timer.start();
      case "Pause":
        timer.stop();
      case "Accelerate":
        speed *= 1.25;
        timer.setDelay(1000 / speed);
      case "Decelerate":
        speed /= 1.25;
        timer.setDelay(1000 / speed);
      default:
        //nothing

    }

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
