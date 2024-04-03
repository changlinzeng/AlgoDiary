package algo.depthFirstSearch

class KtEmployeeImportance_690 {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        fun importance(employee: Employee, idMap: Map<Int, Employee>): Int {
            var value = employee.importance
            employee.subordinates.forEach {
                value += importance(idMap[it]!!, idMap)
            }
            return value
        }

        val idMap: MutableMap<Int, Employee> = mutableMapOf()
        employees.filterNotNull().forEach {
            idMap[it.id] = it
        }
        val emp = employees.filter { it != null && it.id == id }.getOrNull(0)
        if (emp != null) {
            return importance(emp, idMap)
        }
        return Int.MIN_VALUE
    }
}

class Employee {
    var id:Int = 0
    var importance:Int = 0
    var subordinates:List<Int> = listOf()
}