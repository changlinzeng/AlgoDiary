package data.matrix;

public class MaximalRectangle_85 {
  public static int maximalRectangle(char[][] matrix) {
    var maxRec = 0;
    for (var i = 0; i < matrix.length; i++) {
      for (var j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          int row = i;
          while (row < matrix.length) {
            if (matrix[row][j] == '0') {
              break;
            }
            var k = j;
            for (; k < matrix[0].length; k++) {
              var canExpand = true;
              for (var m = i; m <= row; m++) {
                if (matrix[m][k] == '0') {
                  canExpand = false;
                  break;
                }
              }
              if (!canExpand) {
                break;
              }
            }
            k--;
            maxRec = Math.max(maxRec, (row - i + 1) * (k - j + 1));
            row++;
            if (maxRec == matrix.length * matrix[0].length) {
              return maxRec;
            }
          }
        }
      }
    }

    return maxRec;
  }

  public static void main(String[] args) {
    System.out.println(maximalRectangle(new char[][]
                    {{'1','0','1','0','0'},
                     {'1','0','1','1','1'},
                     {'1','1','1','1','1'},
                     {'1','0','0','1','0'}}));
    System.out.println(maximalRectangle(new char[][]
            {{'1','1','1','1','1','1','1','1'},
             {'1','1','1','1','1','1','1','0'},
             {'1','1','1','1','1','1','1','0'},
             {'1','1','1','1','1','0','0','0'},
             {'0','1','1','1','1','0','0','0'}}));
  }
}
