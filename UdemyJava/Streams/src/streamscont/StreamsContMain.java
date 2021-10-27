package streamscont;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsContMain {
    public static void main(String[] args) {
        var hr = new Department("Human Resources");
        hr.addEmployee(new Employee("Jane Deer", 25));
        hr.addEmployee(new Employee("Jack Hill", 40));
        hr.addEmployee(new Employee("Snow White", 22));

        var accounting = new Department("Accounting");
        accounting.addEmployee(new Employee("John Doe", 30));

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // print employees in all departments (flatmap wants a function that returns a stream, and returns a flat stream of all the streams)
        // it is called flatmap because it can be used to "flatten" nested lists, such as department list (with employees on each department)
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        // collect: terminal operation: collects all objects to a result (list or set)
        // example: listing age+1 (korean age) of all HR employees in order
        System.out.println("---------------------");
        List<Integer> sortedKoreanAgeEmployees = hr.getEmployees()
                .stream()
                .map(Employee::getAge)
                .map(i -> i + 1)
                .sorted()
                .collect(Collectors.toList()); // terminal operation: outputs an array list (default)

//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) // terminal operation: if you want to specify the collection returned
        // in this non-default way, you need to pass a supplier, an accumulator and a combiner (in this order)

        sortedKoreanAgeEmployees.forEach(System.out::println);

        // collectors can also be used to group by data, returning a map with key-value age-listofemployees
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));

        // reduce - same as clojure
        // example: get the youngest employee across all departments, from the department object
        // the lambda inside reduce is similar to the reduction function in clojure
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> (e1.getAge() < e2.getAge() ? e1 : e2))
                .ifPresent(System.out::println); // prints Snow White, which is the youngest employee

    }
}
