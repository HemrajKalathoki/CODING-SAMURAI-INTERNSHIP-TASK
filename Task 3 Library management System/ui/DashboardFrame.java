package ui;

import model.User;
import service.LibraryService;
import model.Book;

import javax.swing.*;
import java.util.List;

public class DashboardFrame extends JFrame {

    private LibraryService service;
    private User user;

    public DashboardFrame(User user, LibraryService service) {
        this.user = user;
        this.service = service;

        setTitle("Library Dashboard - " + user.getRole());
        setSize(400, 350);
        setLayout(null);

        JButton viewBtn = new JButton("View Books");
        viewBtn.setBounds(20, 20, 150, 30);
        add(viewBtn);

        JButton borrowBtn = new JButton("Borrow Book");
        borrowBtn.setBounds(20, 70, 150, 30);
        add(borrowBtn);

        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBounds(20, 120, 150, 30);
        add(returnBtn);

        if (user.getRole().equals("ADMIN")) {
            JButton addBtn = new JButton("Add Book");
            addBtn.setBounds(20, 170, 150, 30);
            add(addBtn);

            addBtn.addActionListener(e -> {
                String title = JOptionPane.showInputDialog("Book Title:");
                String author = JOptionPane.showInputDialog("Author:");
                if (title != null && author != null) {
                    service.addBook(title, author);
                    JOptionPane.showMessageDialog(this, "Book Added");
                }
            });
        }

        viewBtn.addActionListener(e -> {
            List<Book> books = service.getAllBooks();
            if (books.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No books available.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Book b : books) sb.append(b).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        borrowBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter Book ID to borrow:");
            try {
                int id = Integer.parseInt(input);
                if (service.borrowBook(id))
                    JOptionPane.showMessageDialog(this, "Borrowed successfully.");
                else
                    JOptionPane.showMessageDialog(this, "Book not available.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID.");
            }
        });

        returnBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter Book ID to return:");
            try {
                int id = Integer.parseInt(input);
                if (service.returnBook(id))
                    JOptionPane.showMessageDialog(this, "Returned successfully.");
                else
                    JOptionPane.showMessageDialog(this, "Invalid ID or not borrowed.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID.");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
