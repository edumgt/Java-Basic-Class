import java.util.Scanner;

public class PasswordPolicyChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.println(checkPolicy(password));
        }
    }

    static String checkPolicy(String password) {
        if (password.length() < 8) {
            return "Fail: length must be at least 8.";
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (!hasUpper || !hasLower || !hasDigit) {
            return "Fail: include upper/lower/digit.";
        }

        return "Pass";
    }
}
