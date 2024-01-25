package algo.binarySearch;

public class SearchA2DMatrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // binary search on first column to determine the row the target is on
        // and then binary search on the row
        int row = matrix.length, col = matrix[0].length;
        int low = 0, high = row - 1;
        int targetRow = 0;
        while (low < high) {
            var mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target) {
                if (mid + 1 <= row - 1 && matrix[mid + 1][0] <= target) {
                    low = mid + 1;
                } else {
                    low = mid;
                    break;
                }
            } else {
                high = mid - 1;
            }
        }
        targetRow = low;

        low = 0;
        high = col - 1;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 8));
        System.out.println(searchMatrix(new int[][]{{1},{3},{5}}, 3));
    }
}
