package ReflectionAndAnnotationEXERCISES.BarracksWars.core.commands;

import ReflectionAndAnnotationEXERCISES.BarracksWars.annotations.Inject;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Repository;

public class RetireCommand extends Command{

    @Inject
    private Repository repository;


    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            repository.removeUnit(getData()[1]);
            return getData()[1] + " retired!";
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
