package algo.binarySearch;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix_378 {
  public static int kthSmallest(int[][] matrix, int k) {
    int row = matrix.length;
    int column = matrix[0].length;
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (pq.size() < k) {
          pq.offer(matrix[i][j]);
        } else if (pq.peek() > matrix[i][j]) {
          pq.poll();
          pq.offer(matrix[i][j]);
        } else {
          break;
        }
      }
    }

    return pq.peek();
  }

  public static void main(String[] args) {
    System.out.println(kthSmallest(new int[][]{
            {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
    }, 2));
  }
}
