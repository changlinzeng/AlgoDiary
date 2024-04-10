package algo.twoPointers;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
  public static int numRescueBoats(int[] people, int limit) {
    int boats = 0;
    int len = people.length;
    Arrays.sort(people);

    int start = 0, end = len - 1;
    while (start <= end) {
      if (start == end) {
        boats++;
        break;
      }
      if (people[start] + people[end] <= limit) {
        boats++;
        start++;
        end--;
      } else {
        boats++;
        end--;
      }
    }

    return boats;
  }

  public static void main(String[] args) {
    System.out.println(numRescueBoats(new int[]{1,2}, 3));
    System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
    System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    System.out.println(numRescueBoats(new int[]{5,1,4,2}, 6));
    System.out.println(numRescueBoats(new int[]{3,2,3,2,2}, 6));
  }
}
