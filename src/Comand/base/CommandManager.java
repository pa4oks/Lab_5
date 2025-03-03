package Comand.base;

import Comand.*;

import java.util.HashMap;

public final class CommandManager {
    public static HashMap<String, Command> commandList;

    public CommandManager() {
        commandList.put("help", new Help());
    }

    public HashMap<String, Command> getCommandList() {
        return commandList;
    }
}
