package files;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, который читает данные из CSV-файла, заполняет коллекцию, и позволяет записывать
 * коллекцию обратно в файл. Имя файла передается как аргумент командной строки.
 */
public class CSVCollectionManager {

    private List<String[]> dataCollection; // Коллекция для хранения данных
    private String filePath;              // Путь к файлу CSV
    private String delimiter;             // Разделитель полей в CSV

    /**
     * Конструктор класса CSVCollectionManager.
     *
     * @param filePath  Путь к файлу CSV. Передаётся как аргумент командной строки.
     * @param delimiter Разделитель полей в CSV-файле (например, "," или ";").
     */
    public CSVCollectionManager(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
        this.dataCollection = new ArrayList<>(); // Инициализация коллекции
        loadDataFromFile();                       // Загрузка данных из файла при создании экземпляра
    }

    /**
     * Загружает данные из CSV-файла в коллекцию dataCollection.
     * Обрабатывает ошибки, такие как FileNotFoundException и IOException.
     */
    private void loadDataFromFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new java.io.File(filePath), Charset.forName("UTF-8"));
            scanner.useDelimiter(delimiter + System.lineSeparator());

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] values = line.split(delimiter);
                dataCollection.add(values);
            }

            System.out.println("Данные успешно загружены из файла: " + filePath);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден: " + filePath);
        } catch (NoSuchElementException e) {
            System.err.println("Ошибка: Некорректный формат данных в файле: " + filePath);
        } catch (Exception e) {
            System.err.println("Произошла ошибка при чтении файла " + filePath + ": " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Получает коллекцию данных.
     *
     * @return List<String[]> Коллекция данных.
     */
    public List<String[]> getDataCollection() {
        return dataCollection;
    }

    /**
     * Устанавливает коллекцию данных.
     *
     * @param dataCollection Новая коллекция данных.
     */
    public void setDataCollection(List<String[]> dataCollection) {
        this.dataCollection = dataCollection;
    }


    /**
     * Записывает данные из коллекции в CSV-файл, используя BufferedOutputStream.
     *
     * @param appendToFile  true, если нужно добавить данные в конец файла, false, если нужно перезаписать файл.
     * @return true в случае успешной записи, false в случае ошибки.
     */
    public boolean saveDataToFile(boolean appendToFile) {
        BufferedOutputStream bos = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream(filePath, appendToFile));

            for (String[] row : dataCollection) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    sb.append(row[i]);
                    if (i < row.length - 1) {
                        sb.append(delimiter);
                    }
                }
                sb.append(System.lineSeparator());
                byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
                bos.write(bytes);
            }

            System.out.println("Данные успешно записаны в файл: " + filePath);
            return true;

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Невозможно создать/открыть файл для записи: " + filePath);
            return false;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при записи в файл: " + e.getMessage());
            return false;
        } catch (SecurityException e) {
            System.err.println("Ошибка: Отсутствуют права доступа для записи в файл: " + filePath);
            return false;
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка при записи в файл: " + e.getMessage());
            return false;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии BufferedOutputStream: " + e.getMessage());
                }
            }
        }
    }


    /**
     * Главный метод программы.
     * Загружает данные из файла, указанного в аргументах командной строки,
     * выводит их на экран и записывает обратно в файл.
     *
     * @param args Аргументы командной строки.  Ожидается один аргумент: путь к CSV файлу.
     */
}