package cs5004.animator.model;

import java.util.Comparator;

/**
 * This class represents the comparator to compare the animations according to their starting time.
 * This class helps us in sorting the animation list of the hashmap in the AnimationModelImpl.
 */

public class ComparatorByTime implements Comparator<Animation> {

  /**
   * Check the start time of 2 Animation obejects.
   * @param o1 Animation object o1
   * @param o2 Animation object o2
   * @return 1 if o1 starts earlier, returns -1 if o2 starts earlier, otherwise return 0.
   */
  @Override
  public int compare(Animation o1, Animation o2) {
    return Double.compare(o1.getStartTime(), o2.getFinishTime());

  }
}
