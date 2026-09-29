class Employee {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    void calculateSalary() {
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(double salary) {
        super(salary);
    }

    @Override
    void calculateSalary() {
        double totalSalary = salary + (salary * 0.10);
        System.out.println("Full-Time Employee Salary: " + totalSalary);
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(double salary) {
        super(salary);
    }

    @Override
    void calculateSalary() {
        double totalSalary = salary + (salary * 0.05);
        System.out.println("Part-Time Employee Salary: " + totalSalary);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee employee;

        employee = new FullTimeEmployee(125000);
        employee.calculateSalary();

        employee = new PartTimeEmployee(100000);
        employee.calculateSalary();
    }
}