package algo.depthFirstSearch;

public class BrokenCalculator_991 {
  public int brokenCalc(int startValue, int target) {
    if (startValue > target) {
      return startValue - target;
    }
    if (startValue == target) {
      return 0;
    }
    if (target % 2 == 0) {
      return 1 + brokenCalc(startValue, target / 2);
    } else {
      return 1 + brokenCalc(startValue, target + 1);
    }
  }
}
