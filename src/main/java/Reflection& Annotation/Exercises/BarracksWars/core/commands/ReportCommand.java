package ReflectionAndAnnotationEXERCISES.BarracksWars.core.commands;

import ReflectionAndAnnotationEXERCISES.BarracksWars.annotations.Inject;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
