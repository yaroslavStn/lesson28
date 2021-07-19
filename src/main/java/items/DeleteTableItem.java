package items;

import controller.Controller;
import menu.Item;

public class DeleteTableItem extends Item {
    private Controller controller;

    public DeleteTableItem(Controller controller) {
        super("Delete table");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.deleteTable();


    }
}
