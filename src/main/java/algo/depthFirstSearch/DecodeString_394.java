package algo.depthFirstSearch;

import java.util.Stack;

public class DecodeString_394 {
    public static String decodeString(String s) {
        // aa, [a], 2[a], 2[2[a]], 2[a2[b]], 2[2[a]]3[b]
        var len = s.length();
        var visited = new boolean[len];
        return decode(s, 0, visited);
    }

    private static String decode(String s, int start, boolean[] visited) {
        String result = "", str = "", num = "";
        for (var i = start; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            var ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num += ch;
            } else if (ch == '[') {
                var ret = decode(s, i + 1, visited);
                var n = Integer.parseInt(num);
                ret = ret.repeat(n);
                result += ret;
                num = "";
            } else if (ch == ']') {
//                result += str;
                break;
            } else {
                result += ch;
            }
        }

        return result;
    }

    public static String decodeString2(String s) {
        var stack = new Stack<String>();
        var nums = new Stack<Integer>();
        String str = "", num = "";
        for (var c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (!str.isEmpty()) {
                    stack.push(str);
                    str = "";
                }
                num += c;
            } else if (c >= 'a' && c <= 'z') {
                str += c;
            } else if (c == '[') {
                if (!num.isEmpty()) {
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
                stack.push(c + "");
            } else if (c == ']') {
                if (!str.isEmpty()) {
                    stack.push(str);
                    str = "";
                }
                var dstr = "";
                while (!stack.isEmpty()) {
                    var top = stack.pop();
                    if (top.equals("[")) {
                        break;
                    }
                    dstr = top + dstr;
                }
                if (!nums.isEmpty()) {
                    dstr = dstr.repeat(nums.pop());
                }
                stack.push(dstr);
            }
        }
        if (!str.isEmpty()) {
            stack.push(str);
        }

        return stack.stream().reduce("", String::concat);
    }

    public static void main(String[] args) {
        System.out.println(decodeString2("3[a]"));
        System.out.println(decodeString2("3[a]2[bc]"));
        System.out.println(decodeString2("3[a2[c]]"));
        System.out.println(decodeString2("2[abc]3[cd]ef"));
        System.out.println(decodeString2("4[2[jk]e1[f]]"));
//        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
