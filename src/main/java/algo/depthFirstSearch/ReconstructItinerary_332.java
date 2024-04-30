package algo.depthFirstSearch;

import java.util.*;

public class ReconstructItinerary_332 {
  public static List<String> findItinerary(List<List<String>> tickets) {
    var adjMap = new HashMap<String, Queue<String>>();
    tickets.forEach(ticket -> {
      adjMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
      adjMap.get(ticket.get(0)).offer(ticket.get(1));
    });

    var itinerary = new ArrayList<String>();
    dfs(adjMap, "JFK", itinerary);
    return itinerary.reversed();
  }

  private static void dfs(Map<String, Queue<String>> adjMap, String airport, List<String> itinerary) {
    if (adjMap.containsKey(airport)) {
      var airports = adjMap.get(airport);
      while (!airports.isEmpty()) {
        dfs(adjMap, airports.poll(), itinerary);
      }
    }
    itinerary.add(airport);
  }

  public static void main(String[] args) {
    System.out.println(findItinerary(List.of(List.of("MUC","LHR"), List.of("JFK","MUC"), List.of("SFO","SJC"), List.of("LHR","SFO"))));
    System.out.println(findItinerary(List.of(List.of("JFK","SFO"), List.of("JFK","ATL"), List.of("SFO","ATL"), List.of("ATL","JFK"), List.of("ATL","SFO"))));
    System.out.println(findItinerary(List.of(List.of("JFK","KUL"), List.of("JFK","NRT"), List.of("NRT","JFK"))));
  }
}
