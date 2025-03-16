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
        boolean f = false;
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            LabWork lb = iterator.next();
            long currentId = lb.getId();

            if (currentId == id) {
                f = true;
                System.out.println("Введите имя: ");
                lb.setName(in.nextLine());
                lb.setCoordinates(CoordinateReaderCreator());
                System.out.println("Введите Минимальный Пойнт: ");
                lb.setMinimalPoint(Double.parseDouble(in.nextLine()));
                Difficulty selectedDifficulty = null;
                while (selectedDifficulty == null) {
                    System.out.println("Введите сложность: ");
                    for (Difficulty difficulty : Difficulty.values()) {
                        System.out.println(difficulty);
                    }

                    try {
                        selectedDifficulty = Difficulty.valueOf(in.nextLine());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: Некорректный ввод сложности. Пожалуйста, введите еще раз");
                    }
                }
                lb.setAuthor(PersonReaderCreator());
                break;
            }
            /*try {
                f=true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого id нет. Пожалуйста, введите еще раз");
            }*/
        }
        //update_id(Long.parseLong(in.nextLine()));
    }

    @Override
    public String getHelp() {
        return "изменяет поля объекта из коллекции по id";
    }
}
