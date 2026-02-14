import java.util.Scanner;

public class ATMApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ATM Banking System");
        double initialBalance = InputUtil.readDouble(sc, "Enter opening balance: ");
        BankAccount account = new BankAccount(initialBalance);

        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            int choice = InputUtil.readInt(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    double depAmt = InputUtil.readDouble(sc, "Enter deposit amount: ");
                    account.deposit(depAmt);
                    System.out.println("Updated Balance: " + account.getBalance());
                    break;
                case 3:
                    double withAmt = InputUtil.readDouble(sc, "Enter withdrawal amount: ");
                    account.withdraw(withAmt);
                    System.out.println("Updated Balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using ATM System. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
