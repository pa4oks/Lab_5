package Comand;
import Comand.base.*;
import Comand.base.Command;

import static Comand.base.CommandManager.commandList;

public class Help extends Command {
    public Help() {
        super("help");
    }
    @Override
    public void execute() {
        commandList.forEach((key, command) -> {
            System.out.println(key + ": " + command);
        });
    }

    @Override
    public String getHelp() {
        return "this is the list of commands";
    }
}
