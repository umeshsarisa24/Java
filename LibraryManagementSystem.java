import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        books.add(new Book(id, title));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
