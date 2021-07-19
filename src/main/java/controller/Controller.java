package controller;

import UI.StudentUI;
import entities.Student;


import java.sql.*;

public class Controller {
    private static final String URL = "jdbc:sqlite:sample.db";
    private StudentUI ui;
    private Connection connection;

    public Controller( StudentUI ui) {
        this.ui = ui;
    }


    public void addTable() {
        try  {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            String s = "CREATE TABLE IF NOT EXISTS students (name VARCHAR(100), surname VARCHAR(100), age INTEGER, course INTEGER)";
            statement.execute(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteTable() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            String s = "DROP TABLE students";
            statement.execute(s);
            ui.printMessage("TABLE WAS DROPPED");

            addTable(); //fix a lot of exceptions

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        Student student = ui.readStudent();
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();

            String s = String.format("INSERT INTO students VALUES('%s', '%s', '%d', '%d')", student.getName(), student.getSurname(), student.getAge(), student.getCourse());
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
            addTable();
            ui.printMessage ("Try again");
            addStudent();
        }

    }

    public void printer() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM students";
            try (ResultSet resultSet = statement.executeQuery(s)) {
                resultCycle(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortedListPrinter() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM students ORDER BY name";
            try (ResultSet resultSet = statement.executeQuery(s)) {
                resultCycle(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            String request  = ui.request();
            String s = String.format("SELECT * FROM students WHERE name LIKE '%s' OR surname LIKE '%s' ORDER BY name", request, request);
            try (ResultSet resultSet = statement.executeQuery(s)) {
                resultCycle(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void resultCycle(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            int course = resultSet.getInt("course");
            ui.print(new Student(name, surname, age, course));
        }
    }
}
