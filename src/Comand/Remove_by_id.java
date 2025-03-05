package Comand;

import Comand.base.Command;

import java.util.Scanner;

import static Comand.base.CollectionManager.removeByID;

public class Remove_by_id extends Command {
    public Remove_by_id() {
        super("remove_by_id");
    }
    @Override
    public void execute() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        removeByID(Long.parseLong(in.nextLine()));
    }

    @Override
    public String getHelp() {
        return " удалить элемент из коллекции по его id";
    }
}
