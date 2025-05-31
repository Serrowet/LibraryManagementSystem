package librarysystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private List<Book> borrowedBooks;

    // Constructor to initialize user details
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Add a book to the borrowed list
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Remove a book from the borrowed list
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + " (ID: " + userId + "), Borrowed books: " + borrowedBooks.size();
    }
}
