package ReflectionAndAnnotationEXERCISES.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        Field[] fields = richSoilLandClass.getDeclaredFields();

        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {
            switch (input) {
                case "private":
                    Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers())).forEach(Main::printField);
                    break;
                case "protected":
                    Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers())).forEach(Main::printField);
                    break;
                case "public":
                    Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers())).forEach(Main::printField);
                    break;
                case "all":
                    Arrays.stream(fields).forEach(Main::printField);
                    break;
            }

            input = scanner.nextLine();

        }

    }

    public static void printField(Field field) {
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
    }
}
