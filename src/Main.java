import Comand.Add;
import Comand.Help;
import Comand.base.Command;
import Comand.Test;
import Comand.base.CommandManager;
import files.CSVCollectionManager;


import java.util.HashMap;


import java.util.List;
import java.util.Scanner;

import static Comand.base.CommandManager.commandList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        //new LabWork(1, Date.from(Instant.now()), 1, )
        Scanner in = new Scanner(System.in);
        HashMap<String, Command> map = new HashMap<>();
        /*Test.register(map);
        Help.register(map);
        Add.register(map);*/
        CommandManager commandManagermanager = new CommandManager();

        while (in.hasNextLine()){
            String line = in.nextLine();
            if (commandList.keySet().contains(line)){
                Command command = commandList.get(line);
                command.execute();
            }
            else{
                System.err.println("Unknown command: " + line);
            }
        }

        if (args.length != 1) {
            System.err.println("Использование: java CSVCollectionManager <путь_к_csv_файлу>");
            return;
        }

        String filePath = "D:/Word_documents/file_proga.csv";  // args[0] Получаем путь к файлу из аргументов командной строки
        String delimiter = ",";      // Разделитель по умолчанию

        CSVCollectionManager manager = new CSVCollectionManager(filePath, delimiter);
        List<String[]> data = manager.getDataCollection();

        if (data != null && !data.isEmpty()) {
            System.out.println("Содержимое коллекции:");
            for (String[] row : data) {
                for (String value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }

            boolean saveResult = manager.saveDataToFile(false); //Перезаписываем файл
            if (saveResult) {
                System.out.println("Коллекция успешно сохранена в файл: " + filePath);
            } else {
                System.err.println("Не удалось сохранить коллекцию в файл: " + filePath);
            }

        } else {
            System.err.println("Коллекция пуста или не удалось загрузить данные из файла: " + filePath);
        }

        }
    }
