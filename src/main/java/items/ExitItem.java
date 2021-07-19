package items;

import menu.Item;

public class ExitItem extends Item {

    public ExitItem() {
        super("Exit", true);
    }

    @Override
    public void exec() {
        System.out.println("Bye!");

    }
}
