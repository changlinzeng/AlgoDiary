package algo.binarySearch;

public class SearchA2DMatrix_II_240 {
  public static boolean searchMatrix(int[][] matrix, int target) {
    // binary search for each row. Complexity is nlog(n)
    int low, high, mid;
    for (var row : matrix) {
      low = 0;
      high = row.length - 1;
      while (low <= high) {
        mid = low + (high - low) / 2;
        if (row[mid] == target) {
          return true;
        } else if (row[mid] > target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(searchMatrix(new int[][]{
            {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}
    }, 20));
  }
}
