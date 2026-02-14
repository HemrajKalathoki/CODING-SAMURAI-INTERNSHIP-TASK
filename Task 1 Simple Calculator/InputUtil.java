import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    public static double readNumber(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Try again.");
                sc.next();
            }
        }
    }
}
