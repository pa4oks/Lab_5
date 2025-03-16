package Comand;

import Comand.base.Command;
import Comand.base.ReaderCreator;
import Model.*;

import java.util.HashMap;
import java.util.Scanner;

import static Comand.base.CollectionManager.add;
import static Comand.base.CollectionManager.priorityQueue;

public class Add extends Command implements ReaderCreator {
    public Add() {
        super("add");
    }

    @Override
    public void execute() throws IllegalAccessException  {
        LabWork labworkNew = new LabWork();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        labworkNew.setName(in.nextLine());
        labworkNew.setCoordinates(CoordinateReaderCreator());
        System.out.println("Введите Минимальный Пойнт: ");
        labworkNew.setMinimalPoint(Double.parseDouble(in.nextLine()));
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

        labworkNew.setDifficulty(selectedDifficulty);
        labworkNew.setAuthor(PersonReaderCreator());

        add(labworkNew);
    }

    @Override
    public String getHelp() {
        return "добавляет новый labwork в коллекцию";
    }

   /* public static void register(HashMap<String,Command> stringCommandHashMap) {
        Add add = new Add();
        stringCommandHashMap.put(add.getName(), help);
    }*/
}
