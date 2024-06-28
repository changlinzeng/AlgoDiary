package data.stack;

import java.util.*;

public class ExclusiveTimeOfFunctions_636 {
  public static int[] exclusiveTime(int n, List<String> logs) {
    var executions = new ArrayList<>(logs.stream().map(l -> {
      var arr = l.split(":");
      return new Log(Integer.parseInt(arr[0]), arr[1].equals("start"), Integer.parseInt(arr[2]));
    }).toList());

    executions.sort(Comparator.comparingInt(e -> e.time));

    var times = new int[n];
    var stack = new Stack<Log>();
    for (var e : executions) {
      if (e.start) {
        stack.push(e);
      } else {
        var log = stack.pop();
        var time = e.time - log.time + 1;
        times[log.id] += time;
        if (!stack.isEmpty()) {
          times[stack.peek().id] -= time;
        }
      }
    }

    return times;
  }

  private record Log(int id, boolean start, int time) {}

  public static void main(String[] args) {
//    var result = exclusiveTime(2, List.of("0:start:0","1:start:2","1:end:5","0:end:6"));
//    var result = exclusiveTime(1, List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
//    var result = exclusiveTime(2, List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"));
//    var result = exclusiveTime(2, List.of("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"));
//    var result = exclusiveTime(1, List.of("0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"));
    var result = exclusiveTime(3, List.of("1:start:0","0:start:2","1:start:3","2:start:4","2:end:4","0:end:6","1:end:7","1:end:8"));
    Arrays.stream(result).asLongStream().forEach(System.out::println);
  }
}
