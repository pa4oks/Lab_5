package Comand;

import Comand.base.Command;
import Comand.base.ReaderCreator;
import Model.LabWork;
import Model.Person;

import java.util.Iterator;

import static Comand.base.CollectionManager.priorityQueue;

public class Remove_any_by_author extends Command implements ReaderCreator {
    public Remove_any_by_author() {
        super("remove_any_by_author");
    }
    @Override
    public void execute() throws IllegalAccessException {
        System.out.println("Введите автора");
        Person author = PersonReaderCreator();
        Iterator<LabWork> iterator = priorityQueue.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            if (!removed && labWork.getAuthor() == author) {
                iterator.remove();
                removed = true;
            }
        }
    }

    @Override
    public String getHelp() {
        return "удалить из коллекции один элемент, значение поля author которого эквивалентно заданному";
    }
}
