package UI;

import entities.Student;

public interface StudentUI {
 Student readStudent();

    void print(Student student);

    String request ();

    void printMessage(String s);
}
