package PolymorphismEXERCISES.Word;

public class Initialization {

    static CommandImpl buildCommandInterface(StringBuilder text){
        CommandImpl command = new CommandImpl(text);
        command.init();
        return command;
    }
}
