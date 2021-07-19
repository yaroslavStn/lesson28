package items;

import controller.Controller;
import menu.Item;

public class PrintSortedStudentsListItem extends Item {
    private Controller controller;

    public PrintSortedStudentsListItem(Controller controller) {
        super("Print sorted list");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.sortedListPrinter();
    }
}
