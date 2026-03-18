package ReflectionAndAnnotationEXERCISES.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> blackBoxIntConstructor = blackBoxIntClass.getDeclaredConstructor();
        blackBoxIntConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance();

        Field hiddenValue = blackBoxIntClass.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);

        while (!"END".equals(input)){
            String[] data = input.split("\\_");
            String currentMethod = data[0];
            int value = Integer.parseInt(data[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(currentMethod, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(hiddenValue.get(blackBoxInt));
            input = scanner.nextLine();
        }

    }
}
