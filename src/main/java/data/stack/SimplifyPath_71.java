package data.stack;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath_71 {
  public static String simplifyPath(String path) {
    var stack = new Stack<String>();
    Arrays.stream(path.split("/")).filter(a -> !a.isBlank()).forEach(p -> {
      switch (p) {
        case ".." -> {
          if (!stack.isEmpty()) {
            stack.pop();
          }
        }
        case "." -> {}
        default -> stack.push(p);
      }
    });

    return "/" + String.join("/", stack);
  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home"));
    System.out.println(simplifyPath("/../"));
    System.out.println(simplifyPath("/home//foo/"));
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath("/a//b////c/d//././.."));
  }
}
