package Comand;

import Comand.base.Command;
import Model.LabWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import static Comand.base.CollectionManager.priorityQueue;

public class Print_descending extends Command {
    public Print_descending() {
        super("print_descending");
    }
    @Override
    public void execute() throws IllegalAccessException {
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        ArrayList<LabWork> reveredQueue = new ArrayList<>();
        while (!queueCopy.isEmpty()) {
            reveredQueue.add(queueCopy.poll()); //poll возвращает элемент очереди, удаляя его
        }

        Collections.sort(reveredQueue, Collections.reverseOrder());
        System.out.println("Элементы в порядке убывания: " + reveredQueue);
    }

    @Override
    public String getHelp() {
        return "";
    }
}
