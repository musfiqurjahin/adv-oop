import java.util.Objects;

class Teacher {
    private final String name;

    public Teacher(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }
}

class Department {
    private final String deptName;
    private final Teacher teacher;

    public Department(String deptName, Teacher teacher) {
        this.deptName = Objects.requireNonNull(deptName);
        this.teacher = Objects.requireNonNull(teacher);
    }

    public void display() {
        System.out.println("Department: " + deptName);
        System.out.println("Teacher: " + teacher.getName());
    }
}

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("John Doe");

        Department department = new Department("CSE (Computer Science and Engineering)", teacher);

        department.display();
    }
}
