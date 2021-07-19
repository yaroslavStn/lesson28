package items;

import controller.Controller;
import menu.Item;

public class PrintStudentsListItem extends Item {
    private Controller controller;

    public PrintStudentsListItem(Controller controller) {
        super("Print unsorted list");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.printer();


    }
}
