package menu;

public abstract class Item {
private String name;
private boolean exit;

    public Item(String name, boolean exit) {
        this.name = name;
        this.exit = exit;
    }
    public Item(String name) {
        this.name = name;
        this.exit = false;
    }

    public String getName() {
        return name;
    }

    public boolean isExit() {
        return exit;
    }

public abstract void exec();

}
