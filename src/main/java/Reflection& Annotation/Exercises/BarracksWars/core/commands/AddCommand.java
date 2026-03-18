package ReflectionAndAnnotationEXERCISES.BarracksWars.core.commands;

import ReflectionAndAnnotationEXERCISES.BarracksWars.annotations.Inject;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Object unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;

    }
}
