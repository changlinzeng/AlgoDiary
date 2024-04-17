package algo.bit;

public class UTF8Validation_393 {
  public static boolean validUtf8(int[] data) {
    var mask1 = 1 << 7;  // 10000000
    var mask2 = 3 << 6;  // 11000000
    var mask3 = 7 << 5;  // 11100000
    var mask4 = 15 << 4; // 11110000
    var mask5 = 31 << 3; // 11111000
    var i = 0;
    while (i < data.length) {
      // determine how many bytes
      var bytes = 0;
      if ((mask1 & data[i]) == 0) {
        bytes = 1;
      }
      if ((mask3 & data[i]) == 3 << 6) {
        bytes = 2;
      }
      if ((mask4 & data[i]) == 7 << 5) {
        bytes = 3;
      }
      if ((mask5 & data[i]) == 15 << 4) {
        bytes = 4;
      }
      if (bytes == 0) {
        return false;
      }
      if (i + bytes > data.length) {
        return false;
      }
      for (var j = 1; j < bytes; j++) {
        if ((data[i + j] & mask2) != 1 << 7) {
          return false;
        }
      }
      i += bytes;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(validUtf8(new int[]{197,130,1}));
    System.out.println(validUtf8(new int[]{235,140,4}));
    System.out.println(validUtf8(new int[]{255}));
  }
}
