package algo.depthFirstSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance_690 {
    public static int getImportance(List<Employee> employees, int id) {
        var idMap = new HashMap<Integer, Employee>();
        for (var employee : employees) {
            idMap.put(employee.id, employee);
        }
        var importance = 0;
        for (var employ: employees) {
            if (employ.id == id) {
                importance = importance(employ, id, idMap);
            }
        }

        return importance;
    }

    private static int importance(Employee employee, int id, Map<Integer, Employee> idMap) {
        var sum = 0;
        sum = employee.importance;
        for (var sub : employee.subordinates) {
            sum += importance(idMap.get(sub), id, idMap);
        }
        return sum;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates == null ? List.of() : subordinates;
        }
    };

    public static void main(String[] args) {
        System.out.println(getImportance(List.of(new Employee(1, 5, List.of(2, 3)),
                new Employee(2,3,null),
                new Employee(3,3,null)),
                1));
        System.out.println(getImportance(List.of(new Employee(1, 2, List.of(5)),
                new Employee(5,-3,null)),
                5));
    }
}
