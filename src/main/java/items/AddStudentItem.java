package items;

import controller.Controller;
import menu.Item;

public class AddStudentItem extends Item {
    private Controller controller;

    public AddStudentItem(Controller controller) {
        super("Add Student");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.addStudent();

    }
}
