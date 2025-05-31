package librarysystem;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor to initialize book details
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // Initially, the book is available
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter method to update availability status
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Returns a string representation of the book
    @Override
    public String toString() {
        return "Book:"+title +" Author:" + author + " (ISBN: " + isbn + ") " +
                (isAvailable ? "[Available]" : "[Borrowed]");
    }
}
