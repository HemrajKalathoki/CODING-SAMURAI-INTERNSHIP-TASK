import service.*;
import ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        LibraryService libraryService = new LibraryService();
        new LoginFrame(auth, libraryService);
    }
}
