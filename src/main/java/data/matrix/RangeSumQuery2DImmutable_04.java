package data.matrix;

public class RangeSumQuery2DImmutable_04 {
  static class NumMatrix {

    private final int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      this.prefixSum = new int[rows][cols];
      this.prefixSum[0][0] = matrix[0][0];

      for (var i = 1; i < rows; i++) {
        this.prefixSum[i][0] = matrix[i][0] + this.prefixSum[i - 1][0];
      }
      for (var j = 1; j < cols; j++) {
        this.prefixSum[0][j] = matrix[0][j] + this.prefixSum[0][j - 1];
      }
      for (var i = 1; i < rows; i++) {
        for (var j = 1; j < cols; j++) {
          this.prefixSum[i][j] = matrix[i][j] + this.prefixSum[i][j - 1] + this.prefixSum[i - 1][j] - this.prefixSum[i - 1][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      if (row1 == 0 && col1 == 0) {
        return this.prefixSum[row2][col2];
      }
      if (row1 == 0) {
        return this.prefixSum[row2][col2] - this.prefixSum[row2][col1 - 1];
      }
      if (col1 == 0) {
        return this.prefixSum[row2][col2] - this.prefixSum[row1 - 1][col2];
      }
      return this.prefixSum[row2][col2] - this.prefixSum[row1 - 1][col2] - this.prefixSum[row2][col1 - 1] + this.prefixSum[row1 - 1][col1 - 1];
    }
  }

  public static void main(String[] args) {
    var rangeSum = new NumMatrix(new int[][]{{-4,-5}});
    System.out.println(rangeSum.sumRegion(0,1,0,1));
  }
}
