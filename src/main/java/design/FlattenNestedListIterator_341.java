package design;

import java.util.ArrayList;
import java.util.List;

public class FlattenNestedListIterator_341 {

    private static class NestedIterator {
        private final List<Integer> flattenlist;
        private int cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.cur = -1;
            flattenlist = new ArrayList<>();
            flatten(nestedList, flattenlist);
        }

        public Integer next() {
            this.cur++;
            if (this.cur >= flattenlist.size()) {
                return null;
            }
            return flattenlist.get(this.cur);
        }

        public boolean hasNext() {
            return this.cur < flattenlist.size() - 1;
        }

        private void flatten(List<NestedInteger> nestedList, List<Integer> flattenlist) {
            for (var e : nestedList) {
                if (e.isInteger()) {
                    flattenlist.add(e.getInteger());
                } else {
                    flatten(e.getList(), flattenlist);
                }
            }
        }
    }

    private static class NestedInteger {
        private final Integer value;

        private final List<NestedInteger> list;

        public NestedInteger(Integer value, List<NestedInteger> list) {
            this.value = value;
            this.list = list;
        }

        public boolean isInteger() {
            return value != null;
        }

        public Integer getInteger() {
            return value;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static void main(String[] args) {
        var e1 = new NestedInteger(1, null);
        var e2 = new NestedInteger(2, null);
        var list1 = List.of(e1, e2);
        var e3 = new NestedInteger(null, list1);
        var e4 = new NestedInteger(3, null);
        var e6 = List.of(e3, e4);

        var iter = new NestedIterator(e6);
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.next());
    }
}
