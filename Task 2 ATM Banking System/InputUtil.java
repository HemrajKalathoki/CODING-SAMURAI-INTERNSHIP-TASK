import java.util.Scanner;
import java.util.InputMismatchException;

public class InputUtil {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter a valid number.");
                sc.next(); 
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter a valid number.");
                sc.next();
            }
        }
    }
}
