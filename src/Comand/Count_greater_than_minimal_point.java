package Comand;

import Comand.base.Command;
import Model.LabWork;

import java.util.Iterator;
import java.util.Scanner;

import static Comand.base.CollectionManager.priorityQueue;

public class Count_greater_than_minimal_point extends Command {
    public Count_greater_than_minimal_point() {
        super("count_greater_than_minimal_point");
    }
    @Override
    public void execute() throws IllegalAccessException {
        System.out.println("Введите значение минимального пойнта: ");
        Scanner in = new Scanner(System.in);
        double minpoint = in.nextDouble();
        Iterator<LabWork> iterator = priorityQueue.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            if (labWork.getMinimalPoint() > minpoint) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Элементов с бо'льшими минимальными пойнтами нет");
        }
        else {
            System.out.println(count);
        }
    }

    @Override
    public String getHelp() {
        return "вывести количество элементов, значение поля minimalPoint которых больше заданного";
    }
}
