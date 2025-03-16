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
        Person personNew = new Person();
        System.out.println("Введите информацию о человеке: ");
        System.out.println("Введите имя: ");
        personNew.setName(in.nextLine());
        System.out.println("Введите вес: ");
        personNew.setWeight(Integer.parseInt(in.nextLine()));

        Color selectedEyeColor = null;

        while (selectedEyeColor == null) {
            System.out.println("Введите цвет глаз: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }

            try {
                selectedEyeColor = Color.valueOf(in.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }
        personNew.setEyeColor(selectedEyeColor);

        Color selectedHairColor = null;

        while (selectedHairColor == null) {
            System.out.println("Введите цвет волос: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }

            try {
                selectedHairColor = Color.valueOf(in.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }
        personNew.setHairColor(selectedHairColor);

        Country selectedCountry = null;

        while (selectedCountry == null) {
            System.out.println("Введите национальность: ");
            for (Country country : Country.values()) {
                System.out.println(country);
            }

            try {
                selectedCountry = Country.valueOf(in.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
            }
        }
        personNew.setNationality(selectedCountry);

        System.out.println("Введите местоположение: ");
        personNew.setLocation(LocationReaderCreator());
        return personNew;
    }
    public default Location LocationReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Location locationNew = new Location();
        System.out.println("Введите название места: ");
        locationNew.setName(in.nextLine());
        System.out.println("Введите координаты местоположения:");
        System.out.print("x = ");
        locationNew.setX(Long.parseLong(in.nextLine()));
        System.out.print("y = ");
        locationNew.setY(Integer.parseInt(in.nextLine()));
        System.out.print("z = ");
        locationNew.setZ(Float.parseFloat(in.nextLine()));
        return locationNew;
    }
    public default Coordinates CoordinateReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Coordinates coordinatesNew = new Coordinates();

        System.out.println("Введите координаты местоположения:");
        System.out.print("x = ");
        coordinatesNew.setX(Float.parseFloat(in.nextLine()));
        System.out.print("y = ");
        coordinatesNew.setY(Float.parseFloat(in.nextLine()));
        return coordinatesNew;
    }
}
