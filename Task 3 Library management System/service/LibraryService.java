package service;

import model.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> books;
    private int nextId = 1;
    private static final String FILE = "books.dat";

    public LibraryService() {
        books = load();
        if (!books.isEmpty()) {
            nextId = books.get(books.size() - 1).getId() + 1;
        }
    }

    public void addBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
        save();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public boolean borrowBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isAvailable()) {
                b.borrow();
                save();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isAvailable()) {
                b.returned();
                save();
                return true;
            }
        }
        return false;
    }

    private void save() {
        try (ObjectOutputStream out =
                 new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(books);
        } catch (Exception ignored) {}
    }

    private List<Book> load() {
        try (ObjectInputStream in =
                 new ObjectInputStream(new FileInputStream(FILE))) {
            return (List<Book>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
