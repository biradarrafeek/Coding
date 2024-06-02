package LibraryMangement;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Register Member");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    registerMember();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("Enter Book ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Book Title:");
        String title = scanner.nextLine();
        System.out.println("Enter Book Author:");
        String author = scanner.nextLine();
        library.addBook(new Book(id, title, author));
    }

    private static void removeBook() {
        System.out.println("Enter Book ID to remove:");
        String id = scanner.nextLine();
        library.removeBook(id);
    }

    private static void searchBook() {
        System.out.println("Enter Book Title to search:");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null) {
            System.out.println("Book Found: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void registerMember() {
        System.out.println("Enter Member ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Member Name:");
        String name = scanner.nextLine();
        library.registerMember(new Member(id, name));
    }

    private static void issueBook() {
        System.out.println("Enter Book ID to issue:");
        String bookId = scanner.nextLine();
        System.out.println("Enter Member ID:");
        String memberId = scanner.nextLine();
        library.issueBook(bookId, memberId);
    }

    private static void returnBook() {
        System.out.println("Enter Book ID to return:");
        String bookId = scanner.nextLine();
        System.out.println("Enter Member ID:");
        String memberId = scanner.nextLine();
        library.returnBook(bookId, memberId);
    }
}

