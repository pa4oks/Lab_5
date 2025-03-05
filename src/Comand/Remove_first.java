package Comand;

import Comand.base.Command;

import static Comand.base.CollectionManager.priorityQueue;

public class Remove_first extends Command {
    public Remove_first() {
        super("remove first");
    }
    @Override
    public void execute() throws IllegalAccessException {
        priorityQueue.remove(0);
    }

    @Override
    public String getHelp() {
        return "удалить первый элемент из коллекции";
    }
}
