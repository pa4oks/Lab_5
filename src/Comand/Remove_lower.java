package Comand;
import Comand.base.*;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

import static Comand.base.CollectionManager.priorityQueue;

public class Remove_lower extends Command{
    public Remove_lower(){
        super("remove_lower");
    }
    @Override
    public void execute() {
        System.out.println("Введите id элемента, элементы меньшие которого хотите удалить");
        Scanner in = new Scanner(System.in);
        long lastElementUnderDelete = in.nextLong();
        priorityQueue.removeIf(item -> item.getId() < lastElementUnderDelete);
    }

    @Override
    public String getHelp() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
