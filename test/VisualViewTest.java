import static org.junit.Assert.assertEquals;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class VisualViewTest {
  private AnimationModel model;
  private AnimationBuilder<AnimationModel> builder;

  @Before
  public void setUp() {
    this.model = new AnimationModelImpl();
    this.builder = new AnimationBuilderImpl(model);
  }


  /**
   * Test the visualView.
   * @throws IOException if the file cannot be read
   */
  @Test
  public void testViewVisual() throws IOException {
    FileReader readFile = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new VisualView(model,  2);
    view.animationPerform();
    assertEquals("visual", view.getViewType());
  }



  /**
   * Test the playbackView.
   * @throws IOException if the file cannot be read
   */
  @Test
  public void testPlayback() throws IOException {
    FileReader readFile = new FileReader("testInput/buildings.txt");
    model = AnimationReader.parseFile(readFile, builder);
    View view = new PlaybackView(model,  2);
    view.animationPerform();
    assertEquals("playback", view.getViewType());
  }

}