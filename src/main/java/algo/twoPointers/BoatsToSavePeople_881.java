package algo.twoPointers;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
  public static int numRescueBoats(int[] people, int limit) {
    int boats = 0;
    int len = people.length;
    Arrays.sort(people);

    int start = 0, end = len - 1;
    while (start < len && end >= 0 && start <= end) {
      var sum = 0;
      var numPeople = 0;
      while (numPeople < 2 && end >= 0 && sum + people[end] <= limit) {
        numPeople++;
        sum += people[end];
        end--;
      }
      while (numPeople < 2 && start < end && sum + people[start] <= limit) {
        numPeople++;
        sum += people[start];
        start++;
      }

      boats++;
      sum = 0;
      numPeople = 0;
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
