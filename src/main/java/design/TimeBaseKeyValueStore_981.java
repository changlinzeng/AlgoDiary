package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TimeBaseKeyValueStore_981 {

    public static class TimeMap {
        private final Map<String, List<TimeValue>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                var values = map.get(key);
                var pos = 0;
                while (values.get(pos).timestamp > timestamp) {
                    pos++;
                }
                values.add(pos, new TimeValue(value, timestamp));
            } else {
                var values = new LinkedList<TimeValue>();
                values.add(0, new TimeValue(value, timestamp));
                map.put(key, values);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            var values = map.get(key);
            for (var i = 0; i < values.size(); i++) {
                var val = values.get(i);
                if (val.timestamp == timestamp) {
                    return val.value;
                }
                if (i == 0 && val.timestamp < timestamp) {
                    return val.value;
                }
                if (i < values.size() - 1 && val.timestamp > timestamp && values.get(i + 1).timestamp < timestamp) {
                    return values.get(i + 1).value;
                }
            }
            return "";
        }
    }

    private record TimeValue (String value, int timestamp) {}
}
