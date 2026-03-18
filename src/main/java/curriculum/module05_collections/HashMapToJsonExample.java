import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapToJsonExample {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "홍길동");
        data.put("age", 25);
        data.put("email", "hong@example.com");

        String jsonString = toJsonString(data);
        System.out.println("JSON 출력: " + jsonString);
    }

    private static String toJsonString(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder("{");
        Iterator<Map.Entry<String, Object>> iterator = data.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            sb.append("\"").append(entry.getKey()).append("\":");

            Object value = entry.getValue();
            if (value instanceof Number || value instanceof Boolean) {
                sb.append(value);
            } else {
                sb.append("\"").append(value).append("\"");
            }

            if (iterator.hasNext()) {
                sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
