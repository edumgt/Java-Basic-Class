package WorkingWithAbstractionEXERCISES.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);
        String command = scanner.nextLine();
        long startCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            Galaxy galaxy = new Galaxy(field);

            int[] playerPosition = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilPosition = readArray(scanner);

            galaxy.eliminateStars(evilPosition);
            startCollected += galaxy.collectStars(playerPosition);
            command = scanner.nextLine();
        }

        System.out.println(startCollected);

    }


    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
