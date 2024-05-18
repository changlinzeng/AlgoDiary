package algo.twoPointers;

public class ContainerWithMostWater_11 {
  public static int maxArea(int[] height) {
    int area = 0, maxArea = 0;
    int k = 0, i = 0, j = height.length - 1;

    while (i < j) {
      area = Math.max(height[j], height[i]) * (j - i);
      maxArea = Math.max(maxArea, area);

      if (height[i] <= height[j]) {
        k = i + 1;
        while (k < j && height[k] <= height[i]) {
          k++;
        }
        i = k;
      }

      area = Math.max(height[j], height[i]) * (j - i);
      maxArea = Math.max(maxArea, area);

      if (height[j] < height[i]) {
        k = j - 1;
        while (k > i && height[k] <= height[j]) {
          k--;
        }
        j = k;
      }
    }

    return maxArea;
  }
}
