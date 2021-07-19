import UI.ConsoleUI;
import UI.StudentUI;
import controller.Controller;
import items.*;
import menu.Item;
import menu.Menu;
import menu.MenuConsole;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       new Main().run();
    }

    private void run() {

        Scanner sc= new Scanner(System.in);
        StudentUI ui = new ConsoleUI(sc);


        Controller controller = new Controller(ui);
        Item[] items ={
                new AddTableItem(controller),
                new AddStudentItem(controller),
                new DeleteTableItem(controller),
                new PrintStudentsListItem(controller),
                new PrintSortedStudentsListItem(controller),
                new SearchStudentsItem(controller),
                new ExitItem()
        };

        Menu menu = new MenuConsole(sc,items);
        menu.run();

    }
}
