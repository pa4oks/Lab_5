package Comand.base;

import Comand.*;

import java.util.HashMap;

public final class CommandManager {
    public static HashMap<String, Command> commandList;

    public CommandManager() {
        commandList.put("help", new Help());
        commandList.put("show", new Show());
        commandList.put("info", new Info()); //как делать????????????????????????????????
        commandList.put("add", new Add());
        commandList.put("update_by_id", new Update_id());
        commandList.put("remove_by_id", new Remove_by_id());
        commandList.put("clear", new Clear());
        //commandList.put("save", new Save());
        //commandList.put("execute_script file_name", new Execute_script file_name());
        //commandList.put("exit", new Exit());
        commandList.put("remove_first", new Remove_first());
        commandList.put("head", new Head());
        commandList.put("remove_lower", new Remove_lower());
        commandList.put("remove_any_by_author author", new Remove_any_by_author());
        commandList.put("count_greater_than_minimal_point minimalPoint", new Count_greater_than_minimal_point());
        commandList.put("print_descending", new Print_descending());
    }

    public HashMap<String, Command> getCommandList() {
        return commandList;
    }
}
