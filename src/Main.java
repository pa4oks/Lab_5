import Comand.base.Command;
import Comand.Test;

import java.util.HashMap;





import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        //new LabWork(1, Date.from(Instant.now()), 1, )
        Scanner in = new Scanner(System.in);
        HashMap<String, Command> map = new HashMap<>();
        Test.register(map);
        //Blabla.register(map);

        //Environment env = new Environment(map);

        while (in.hasNextLine()){
            String line = in.nextLine();
            if (map.keySet().contains(line)){
                Command command = map.get(line);
                command.execute();
            }
            else{
                System.err.println("Unknown command: " + line);
            }
        }
        }
    }
