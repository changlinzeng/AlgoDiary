package data.stack;

import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms_726 {
  public static String countOfAtoms(String formula) {
    var len = formula.length();
    String atom = "", num = "";
    int factor = 1;
    var factors = new Stack<Integer>();
    var count = new TreeMap<String, Integer>();

    for (var i = len - 1; i >= 0; i--) {
      var c = formula.charAt(i);
      if (c >= '0' && c <= '9') {
        num = c + num;
      } else if (c >= 'a' && c <= 'z') {
        atom = c + atom;
      } else if (c >= 'A' && c <= 'Z') {
        // add atom
        atom = c + atom;
        count.put(atom, count.getOrDefault(atom, 0) +
                factor * Integer.parseInt(num.isEmpty() ? "1" : num));
        atom = "";
        num = "";
      } else {
        if (c == ')') {
          if (!num.isEmpty()) {
            factors.push(Integer.parseInt(num));
            factor *= Integer.parseInt(num);
            num = "";
          }
        } else if (c == '(') {
          if (!factors.isEmpty()) {
            var f = factors.pop();
            factor = factor / f;
          }
        }
      }
    }

    var result = "";
    for (var entry : count.entrySet()) {
      result += entry.getKey();
      if (entry.getValue() > 1) {
        result += entry.getValue();
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(countOfAtoms("H2O"));
    System.out.println(countOfAtoms("Mg(HO)2"));
    System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    System.out.println(countOfAtoms("((N)2(Li)2)2"));
    System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
  }
}