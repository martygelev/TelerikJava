import java.util.*;

 class EmployeeImportance {
    public static void main(String[] args) {
        List<Employee> input = new ArrayList<>();
        input.add(new Employee(1, 5, new int[]{2, 3}));
        input.add(new Employee(2, 3, new int[]{}));
        input.add(new Employee(3, 3, new int[]{}));

        int importanceSum = Solution.getImportance(input, 1);
        System.out.println(importanceSum);
    }

    static class Solution {
        public static int getImportance(List<Employee> employees, int id) {
            int importanceSum = 0;

            Map<Integer, Employee> map = new HashMap<>();
            for (Employee employee : employees) {
                map.put(employee.id, employee);
            }

            Queue<Employee> queue = new ArrayDeque<>();

            Employee employee1 = map.get(id);
            queue.add(employee1);

            while (!queue.isEmpty()) {
                Employee currEmployee = queue.poll();
                importanceSum += currEmployee.importance;

                for (Integer subordinate : currEmployee.subordinates) {
                    queue.add(map.get(subordinate));
                }
            }

            return importanceSum;
        }

    }

    static class Employee {
        int id;
        int importance;
        List<Integer> subordinates;

        Employee(int id, int importance, int[] subords) {
            this.id = id;
            this.importance = importance;
            subordinates = new ArrayList();

            for (int subord : subords) {
                subordinates.add(subord);
            }
        }
    }
}