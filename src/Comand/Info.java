package Comand;

import Comand.base.Command;

public class Info extends Command {
    public Info(){
        super("info");
    }

    @Override
    public void execute() {

    }

    @Override
    public String getHelp() {
        return "";
    }
}
