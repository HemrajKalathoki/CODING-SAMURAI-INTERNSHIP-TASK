import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorService service = new CalculatorService();

        while (true) {
            printMenu();
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 7) {
                System.out.println("Calculator closed.");
                break;
            }

            String op = mapChoiceToOperator(choice);
            if (op == null) {
                System.out.println("Invalid choice.");
                continue;
            }

            double a = InputUtil.readNumber(sc, "Enter first number: ");
            double b = InputUtil.readNumber(sc, "Enter second number: ");

            try {
                double result = service.calculate(a, b, op);
                System.out.println("Result = " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }
        sc.close();
    }

    static void printMenu() {
        System.out.println("=== SIMPLE CALCULATOR ===");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.println("5. %");
        System.out.println("6. ^");
        System.out.println("7. exit");
    }

    static String mapChoiceToOperator(int choice) {
        switch (choice) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "*";
            case 4: return "/";
            case 5: return "%";
            case 6: return "^";
            default: return null;
        }
    }
}
