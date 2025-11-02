package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    String name;
    int salary;
    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}

public class StreamWithCustomObject {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Steve", 6000)
        );
        List<String> highEarning  = employees.stream()
                .filter(e -> e.salary > 5000)
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println("Employee with earning more that 5000 :");
        System.out.print(highEarning);
    }

}
