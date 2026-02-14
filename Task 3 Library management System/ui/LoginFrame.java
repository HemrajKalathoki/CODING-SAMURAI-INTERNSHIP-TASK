package ui;

import service.AuthService;
import service.LibraryService;
import model.User;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame(AuthService auth, LibraryService service) {

        setTitle("Library Login");
        setSize(300, 200);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(110, 20, 150, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(110, 60, 150, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 110, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            User loggedIn = auth.login(user, pass);

            if (loggedIn != null) {
                dispose();
                new DashboardFrame(loggedIn, service);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
