package UI;

import entities.Student;
import javafx.scene.transform.Scale;

import java.util.Scanner;

public class ConsoleUI implements StudentUI {
    private Scanner sc;

    public ConsoleUI(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public Student readStudent() {
        System.out.println("Enter name, surname, age and course");
        String name = sc.next();
        String surname = sc.next();
        String ageAsString =sc.next();
        String courseAsString =sc.next();
        int age= 18;
        int course = 1;
        try {
             age = Integer.parseInt(ageAsString);
             course = Integer.parseInt(courseAsString);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect, default value: age - 18, course - 1");
        }
        sc.nextLine();
        return new Student(name, surname, age,course);
    }

    @Override
    public void print(Student student) {
        System.out.println("name: "+
                student.getName()+
                " surname: "+
                student.getSurname()+
                " age: "+
                student.getAge()+
                " course: "+
                student.getCourse());
    }

    @Override
    public String request() {
        System.out.println("Enter chars for search");

        return String.format("%%%s%%",sc.nextLine());
    }

    @Override
    public void printMessage(String s) {
        System.out.println(s);
    }
}
