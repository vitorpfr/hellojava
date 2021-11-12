package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

// summary: the java.util.function package have interfaces that do not have any meaning by themselves
// they are just a way to create lambdas (in other words, instantiate objects that implement those anonymous interfaces)
// in this way, we can create objects that act as functions
// those lambdas can be used to write functional code, using those objects

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30));
        employees.add(new Employee("Tim Buchalka", 21));
        employees.add(new Employee("Jack Hill", 40));
        employees.add(new Employee("Snow White", 22));
        employees.add(new Employee("Red RidingHood", 35));
        employees.add(new Employee("Prince Charming", 31));

        // bad way - methods are not flexivel
//        printEmployeesOver30(employees);
//        printEmployeesUnder30(employees);

        // better way - with a flexible method
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees under 30", employee -> employee.getAge() < 30);

        // it is not mandatory to pass a lambda; it could be also an anonymous class/object that implements the Predicate interface
        printEmployeesByAge(employees, "Employees under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        // there are type-specific predicates
        IntPredicate isGreaterThan15 = i -> i > 15;
        System.out.println(isGreaterThan15.test(10)); // should return false
        int a = 20;
        System.out.println(isGreaterThan15.test(a + 5)); // should return true

        // it is possible to combine predicates using .and / .or
        IntPredicate isLessThan100 = i -> i < 100;
        System.out.println(isGreaterThan15.and(isLessThan100).test(70)); // true
        System.out.println(isGreaterThan15.and(isLessThan100).test(104)); // false
        System.out.println(isGreaterThan15.and(isLessThan100).test(12)); // false
        System.out.println(isGreaterThan15.or(isLessThan100).test(12)); // true

        // using supplier - it returns a value whenever .get() is called, based on a logic (determined by a lambda or anonymous class implementation)
        Random random = new Random();
        // old way
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(1000));
//        }
        // new way
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        // printing last name of employees in the list
        employees.forEach(employee -> {
            String name = employee.getName();
            String lastName = name.substring(name.indexOf(' ') + 1);
            System.out.println("Last name is " + lastName);
        });
        // ideally, there would be a method getLastName() in the Employee class
        // however, if you don't want to do it for some reason, you can also extract it with the Function interface
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        // with this approach, we can write a generic method that accepts a function and applies it
        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        // chaining functions using .andThen, and applying them to an object
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName); // it is like (comp first-name to-upper) in Clojure
        // could also be firstName.compose(upperCase)
        System.out.println(chainedFunction.apply(employees.get(0)));

        // if we want to build a function that accepts two arguments, we can use BiFunction interface
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        Employee someEmployee = employees.get(0);
        String upperName = upperCase.apply(someEmployee);
        System.out.println(concatAge.apply(upperName, someEmployee));

        // there are also interfaces that receive and return the same type of argumennt: UnaryOperaor
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        // consumers are operators that do not return anything, and are intended for side-effects only
        // therefore, chaining consumers is only intended to execute multiple side-effects at once
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, world!");

    }

    public static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    public static void printEmployeesOver30(List<Employee> employees) {
        System.out.println("Employees over 30");
        System.out.println("-----------------");
        // with enhanced for loop
//        for (Employee e: employees) {
//            if (e.getAge() > 30) {
//                System.out.println(e.getName());
//            }
//        }

        // with foreach
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });
    }

    public static void printEmployeesUnder30(List<Employee> employees) {
        System.out.println("Employees with 30 or under");
        System.out.println("-----------------");
        employees.forEach(employee -> {
            if (employee.getAge() <= 30) {
                System.out.println(employee.getName());
            }
        });
    }

    // doing a single method that uses a Predicate parameter as a condition
    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("-----------------");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

    public static void printEmployeeListUsingLambda(List<Employee> employees) {
        // new way to do the for loop through a list and do something with the elements
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}
