package Comand;

import Comand.base.*;
import Model.*;
import java.util.*;

import static Comand.base.CollectionManager.priorityQueue;


public class Update_id extends Command implements ReaderCreator{
    public Update_id() {
        super("update_id");
    }
    @Override
    public void execute() throws IllegalAccessException {
        System.out.println("Введите id: ");
        Scanner in = new Scanner(System.in);
        long id = in.nextLong();
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            LabWork lb = iterator.next();
            long currentId = lb.getId();

            if (currentId == id) {
                System.out.println("Введите имя: ");
                lb.setName(in.nextLine());
                lb.setCoordinates(CoordinateReaderCreator());
                System.out.println("Введите Минимальный Пойнт: ");
                lb.setMinimalPoint(Double.parseDouble(in.nextLine()));
                System.out.println("Введите сложность: ");
                lb.setDifficulty(Difficulty.valueOf(in.nextLine()));
                lb.setAuthor(PersonReaderCreator());
                break;
            }
        }
        //update_id(Long.parseLong(in.nextLine()));
    }

    @Override
    public String getHelp() {
        return "изменяет поля объекта из коллекции по id";
    }
}
