package algo.xxx;

import java.util.TreeMap;

public class ZigzagConversion_6 {
  public String convert(String s, int numRows) {
    var row = 0;
    var direction = 1;
    var rows = new TreeMap<Integer, String>();
    for (var i = 0; i < s.length(); i++) {
      rows.put(row, rows.getOrDefault(row, "") + s.charAt(i));
      row += direction;
      if (row == numRows - 1 || row == 0)
      {
        direction = -1 * direction;
      }
    }
    return rows.values().stream().reduce("", String::concat);
  }
}
