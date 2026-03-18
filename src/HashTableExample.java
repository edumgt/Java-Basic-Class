import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {
    public static void main(String[] args) {
        try {
            // Jackson ObjectMapper 생성
            ObjectMapper mapper = new ObjectMapper();

            // JSON → Map<String, String>
            Map<String, String> map = mapper.readValue(
                    new File("C:\\edumgt-java-education\\java-education-002\\src\\resources\\users.json"),
                    Map.class);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("아이디 입력해 주세요:");
                String id = scanner.nextLine();

                System.out.println("비번 입력해 주세요:");
                String pw = scanner.nextLine();

                System.out.println("");

                if (map.containsKey(id)) {
                    if (map.get(id).equals(pw)) {
                        System.out.println("Login Success");
                        System.exit(0); // 로그인 성공 → 종료
                    } else {
                        System.out.println("Login Fail");
                    }
                } else {
                    System.out.println("Login ID Not Exist");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
