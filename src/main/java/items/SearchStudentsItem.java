package items;

import controller.Controller;
import menu.Item;

public class SearchStudentsItem extends Item {
    private Controller controller;

    public SearchStudentsItem(Controller controller) {
        super("Search Student");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.searchStudent();


    }
}
