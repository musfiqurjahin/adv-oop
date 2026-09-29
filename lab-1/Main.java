class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    void calculateBonus() {
        System.out.println("Bonus: " + salary * 0.10);
    }

    void performanceReport() {
        System.out.println(name + " has a satisfactory performance.");
    }

    void manageProject() {
        System.out.println(name + " is managing a project.");
    }

    void displayInfo() {
        System.out.println("Name      : " + name);
        System.out.println("Address   : " + address);
        System.out.println("Salary    : " + salary);
        System.out.println("Job Title : " + jobTitle);
    }
}

class Manager extends Employee {
    Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    void calculateBonus() {
        System.out.println("Bonus: " + salary * 0.20);
    }

    @Override
    void performanceReport() {
        System.out.println(name + " is performing managerial responsibilities.");
    }

    @Override
    void manageProject() {
        System.out.println(name + " is managing a company project.");
    }
}

class Developer extends Employee {
    Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    void calculateBonus() {
        System.out.println("Bonus: " + salary * 0.15);
    }

    @Override
    void performanceReport() {
        System.out.println(name + " is developing and maintaining software.");
    }

    @Override
    void manageProject() {
        System.out.println(name + " is managing a software development project.");
    }
}

class Programmer extends Employee {
    Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    void calculateBonus() {
        System.out.println("Bonus: " + salary * 0.10);
    }

    @Override
    void performanceReport() {
        System.out.println(name + " is writing and testing computer programs.");
    }

    @Override
    void manageProject() {
        System.out.println(name + " is working on a programming project.");
    }
}

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Arif Hasan", "Dhaka", 150000);
        Developer developer = new Developer("Nabil Ahmed", "Chittagong", 125000);
        Programmer programmer = new Programmer("Tanvir Rahman", "Sylhet", 110000);

        System.out.println("========== MANAGER ==========");
        manager.displayInfo();
        manager.calculateBonus();
        manager.performanceReport();
        manager.manageProject();

        System.out.println("\n========== DEVELOPER ==========");
        developer.displayInfo();
        developer.calculateBonus();
        developer.performanceReport();
        developer.manageProject();

        System.out.println("\n========== PROGRAMMER ==========");
        programmer.displayInfo();
        programmer.calculateBonus();
        programmer.performanceReport();
        programmer.manageProject();
    }
}
