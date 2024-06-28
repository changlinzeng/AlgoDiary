package algo.xxx;

public class GasStation_134 {
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, fuel = 0;
    int start = 0;
    var i = 0;
    // calculate the gas left at each station and if it is negative,
    // it means we could make full trip from the start station to current station
    // then we try to make trip at station i + 1
    while (i < gas.length) {
      total += gas[i] - cost[i];
      fuel += gas[i] - cost[i];
      if (fuel < 0) {
        fuel = 0;
        start = i + 1;
      }
      i++;
    }
    return total < 0 ? -1 : start;
  }

  public static void main(String[] args) {
    System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
  }
}
