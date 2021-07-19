package items;

import controller.Controller;
import menu.Item;

public class AddTableItem extends Item {
    private Controller controller;

    public AddTableItem(Controller controller) {
        super("Add table");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.addTable();

    }
}
