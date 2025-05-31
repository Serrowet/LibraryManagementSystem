package librarysystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book by ISBN
    public boolean removeBook(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    // List all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Find a book by ISBN
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // List all users
    public List<User> getAllUsers() {
        return users;
    }

    // Find user by ID
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Borrow a book for a user
    public boolean borrowBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);
        if (user != null && book != null && book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
            return true;
        }
        return false;
    }

    // Return a book from a user
    public boolean returnBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);
        if (user != null && book != null) {
            book.setAvailable(true);
            user.returnBook(book);
            return true;
        }
        return false;
    }
}
