import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// summary: lambda is a quick way to instantiate an anonymous class that implements an interface with only one method!
// example: the Runnable interface only has method run()
// traditional way to instantiate a Runnable object is to define Runnable a = new Runnable({@Override run() {doSomething()}}
// with lambda, this would be Runnable a = () -> doSomething();

public class LambdasMain {
    public static void main(String[] args) {
        // option 1 (CodeToRun implements Runnable)
//        new Thread(new CodeToRun()).start();

        // option 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing for the runnable");
            }
        }).start();

        // better option: using lambda expression
        new Thread(() -> System.out.println("Printing from the Runnable using lambda")).start();

        // lambdas have three parts:
            // arguments (in this case empty)
            // arrow token (->)
            // body (code that we want to run, in this case println statement)

        // it works only with interfaces that have only one method (such as Runnable and run()) -> functional interfaces
        // it matches the argument list passed with the body passed

        // lambda with multiple commands in the body
        new Thread(() -> {
            System.out.println("Printing from the runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();

        // applying lambdas to a different code
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        System.out.println("sort list by name and print result, first without using lambdas");
        // here we use the comparator object as a "function" to sort elements (functional interface)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        Employee.printEmployeeList(employees);

        Collections.shuffle(employees);
        System.out.println("now using lambda");
        // argument list: (Employee e1, Employee e2), or simply (e1, e2), because the compiler can infer type from the list
        // arrow token: ->
        // body: e1.getName().compareTo(e2.getName()
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        Employee.printEmployeeList(employees);

        System.out.println("Looking at another example of an interface that handles strings");
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase(); // this is the lambda
        String sillyString = uc.upperAndConcat(employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        System.out.println("another example");
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        // testing better print employee list, using list.forEach (it is kinda like a map)
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void printEmployeeList(List<Employee> employees) {
        // the lambda can use 'employee' even though employee is not final, because it is considered effectively final (when defined in the enhanced for loop)
        for (Employee employee : employees) {
            System.out.println(employee.getName()); // prints employee name in main thread
//            new Thread(() -> System.out.println(employee.getAge())).start(); // prints employee age in a new thread
            System.out.println(employee.getAge());
        }
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    // important: the lambda is not an anonymous class, instead it is a nested block of code (getClass still points to the parent class)
    // however, it has the same "limitation" of anonymous class, that it can only use final variables declared outside it
    // in summary, it is treated like a nested code block
    public String doSomething() {
        int i = 0;
//        i++; // i can't be modified if it is being used inside the lambda (therefore being effectively final

        UpperConcat uc = ((s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        });

//        s1 = "Hello"; // this doesn't work because s1 is local to the lambda

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return uc.upperAndConcat("String 1", "String 2");

//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return (new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }).upperAndConcat("String 1", "String 2");


    }

    public void printValue() {
        int number = 25;
        Runnable r =  () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number); // number prints 25 even though method isn't running anymore (so local variable doesn't exist anymore)
        };

        new Thread(r).start();
    }
}

