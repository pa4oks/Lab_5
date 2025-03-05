package Comand;

import Comand.base.Command;

import static Comand.base.CollectionManager.priorityQueue;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }
    @Override
    public void execute() throws IllegalAccessException {
        priorityQueue.clear();
    }

    @Override
    public String getHelp() {
        return "очистить коллекцию";
    }
}
