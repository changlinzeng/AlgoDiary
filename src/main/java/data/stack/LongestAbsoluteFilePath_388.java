package data.stack;

import java.util.Stack;

public class LongestAbsoluteFilePath_388 {
  public static int lengthLongestPath(String input) {
    var path = new Stack<String>();
    var folder = "";
    var level = 1;
    var maxFilePath = 0;
    var i = 0;
    var str = input + "\n\t";  // append newline so we can process the last file in the loop
    while (i < str.length()) {
      var c = str.charAt(i);
      if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '.' || c == ' ') {
        folder += c;
        i++;
      } else if (c == '\n') {
        if (path.isEmpty()) {
          path.push(folder);
          folder = "";
          // count file path length, not empty dir
          if (path.peek().contains(".")) {
            var len = -1;
            for (var p : path) {
              len += p.length() + 1;
            }
            maxFilePath = Math.max(maxFilePath, len);
          }
        } else {
          if (level == path.size()) {
            // in the same level
            path.pop();
            path.push(folder);
            folder = "";
          } else if (level > path.size()) {
            // in subfolder
            path.push(folder);
            folder = "";
          } else {
            // go back to parent folder
            while (!path.isEmpty() && path.size() > level) {
              path.pop();
            }
            path.pop();
            path.push(folder);
            folder = "";
          }
          // count file path length, not empty dir
          if (path.peek().contains(".")) {
            var len = -1;
            for (var p : path) {
              len += p.length() + 1;
            }
            maxFilePath = Math.max(maxFilePath, len);
          }
        }
        // find \n. now we count how many tabs \t
        level = 1;
        if (i < str.length() - 1 && str.charAt(i + 1) == '\t') {
          i++;
          while (i < str.length() && str.charAt(i) == '\t') {
            level++;
            i++;
          }
        } else {
          // if there is only \n
          i++;
        }
      }
    }

    return maxFilePath;
  }

  public static void main(String[] args) {
    System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    System.out.println(lengthLongestPath("a"));
    System.out.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    System.out.println(lengthLongestPath("file1.txt"));
    System.out.println(lengthLongestPath("rzzmf\nv\n\tix\n\t\tiklav\n\t\t\ttqse\n\t\t\t\ttppzf\n\t\t\t\t\tzav\n\t\t\t\t\t\tkktei\n\t\t\t\t\t\t\thhmav\n\t\t\t\t\t\t\t\tbzvwf.txt"));
  }
}
