# Aggregation in Java — Complete Beginner-Friendly Notes

> **Topic:** Object-Oriented Programming (OOP)  
> **Concept:** Aggregation (HAS-A Relationship)  
> **Language:** Java  
> **Level:** Beginner to Intermediate

---

# 1. What is Aggregation?

Aggregation is one of the important concepts of Object-Oriented Programming (OOP).

In Java, **Aggregation is a special type of Association that represents a HAS-A relationship between two independent classes.**

In simple words:

When one class contains a reference to an object of another class, and that object can exist independently without the containing class, it is called Aggregation.

### Simple Example

Think about a University.

- A University has Departments.
- A Department has Teachers.
- But a Teacher can exist independently of a Department.

For example:

- A CSE Department has a Teacher named Rahim.
- If the CSE Department is closed, Rahim can still exist.
- Rahim can even join another Department.

This is called Aggregation.

**Remember:**

Aggregation = HAS-A Relationship + Independent Object Lifecycle.

---

# 2. Understanding HAS-A Relationship

Before understanding Aggregation, you need to understand the HAS-A relationship.

HAS-A means one object contains or uses a reference to another object.

For example:

| Class A | HAS-A | Class B |
|---|---|---|
| Department | HAS-A | Teacher |
| University | HAS-A | Department |
| Library | HAS-A | Book |
| Team | HAS-A | Player |
| Company | HAS-A | Employee |
| Car | HAS-A | Engine |

Example:

A Department HAS-A Teacher.

It means the Department class has a reference variable of type Teacher.

```java
class Teacher {
    String name;
}

class Department {
    Teacher teacher;
}
```

Here:

- `Teacher` is an independent class.
- `Department` contains a reference variable named `teacher`.
- The reference variable points to a Teacher object.

This is the basic structure of Aggregation.

---

# 3. How Does Aggregation Work in Java?

Let's understand the process step by step.

### Step 1: Create the Independent Class

First, create a Teacher class.

```java
class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}
```

Here:

- `Teacher` is a separate class.
- `name` stores the teacher's name.
- The constructor initializes the name.

### Step 2: Create the Containing Class

Now create a Department class.

```java
class Department {
    String deptName;
    Teacher teacher;

    Department(String deptName, Teacher teacher) {
        this.deptName = deptName;
        this.teacher = teacher;
    }
}
```

Notice this line:

```java
Teacher teacher;
```

This is the most important part.

It means the Department class contains a reference to a Teacher object.

Also notice the constructor:

```java
Department(String deptName, Teacher teacher)
```

We are receiving an already-created Teacher object instead of creating a new Teacher inside the Department.

This is an important characteristic of Aggregation.

### Step 3: Create Objects in the Main Class

```java
public class Main {
    public static void main(String[] args) {

        Teacher t = new Teacher("Rahim");

        Department d = new Department("CSE", t);

    }
}
```

Here:

1. First, we create a Teacher object.
2. Then, we create a Department object.
3. We pass the Teacher object to the Department constructor.
4. The Department now has a reference to that Teacher.

### Step 4: Access the Teacher Object

We can access the teacher's name through the Department object.

```java
System.out.println(d.teacher.name);
```

Because the Department contains a reference to the Teacher object.

---

# 4. Complete Java Program

Now let's combine everything into one complete program.

```java
class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    Teacher teacher;

    Department(String deptName, Teacher teacher) {
        this.deptName = deptName;
        this.teacher = teacher;
    }

    void display() {
        System.out.println("Department: " + deptName);
        System.out.println("Teacher: " + teacher.name);
    }
}

public class Main {
    public static void main(String[] args) {

        Teacher t = new Teacher("Rahim");

        Department d = new Department("CSE", t);

        d.display();
    }
}
```

### Output

```text
Department: CSE
Teacher: Rahim
```

### Code Explanation

| Code | Purpose |
|---|---|
| `class Teacher` | Creates the Teacher class |
| `String name` | Stores the teacher's name |
| `Teacher(String name)` | Initializes the Teacher object |
| `class Department` | Creates the Department class |
| `Teacher teacher` | Stores a reference to a Teacher object |
| `Department(String deptName, Teacher teacher)` | Receives an existing Teacher object |
| `this.teacher = teacher` | Assigns the received object reference |
| `d.display()` | Displays department and teacher information |

**Important:** The Teacher object is created independently before being passed to the Department.

---

# 5. Understanding Object References

This is one of the most important parts of Aggregation.

Let's look at this code:

```java
Teacher t = new Teacher("Rahim");

Department d = new Department("CSE", t);
```

What actually happens?

### Step 1: Teacher Object Creation

```java
Teacher t = new Teacher("Rahim");
```

A Teacher object is created in memory.

The variable `t` holds a reference to that object.

### Step 2: Department Object Creation

```java
Department d = new Department("CSE", t);
```

A Department object is created.

The reference to the existing Teacher object is passed to the Department.

Now both `t` and `d.teacher` refer to the same Teacher object.

### Memory Representation

```text
          STACK
       +-----------+
       |     t     |
       +-----------+
             |
             |
             v
          HEAP
       +-------------+
       | Teacher     |
       | name=Rahim  |
       +-------------+
             ^
             |
       +-------------+
       | d.teacher   |
       +-------------+
             ^
             |
       +-------------+
       | Department  |
       | deptName    |
       | CSE         |
       +-------------+
             ^
             |
             d
```

**Remember:** Java object variables store references to objects, not the actual objects themselves.

The diagram is conceptual; actual JVM memory implementation can vary.

---

# 6. Independent Lifecycle of Objects

The most important characteristic of Aggregation is that both objects have independent lifecycles.

Consider this example:

```java
Teacher t = new Teacher("Rahim");

Department d = new Department("CSE", t);

d = null;

System.out.println(t.name);
```

### Output

```text
Rahim
```

Why?

Because the Teacher object still has a reference through variable `t`.

Even though the Department reference is removed, the Teacher object continues to exist.

This demonstrates the independent lifecycle of Aggregation.

**Important:** Setting `d = null` does not destroy the Teacher object. Java's garbage collector manages objects when they become unreachable.

---

# 7. Aggregation with Multiple Objects

A Department can have multiple Teachers.

Let's implement this using an ArrayList.

```java
import java.util.ArrayList;

class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    ArrayList<Teacher> teachers;

    Department(String deptName, ArrayList<Teacher> teachers) {
        this.deptName = deptName;
        this.teachers = teachers;
    }

    void display() {
        System.out.println("Department: " + deptName);
        System.out.println("Teachers:");

        for (Teacher teacher : teachers) {
            System.out.println(teacher.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Rahim");
        Teacher t2 = new Teacher("Karim");
        Teacher t3 = new Teacher("Hasan");

        ArrayList<Teacher> teacherList = new ArrayList<>();

        teacherList.add(t1);
        teacherList.add(t2);
        teacherList.add(t3);

        Department d = new Department("CSE", teacherList);

        d.display();
    }
}
```

### Output

```text
Department: CSE
Teachers:
Rahim
Karim
Hasan
```

Here, multiple independently created Teacher objects are associated with one Department.

---

# 8. Real-Life Examples of Aggregation

Understanding real-life examples makes Aggregation much easier.

### Example 1: Department and Teacher

- A Department has Teachers.
- Teachers can exist independently.
- Teachers can move between Departments.

### Example 2: Library and Book

- A Library has Books.
- A Book can exist without a Library.
- Books can be transferred to another Library.

### Example 3: Team and Player

- A Team has Players.
- A Player can exist without a particular Team.
- A Player can join another Team.

### Example 4: Company and Employee

- A Company has Employees.
- Employees can exist independently.
- An Employee can leave one Company and join another.

### Example 5: University and Student

- A University has Students.
- A Student can exist independently.
- A Student can transfer to another University.

**Common Idea:** In all these examples, one object contains references to other independently existing objects.

---

# 9. Difference Between Aggregation and Composition

This is a very important OOP topic.

Both Aggregation and Composition represent HAS-A relationships.

However, their object lifecycle relationships are different.

### Aggregation

Aggregation represents a weak HAS-A relationship.

The contained object can exist independently of the containing object.

Example:

Department HAS-A Teacher.

If the Department is removed, the Teacher can still exist.

### Composition

Composition represents a strong HAS-A relationship.

The contained object is conceptually owned by the containing object, and its lifecycle is tied to the owner's lifecycle.

Example:

House HAS-A Room.

A Room, in this particular model, belongs to its House and does not have an independent lifecycle.

### Comparison Table

| Feature | Aggregation | Composition |
|---|---|---|
| Relationship | Weak HAS-A | Strong HAS-A |
| Ownership | Usually shared or non-exclusive | Exclusive ownership |
| Object lifecycle | Independent | Tied to owner |
| Dependency | Low | High |
| Object creation | Often created externally | Often created by owner |
| Object existence | Can exist independently | Depends on owner |
| Example | Department–Teacher | House–Room |

### Java Example: Aggregation

```java
class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Department {
    Teacher teacher;

    Department(Teacher teacher) {
        this.teacher = teacher;
    }
}
```

Teacher is created independently.

### Java Example: Composition

```java
class Room {
    String name;

    Room(String name) {
        this.name = name;
    }
}

class House {
    private final Room room;

    House() {
        this.room = new Room("Bedroom");
    }
}
```

Here, House creates and owns its Room as part of its design.

**Important:** Java does not have a special keyword for Aggregation or Composition. These relationships are determined by object ownership and lifecycle design, not merely by where `new` appears.

Also, Java garbage collection does not automatically enforce Composition's lifecycle rules.

---

# 10. Difference Between Association, Aggregation and Composition

These three concepts are closely related.

### Association

Association is a general relationship between two independent classes.

Example:

Teacher teaches Student.

Neither object necessarily owns the other.

### Aggregation

Aggregation is a specialized form of Association.

Example:

Department has Teacher.

The Teacher can exist independently.

### Composition

Composition is a stronger form of Association.

Example:

House has Room.

The Room is treated as an owned part of the House.

### Relationship Hierarchy

```text
          Association
               |
        +------+------+
        |             |
   Aggregation    Composition
   (Weak HAS-A)   (Strong HAS-A)
```

Remember:

- Association = General relationship.
- Aggregation = Weak ownership.
- Composition = Strong ownership.

---

# 11. UML Representation of Aggregation

UML stands for Unified Modeling Language.

It is used to visually represent relationships between classes.

In UML, Aggregation is represented by a hollow diamond.

### UML Diagram

```text
+------------------+       ◇----------------+
|    Department    |                        | Teacher
+------------------+                        +----------------+
| - deptName       |                        | - name         |
| - teacher        |                        +----------------+
+------------------+                        | + getName()    |
| + display()      |                        +----------------+
+------------------+
```

The hollow diamond is placed on the side of the containing or aggregate class.

For this example:

- Department is the aggregate.
- Teacher is the independent part.
- The hollow diamond represents Aggregation.

### UML Symbols

| Symbol | Meaning |
|---|---|
| `────` | Association |
| `◇────` | Aggregation |
| `◆────` | Composition |

---

# 12. Advantages of Aggregation

Aggregation provides several benefits in software development.

1. **Code Reusability:** Existing objects can be reused in different classes.
2. **Loose Coupling:** Classes are less dependent on each other's lifecycle.
3. **Flexibility:** Objects can be transferred or associated with different containers.
4. **Maintainability:** Changes in one class do not necessarily require changes in another.
5. **Independent Object Management:** Objects can be created and managed separately.
6. **Better Object-Oriented Design:** Helps represent real-world relationships.

---

# 13. Disadvantages of Aggregation

Aggregation also has some limitations.

1. **Reference Management:** Developers need to manage object references properly.
2. **Null References:** A reference may be null if the design allows it.
3. **Complexity:** Managing multiple relationships can make applications more complex.
4. **Data Consistency:** Changes to a shared object can affect multiple classes.
5. **Ownership Ambiguity:** It may be unclear which class is responsible for managing an object's state.

---

# 14. Common Mistakes Beginners Make

### Mistake 1: Creating the Object Inside the Containing Class

```java
class Department {
    Teacher teacher = new Teacher("Rahim");
}
```

This alone does not prove Aggregation or Composition.

The relationship depends on the intended ownership and lifecycle.

### Mistake 2: Confusing HAS-A with IS-A

HAS-A represents object containment or association.

IS-A represents inheritance.

Example:

- Department HAS-A Teacher = Aggregation.
- Dog IS-A Animal = Inheritance.

### Mistake 3: Thinking Aggregation Requires Two Constructors

No. The important thing is the relationship between objects, not the number of constructors.

### Mistake 4: Thinking Aggregation Requires an ArrayList

No. Aggregation can involve one object or multiple objects.

### Mistake 5: Thinking Setting the Parent Reference to Null Destroys the Child

No. Java uses garbage collection, and an object remains reachable as long as an accessible reference to it exists.

### Mistake 6: Thinking Aggregation and Composition Are Identical

Both represent HAS-A relationships, but their ownership and lifecycle semantics are different.

---

# 15. When Should You Use Aggregation?

Use Aggregation when:

- An object needs to use another independently existing object.
- The contained object should have its own lifecycle.
- The same object may be associated with multiple other objects.
- You want flexible and loosely coupled class relationships.
- You want to reuse existing objects instead of creating new ones.

Example:

A Teacher may work in a Department, but the Teacher should not depend on the Department's existence.

Therefore, Aggregation is suitable.

---

# 16. Aggregation vs Inheritance

These two concepts solve different problems.

| Feature | Aggregation | Inheritance |
|---|---|---|
| Relationship | HAS-A | IS-A |
| Purpose | Object collaboration | Code reuse and specialization |
| Keyword | No special keyword | `extends` |
| Example | Department HAS-A Teacher | Dog IS-A Animal |
| Object relationship | Contains a reference | Inherits class members |

Example of Aggregation:

```java
class Department {
    Teacher teacher;
}
```

Example of Inheritance:

```java
class Dog extends Animal {
}
```

---

# 17. Important Interview Questions

**Q1. What is Aggregation in Java?**

Aggregation is a special type of Association that represents a weak HAS-A relationship between two independent objects.

**Q2. Is Aggregation a type of Association?**

Yes. Aggregation is a specialized form of Association.

**Q3. What is the main characteristic of Aggregation?**

The contained object can exist independently of the containing object.

**Q4. What is a HAS-A relationship?**

A relationship in which one class contains a reference to an object of another class.

**Q5. Does Java provide an Aggregation keyword?**

No. Aggregation is implemented through object references.

**Q6. Can one object be shared by multiple objects?**

Yes. Aggregation can allow multiple objects to reference the same independent object.

**Q7. What is the difference between Aggregation and Composition?**

Aggregation represents a weak ownership relationship, whereas Composition represents strong ownership with a lifecycle dependency.

**Q8. What symbol represents Aggregation in UML?**

A hollow diamond (◇).

**Q9. Give three examples of Aggregation.**

- Department and Teacher.
- Library and Book.
- Team and Player.

**Q10. Why is Aggregation useful?**

It promotes flexibility, reusability and loose coupling between classes.

---

# 18. Practice Problems

Try solving these problems yourself to understand Aggregation properly.

### Problem 1: Library and Book

Create two classes:

- Book: `title`, `author`
- Library: `libraryName`, `Book book`

Requirements:
- Create a Book object independently.
- Pass the Book object to the Library constructor.
- Display library and book information.

### Problem 2: Company and Employee

Create two classes:

- Employee: `name`, `salary`
- Company: `companyName`, `Employee employee`

Requirements:
- Create an Employee object independently.
- Pass it to the Company constructor.
- Display company and employee details.
- Demonstrate that the Employee can exist without the Company.

### Problem 3: Team and Player

Create two classes:

- Player: `playerName`, `jerseyNumber`
- Team: `teamName`, `Player player`

Requirements:
- Create a Player object independently.
- Pass it to the Team constructor.
- Display team and player information.

---

# 19. Quick Revision — Everything at a Glance

| Question | Answer |
|---|---|
| What is Aggregation? | Special type of Association |
| Relationship | HAS-A |
| Ownership | Weak / Non-exclusive |
| Object lifecycle | Independent |
| Java keyword | None |
| Implementation | Object reference |
| UML symbol | Hollow diamond (◇) |
| Main purpose | Flexible object relationships |
| Example | Department HAS-A Teacher |
| Opposite comparison | Composition |

### The Most Important Thing to Remember

**Aggregation = HAS-A Relationship + Independent Lifecycle.**

If a Department has a Teacher, and that Teacher can continue to exist even if the Department no longer exists, the relationship represents Aggregation.

---

# Final Conclusion

Aggregation is an important OOP concept that allows one class to contain references to objects of another class without controlling their entire lifecycle.

It helps developers build flexible, reusable and loosely coupled software systems.

Understanding Aggregation also makes it easier to understand Composition, Association, Dependency Injection and other advanced object-oriented design concepts.

**Master this simple example:**

```java
Teacher t = new Teacher("Rahim");
Department d = new Department("CSE", t);
```

The Teacher is created independently and then passed to the Department.

That is the fundamental idea behind Aggregation in Java.
