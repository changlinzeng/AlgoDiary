package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InvalidTransactions_1169 {
    public static List<String> invalidTransactions(String[] transactions) {
        var trans = Arrays.stream(transactions).map( t -> {
            var fields = t.split(",");
            return new Transaction(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), fields[3]);
        }).sorted((a, b) -> {
            if (a.name.equals(b.name)) {
                return a.time - b.time;
            }
            return a.name.compareTo(b.name);
        }).toList();

        var added = new boolean[trans.size()];
        var invalid = new ArrayList<Transaction>();
        for (var i = 0; i < trans.size(); i++) {
            var current = trans.get(i);
            for (var j = i; j < trans.size() && trans.get(j).name.equals(trans.get(i).name); j++) {
                var tr = trans.get(j);
                if (tr.amount > 1000 && !added[j]) {
                    invalid.add(tr);
                    added[j] = true;
                }
                if (tr.time - current.time <= 60 && !tr.location.equals(current.location)) {
                    if (!added[i]) {
                        invalid.add(current);
                        added[i] = true;
                    }
                    if (!added[j]) {
                        invalid.add(tr);
                        added[j] = true;
                    }
                }
            }
        }
        return invalid.stream().map(t -> t.name + "," + t.time + "," + t.amount + "," + t.location).toList();
    }

    private record Transaction(String name, int time, int amount, String location) {
        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + location;
        }
    }

    public static void main(String[] args) {
        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}).forEach(System.out::println);
        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"}).forEach(System.out::println);
        invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}).forEach(System.out::println);
        invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"}).forEach(System.out::println);
        invalidTransactions(new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}).forEach(System.out::println);
        invalidTransactions(new String[]{"bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"}).forEach(System.out::println);
    }
}
