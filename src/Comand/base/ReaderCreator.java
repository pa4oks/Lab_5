package Comand.base;
import Comand.base.*;
import Model.*;

import java.util.Scanner;

public interface ReaderCreator {
    /*public default LabWork LabworkReaderCreator() throws IllegalAccessException{

        return
    }*/

    public default Person PersonReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Person personNew = null;
        System.out.println("Введите информацию о человеке: ");
        System.out.println("Введите имя: ");
        personNew.setName(in.nextLine());
        System.out.println("Введите вес: ");
        personNew.setWeight(Integer.parseInt(in.nextLine()));
        System.out.println("Введите цвет глаз: ");
        personNew.setEyeColor(Color.valueOf(in.nextLine()));
        System.out.println("Введите цвет волос: ");
        personNew.setHairColor(Color.valueOf(in.nextLine()));
        System.out.println("Введите национальность: ");
        personNew.setNationality(Country.valueOf(in.nextLine()));
        System.out.println("Введите местоположение: ");
        personNew.setLocation(LocationReaderCreator());
        return personNew;
    }
    public default Location LocationReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Location locationNew = null;
        System.out.println("Введите название места: ");
        locationNew.setName(in.nextLine());
        System.out.println("Введите координаты местоположения:");
        System.out.println("x = ");
        locationNew.setX(Long.parseLong(in.nextLine()));
        System.out.println("y = ");
        locationNew.setY(Integer.parseInt(in.nextLine()));
        System.out.println("z = ");
        locationNew.setZ(Float.parseFloat(in.nextLine()));
        return locationNew;
    }
    public default Coordinates CoordinateReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Coordinates coordinatesNew = null;
        System.out.println("Введите координаты местоположения:");
        System.out.println("x = ");
        coordinatesNew.setX(Float.parseFloat(in.nextLine()));
        System.out.println("y = ");
        coordinatesNew.setY(Float.parseFloat(in.nextLine()));
        return coordinatesNew;
    }
}
