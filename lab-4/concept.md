# Association in Java: Bank and Employee

## Overview

This project demonstrates the **Association Relationship in Object-Oriented Programming (OOP)** using Java. It illustrates how two independent classes, `Bank` and `Employee`, can be connected through an association.

## Concept

Association is a relationship between two independent classes where objects of one class are connected to or interact with objects of another class.

In this example, a bank has multiple employees, but employees can exist independently of the bank.

## Classes and Responsibilities

### 1. Bank Class
- Stores the bank's name.
- Maintains a collection of employees using `Set<Employee>`.
- Provides methods to manage and retrieve employee information.

### 2. Employee Class
- Stores an employee's name.
- Provides a method to retrieve the employee's name.

### 3. AssociationExample Class
- Contains the `main()` method.
- Creates `Employee` and `Bank` objects.
- Establishes the association between the bank and its employees.
- Displays the employees associated with the bank.

## How It Works

1. Create employee objects, such as `Ridhi` and `Vijay`.
2. Store the employee objects in a `Set<Employee>`.
3. Create a `Bank` object named `ICICI`.
4. Associate the employees with the bank.
5. Display each employee's name along with the bank's name.

## Example Output

```text
Ridhi belongs to bank ICICI
Vijay belongs to bank ICICI
```

*Note: The employee display order may vary because the original implementation uses `HashSet`.*

## OOP Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- Association Relationship
- Java Collections Framework (`Set` and `HashSet`)
- Object References

## Technologies Used

- **Language:** Java
- **Concept:** Object-Oriented Programming (OOP)

## How to Run

1. Save the source code in a file named `AssociationExample.java`.
2. Open a terminal in the directory containing the file.
3. Compile the program:

   ```bash
   javac AssociationExample.java
   ```

4. Run the program:

   ```bash
   java AssociationExample
   ```

## Conclusion

This project demonstrates how the Association Relationship connects two independent classes in Java. The `Bank` class maintains a collection of `Employee` objects, illustrating a practical example of association in object-oriented programming.

---

**Course:** Advanced Object-Oriented Programming (Advanced OOP)