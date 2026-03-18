package ReflectionAndAnnotationEXERCISES.BarracksWars;

import ReflectionAndAnnotationEXERCISES.BarracksWars.core.commands.CommandInterpreterImpl;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Runnable;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationEXERCISES.BarracksWars.core.Engine;
import ReflectionAndAnnotationEXERCISES.BarracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationEXERCISES.BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
