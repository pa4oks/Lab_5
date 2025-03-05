package Comand;

import Comand.base.Command;
import Model.LabWork;

import static Comand.base.CollectionManager.priorityQueue;

public class Head extends Command {
    public Head() {
        super("head");
    }

    @Override
    public void execute() throws IllegalAccessException {
        LabWork highestPriorityElement = priorityQueue.peek(); // Получаем элемент с наивысшим приоритетом
        if (highestPriorityElement != null) {
            System.out.println("Первый элемент: " + highestPriorityElement);
        } else {
            System.out.println("Очередь пуста.");
        }
    }

    @Override
    public String getHelp() {
        return "вывести первый элемент коллекции";
    }
}
