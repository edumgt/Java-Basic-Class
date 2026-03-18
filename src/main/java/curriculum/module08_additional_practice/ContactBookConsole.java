import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactBookConsole {
    public static void main(String[] args) {
        Map<String, String> contacts = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n== Contact Book ==");
                System.out.println("1. Add");
                System.out.println("2. Find");
                System.out.println("3. List");
                System.out.println("0. Exit");
                System.out.print("Select: ");
                int menu = Integer.parseInt(scanner.nextLine());

                switch (menu) {
                    case 1:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Phone: ");
                        String phone = scanner.nextLine();
                        contacts.put(name, phone);
                        break;
                    case 2:
                        System.out.print("Name to find: ");
                        String target = scanner.nextLine();
                        System.out.println(contacts.getOrDefault(target, "Not found"));
                        break;
                    case 3:
                        for (Map.Entry<String, String> entry : contacts.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid menu.");
                }
            }
        }
    }
}
