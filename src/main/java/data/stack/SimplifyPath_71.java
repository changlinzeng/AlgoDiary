package data.stack;

import java.util.Stack;

public class SimplifyPath_71 {
  public static String simplifyPath(String path) {
    var elements = path.split("/");
    var stack = new Stack<String>();

    for (String e : elements) {
      if (!"".equals(e) && !".".equals(e)) {
        if (e.equals("..") && !stack.isEmpty()) {
          stack.pop();
        }
        if (!"..".equals(e)) {
          stack.push(e);
        }
      }
    }

    var canonical = "";
    while (!stack.isEmpty()) {
      canonical += "/" + stack.remove(0);
    }
    if ("".equals(canonical)) {
      canonical = "/";
    }

    return canonical;
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
