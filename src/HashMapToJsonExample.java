import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class HashMapToJsonExample {
    public static void main(String[] args) {
        try {
            // HashMap 생성
            Map<String, Object> data = new HashMap<>();
            data.put("name", "홍길동");
            data.put("age", 25);
            data.put("email", "hong@example.com");

            // Jackson ObjectMapper 사용
            ObjectMapper mapper = new ObjectMapper();

            // JSON 문자열로 변환
            String jsonString = mapper.writeValueAsString(data);

            System.out.println("JSON 출력: " + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
