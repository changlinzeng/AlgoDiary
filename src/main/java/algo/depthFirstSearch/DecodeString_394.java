package algo.depthFirstSearch;

public class DecodeString_394 {
    public static String decodeString(String s) {
        // aa, [a], 2[a], 2[2[a]], 2[a2[b]], 2[2[a]]3[b]
        return decode(s, 0).strVal;
    }

    private static Tuple decode(String s, int start) {
        var num = 0;
        var decoded = "";
        var i = start;
        while (i < s.length()) {
            var c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c >= 'a' && c <= 'z') {
                decoded += c;
            } else if (c == '[') {
                var res = decode(s, i + 1);
                decoded += res.strVal.repeat(num);
                i = res.intVal;
                num = 0;
            } else if (c == ']') {
                break;
            }
            i++;
        }
        return new Tuple(decoded, i);
    }

    private static class Tuple {
        public String strVal;
        public int intVal;
        public Tuple(String strVal, int intVal) {
            this.strVal = strVal;
            this.intVal = intVal;
        }
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("4[2[jk]e1[f]]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
