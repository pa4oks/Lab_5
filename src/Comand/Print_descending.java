package Comand;

import Comand.base.Command;
import Model.LabWork;

import java.util.*;

import static Comand.base.CollectionManager.priorityQueue;

public class Print_descending extends Command {
    public Print_descending() {
        super("print_descending");
    }
    @Override
    public void execute() throws IllegalAccessException {
        // Создаем копию PriorityQueue.  Так как используется naturalOrder(),
        // нам не нужно передавать компаратор.
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        // Преобразуем в ArrayList для сортировки
        List<LabWork> reversedQueue = new ArrayList<>(queueCopy);

        // Сортируем ArrayList в обратном порядке.  Теперь LabWork должен implements Comparable
        reversedQueue.sort(Collections.reverseOrder());

        System.out.println("Элементы в порядке убывания: ");
        for (LabWork labWork : reversedQueue) {
            labWork.ShowLabWork(labWork);
            System.out.println();
        }
    }

    @Override
    public String getHelp() {
        return "";
    }
}
