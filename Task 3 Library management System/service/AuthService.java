package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private List<User> users = new ArrayList<>();

    public AuthService() {
        users.add(new User("admin", "1234", "ADMIN"));
        users.add(new User("student", "1234", "STUDENT"));
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
