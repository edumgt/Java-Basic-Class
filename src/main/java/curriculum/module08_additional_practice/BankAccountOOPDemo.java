public class BankAccountOOPDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("kimdy", 50000);
        account.deposit(15000);
        account.withdraw(30000);
        account.withdraw(50000);
        System.out.println(account);
    }

    static class BankAccount {
        private final String owner;
        private int balance;

        BankAccount(String owner, int balance) {
            this.owner = owner;
            this.balance = balance;
        }

        void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        void withdraw(int amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        @Override
        public String toString() {
            return "BankAccount{owner='" + owner + "', balance=" + balance + "}";
        }
    }
}
