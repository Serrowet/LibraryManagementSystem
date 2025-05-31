package librarysystem;

import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    registerUser();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n[1] Add Book");
        System.out.println("[2] Delete Book");
        System.out.println("[3] List Books");
        System.out.println("[4] Register User");
        System.out.println("[5] Borrow Book");
        System.out.println("[6] Return Book");
        System.out.println("[7] Exit");
        System.out.print("Your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void deleteBook() {
        System.out.print("Enter ISBN to delete: ");
        String isbn = scanner.nextLine();
        if (library.removeBook(isbn)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void listBooks() {
        System.out.println("\nBooks in Library:");
        int count = 1;
        for (Book book : library.getAllBooks()) {
            System.out.println(count +"." + book);
            count++;
        }
    }


    private static void registerUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        User user = new User(name, userId);
        library.addUser(user);
        System.out.println("User registered successfully!");
    }

    private static void borrowBook() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter ISBN to borrow: ");
        String isbn = scanner.nextLine();

        if (library.borrowBook(userId, isbn)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Failed to borrow book. Check user ID, ISBN, or availability.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter ISBN to return: ");
        String isbn = scanner.nextLine();

        if (library.returnBook(userId, isbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book. Check user ID and ISBN.");
        }
    }
}
