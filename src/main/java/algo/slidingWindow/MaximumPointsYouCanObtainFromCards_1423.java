package algo.slidingWindow;

public class MaximumPointsYouCanObtainFromCards_1423 {
  public static int maxScore(int[] cardPoints, int k) {
    var len = cardPoints.length;
    var sums = new int[len + 1];
    var sum = 0;
    for (var i = 0; i < len; i++) {
      sum += cardPoints[i];
      sums[i + 1] = sum;
    }

    int minPoints = Integer.MAX_VALUE;
    for (var i = len - k; i <= len; i++) {
      minPoints = Math.min(minPoints, sums[i] - sums[i - (len - k)]);
    }

    return sums[len] - minPoints;
  }

  public static void main(String[] args) {
    System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    System.out.println(maxScore(new int[]{2,2,2}, 2));
    System.out.println(maxScore(new int[]{96,90,41,82,39,74,64,50,30}, 8));
  }
}
