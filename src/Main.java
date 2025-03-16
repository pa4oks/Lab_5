import Comand.Add;
import Comand.Help;
import Comand.base.Command;
import Comand.Test;
import Comand.base.CommandManager;
import Model.LabWork;
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


        //String filePath = "D:/Word_documents/file_proga.csv";  // args[0] Получаем путь к файлу из аргументов командной строки
        Scanner in = new Scanner(System.in);  // Создаем Scanner для чтения из консоли

        System.out.println("Введите путь к файлу CSV: ");
        String filePath = in.nextLine();  // Читаем путь к файлу из консоли

        System.out.println("Введите разделитель: ");
        String delimiter = in.nextLine();  // Читаем разделитель из консоли

        CSVCollectionManager manager = new CSVCollectionManager(filePath, delimiter);

        // Получаем коллекцию LabWork из CSVCollectionManager
        List<LabWork> labWorks = manager.getDataCollectionLabWork();

        // Пример использования данных (вывод информации о первом LabWork):
        if (!labWorks.isEmpty()) {
            System.out.println("Информация о первом LabWork:");
            LabWork firstLabWork = labWorks.get(0);
            firstLabWork.print();  // Используем метод print() из LabWork
        } else {
            System.out.println("Данные LabWork не загружены.");
        }

        // Пример сохранения данных (перезапись):
        // manager.saveDataToFile(false); // false = перезапись, true = добавление

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
    }
}
//     java Main "D:/Word_documents/file_proga_g.csv" ";"
//     D:/Word_documents/file_proga_g.csv