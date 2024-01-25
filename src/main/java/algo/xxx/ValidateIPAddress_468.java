package algo.xxx;

import java.util.List;

public class ValidateIPAddress_468 {
  public static String validIPAddress(String queryIP) {
    if (queryIP.isEmpty()) {
      return "Neither";
    }
    if (queryIP.contains(".") && validateIPv4(queryIP)) {
      return "IPv4";
    }
    if (queryIP.contains(":") && validateIPv6(queryIP)) {
      return "IPv6";
    }
    return "Neither";
  }

  private static boolean validateIPv4(String ip) {
    var count = 0;
    for (var c : ip.toCharArray()) {
      if (c == '.') {
        count++;
      }
    }
    if (count != 3) {
      return false;
    }
    var segments = ip.split("\\.");
    if (segments.length != 4) {
      return false;
    }
    for (var s : segments) {
      if (s.length() > 3 || s.isEmpty()) {
        return false;
      }
      if (s.length() > 1 && (s.charAt(0) == '0')) {
        return false;
      }
      int sum = 0, mult = 1;
      for (var i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) < '0' || s.charAt(i) > '9') {
          return false;
        }
        sum += mult * (s.charAt(i) - '0');
        mult *= 10;
      }
      if (sum > 255) {
        return false;
      }
    }
    return true;
  }

  private static boolean validateIPv6(String ip) {
    var count = 0;
    for (var c : ip.toCharArray()) {
      if (c == ':') {
        count++;
      }
    }
    if (count != 7) {
      return false;
    }
    var segments = ip.split(":");
    if (segments.length != 8) {
      return false;
    }
    var validChars = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F');
    for (var s : segments) {
      if (s.isEmpty() || s.length() > 4) {
        return false;
      }
      for (var i = 0; i < s.length(); i++) {
        if (!validChars.contains(s.charAt(i))) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(validIPAddress("127.0.0.1"));
    System.out.println(validIPAddress("172.16.254.1"));
    System.out.println(validIPAddress("127.00.0.1"));
    System.out.println(validIPAddress("127..0.1"));
    System.out.println(validIPAddress("127.0.0.1."));
  }
}
