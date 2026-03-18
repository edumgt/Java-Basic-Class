package ReflectionAndAnnotationEXERCISES.BarracksWars.core.factories;

import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.Unit;
import ReflectionAndAnnotationEXERCISES.BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotationEXERCISES.barracksWars.models.units.";

    @Override
    public Object createUnit(String unitType) {
        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}
