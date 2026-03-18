import java.util.Hashtable;
import java.util.Scanner;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<String, String> userTable = new Hashtable<>();
        userTable.put("admin", "admin123");
        userTable.put("user1", "pass1111");
        userTable.put("guest", "guest000");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("아이디 입력해 주세요: ");
                String id = scanner.nextLine();

                System.out.print("비번 입력해 주세요: ");
                String pw = scanner.nextLine();

                if (userTable.containsKey(id)) {
                    if (userTable.get(id).equals(pw)) {
                        System.out.println("Login Success");
                        break;
                    }
                    System.out.println("Login Fail");
                } else {
                    System.out.println("Login ID Not Exist");
                }
            }
        }
    }
}
