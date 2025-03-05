package Comand;

import Comand.base.Command;
import Model.LabWork;

import static Comand.base.CollectionManager.priorityQueue;

public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public void execute() {
        priorityQueue.forEach(LabWork::print);
    }

    @Override
    public String getHelp() {
        return "выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
