import java.util.List;

// Smartphone 클래스는 Callable, Browsable 인터페이스를 구현함
public class Smartphone implements Callable, Browsable {

    // 전화번호 리스트
    private List<String> numbers;

    // URL 리스트
    private List<String> urls;

    // 생성자: 전화번호와 URL 목록을 초기화함
    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    // 웹 주소들을 탐색하는 기능을 구현
    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        // 각 URL에 대해 유효성 검사 후 메시지 생성
        for (String url : this.urls) {
            if (isURLValid(url)) {
                sb.append("Browsing: ").append(url).append("!");
            } else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator()); // 줄바꿈
        }

        return sb.toString();
    }

    // 전화번호 목록에 대해 전화를 거는 기능을 구현
    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        // 각 전화번호에 대해 유효성 검사 후 메시지 생성
        for (String number : this.numbers) {
            if (isNumberValid(number)) {
                sb.append("Calling... ").append(number);
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator()); // 줄바꿈
        }

        return sb.toString();
    }

    // 전화번호가 모두 숫자인지 검사
    private static boolean isNumberValid(String number) {
        for (char symbol : number.toCharArray()) {
            if (!Character.isDigit(symbol)) { // 숫자가 아니면 false
                return false;
            }
        }
        return true;
    }

    // URL에 숫자가 포함되어 있으면 유효하지 않다고 판단
    private static boolean isURLValid(String url) {
        for (char symbol : url.toCharArray()) {
            if (Character.isDigit(symbol)) { // 숫자가 포함되면 false
                return false;
            }
        }
        return true;
    }
}
