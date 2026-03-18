import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringFrequencyMap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input text: ");
            String text = scanner.nextLine();

            Map<Character, Integer> frequency = new HashMap<>();
            for (char c : text.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    continue;
                }
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }

            System.out.println("Character frequency:");
            for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
