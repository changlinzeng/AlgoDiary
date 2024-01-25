package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InvalidTransactions_1169 {
    public static List<String> invalidTransactions(String[] transactions) {
        var transMap = new HashMap<String, List<Transaction>>();
        var trans = Arrays.stream(transactions).map(t -> {
            var attrs = t.split(",");
            return new Transaction(attrs[0], Integer.parseInt(attrs[1]), Integer.parseInt(attrs[2]), attrs[3]);
        }).sorted((t1, t2) -> {
            if (t1.name.equals(t2.name)) {
                if (t1.time == t2.time) {
                    return t1.location.compareTo(t2.location);
                }
                return t1.time - t2.time;
            }
            return t1.name.compareTo(t2.name);
        }).toList();
        for (var t : trans) {
            if (transMap.containsKey(t.name)) {
                transMap.get(t.name).add(t);
            } else {
                var list = new ArrayList<Transaction>();
                list.add(t);
                transMap.put(t.name, list);
            }
        }

        var invalid = new ArrayList<String>();
        transMap.forEach((name, tr) -> {
            var counted = new boolean[tr.size()];
            for (var i = 0; i < tr.size(); i++) {
                if (tr.get(i).amount > 1000 && !counted[i]) {
                    invalid.add(tr.get(i).toString());
                    counted[i] = true;
                }
                for (var j = i + 1; j < tr.size(); j++) {
                    if (tr.get(j).amount > 1000 && !counted[j]) {
                        counted[j] = true;
                        invalid.add(tr.get(j).toString());
                    }
                    if (tr.get(j).time - tr.get(i).time <= 60 && !tr.get(j).location.equals(tr.get(i).location)) {
                        if (!counted[i]) {
                            counted[i] = true;
                            invalid.add(tr.get(i).toString());
                        }
                        if (!counted[j]) {
                            counted[j] = true;
                            invalid.add(tr.get(j).toString());
                        }
                    }
                }
            }
        });

        return invalid;
    }

    private record Transaction(String name, int time, int amount, String location) {
        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + location;
        }
    }

    public static void main(String[] args) {
//        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}).forEach(System.out::println);
//        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"}).forEach(System.out::println);
//        invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}).forEach(System.out::println);
//        invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"}).forEach(System.out::println);
//        invalidTransactions(new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}).forEach(System.out::println);
        invalidTransactions(new String[]{"bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"}).forEach(System.out::println);
    }
}
