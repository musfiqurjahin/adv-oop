import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// Bank class
class Bank {
    private String bankName;
    private final Set<Employee> employees;

    public Bank(String bankName) {
        setBankName(bankName);
        this.employees = new LinkedHashSet<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (bankName == null || bankName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Bank name cannot be empty."
            );
        }
        this.bankName = bankName.trim();
    }

    // Add an employee
    public boolean addEmployee(Employee employee) {
        return employees.add(
            Objects.requireNonNull(employee, "Employee cannot be null.")
        );
    }

    // Remove an employee
    public boolean removeEmployee(Employee employee) {
        return employees.remove(employee);
    }

    // Return a read-only employee set
    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    // Display bank information
    public void displayEmployees() {
        System.out.println("\nBank: " + bankName);
        System.out.println("Total Employees: " + employees.size());

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("- " + employee.getEmployeeName());
        }
    }
}

// Employee class
class Employee {
    private final String name;

    public Employee(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Employee name cannot be empty."
            );
        }
        this.name = name.trim();
    }

    public String getEmployeeName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Employees with the same name are treated as equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase(java.util.Locale.ROOT).hashCode();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ridhi");
        Employee emp2 = new Employee("Vijay");
        Employee emp3 = new Employee("Ridhi");

        Bank bank = new Bank("ICICI");

        bank.addEmployee(emp1);
        bank.addEmployee(emp2);
        bank.addEmployee(emp3);

        bank.displayEmployees();

        bank.removeEmployee(emp2);

        System.out.println("\nAfter removing Vijay:");
        bank.displayEmployees();
    }
}
