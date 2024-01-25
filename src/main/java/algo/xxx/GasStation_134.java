package algo.xxx;

public class GasStation_134 {
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    var len = gas.length;
    for (int i = 0; i < len; i++) {
      if (gas[i] < cost[i]) {
        continue;
      }
      int steps = len, j = i, fuel = gas[j];
      while (steps > 0) {
        if (fuel < cost[j]) {
          break;
        }
        fuel = fuel - cost[j] + gas[(j + 1) % len];
        j = (j + 1) % len;
        steps--;
      }
      if (steps == 0) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
  }
}
