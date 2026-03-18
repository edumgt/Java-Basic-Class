import java.util.Scanner;

public class SimpleATMMenu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int balance = 100000;
            boolean running = true;

            while (running) {
                System.out.println("\n== ATM Menu ==");
                System.out.println("1. Check balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("0. Exit");
                System.out.print("Select: ");

                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println("Balance: " + balance);
                        break;
                    case 2:
                        System.out.print("Deposit amount: ");
                        int deposit = scanner.nextInt();
                        if (deposit > 0) {
                            balance += deposit;
                        }
                        System.out.println("Balance: " + balance);
                        break;
                    case 3:
                        System.out.print("Withdraw amount: ");
                        int withdraw = scanner.nextInt();
                        if (withdraw > 0 && withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("Balance: " + balance);
                        } else {
                            System.out.println("Invalid withdraw amount.");
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
