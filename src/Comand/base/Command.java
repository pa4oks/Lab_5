package Comand.base;

public abstract class Command {
    private final String name;

    protected Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(); //выполняет команду

    public abstract String getHelp(); //справка


}
