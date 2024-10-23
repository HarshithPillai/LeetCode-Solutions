/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int dfs(Map<Integer, Employee> map, int id, int found, int currId) {
        if(currId == id) found = 1;
        int curr = 0;
        Employee currEmp = map.get(currId);
        if(found == 1) curr += currEmp.importance;
        for(int emp:currEmp.subordinates) {
            curr += dfs(map, id, found, emp);
        }
        return curr;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(Employee emp:employees) {
            map.put(emp.id, emp);
            for(int empid:emp.subordinates) {
                children.add(empid);
            }
        }
        int head = -1;
        for(Employee emp:employees) {
            if(!children.contains(emp.id)) {
                head = emp.id;
                break;
            }
        }
        return dfs(map, id, 0, head);
    }
}