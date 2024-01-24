import java.util.Scanner;

public class LibraryManager {
    private SecurityCheck securityCheck;
    private BookRepository bookRepository;
    private ReturnStack returnStack;

    public LibraryManager() {
        this.securityCheck = new SecurityCheck();
        this.bookRepository = new BookRepository();
        this.returnStack = new ReturnStack();
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nWelcome to the Library Manager!\n");
            System.out.println("Please choose an option:");
            System.out.println(" (B) - Manage Book Repository");
            System.out.println(" (R) - Manage Return Stack");
            System.out.println(" (Q) - Quit");

            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "B":
                    libraryManager.manageBookRepository(scanner);
                    break;
                case "R":
                    libraryManager.manageReturnStack(scanner);
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (!input.equals("Q"));

        scanner.close();
    }

    private void manageBookRepository(Scanner scanner) {
        String input;

        do {
            System.out.println("\nBook Repository:");
            System.out.println(bookRepository);

            System.out.println("\nPlease choose an option:");
            System.out.println(" (C) - Checkout Book");
            System.out.println(" (N) - Add New Book");
            System.out.println(" (R) - Remove Book");
            System.out.println(" (P) - Print Repository");
            System.out.println(" (S) - Sort Shelf");
            System.out.println(" (Q) - Quit");

            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "C":
                    manageCheckout(scanner);
                    break;
                case "N":
                    manageAddNewBook(scanner);
                    break;
                case "R":
                    manageRemoveBook(scanner);
                    break;
                case "P":
                    System.out.println(bookRepository);
                    break;
                case "S":
                    manageSortShelf(scanner);
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (!input.equals("Q"));
    }

    private void manageCheckout(Scanner scanner) {
        try {
            System.out.println("Please enter the book's ISBN:");
            int isbn = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter your user ID:");
            int userId = Integer.parseInt(scanner.nextLine());

            securityCheck.checkOutBook(isbn, userId);
            System.out.println("Book successfully checked out.");
        } catch (InvalidISBNException | InvalidUserIDException | BookNotFoundException | BookAlreadyCheckedOutException e) {
            System.out.println(e.getMessage());
        }
    }

    private void manageAddNewBook(Scanner scanner) {
        try {
            System.out.println("Please enter the book's ISBN:");
            int isbn = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter the book's name:");
            String name = scanner.nextLine();

            System.out.println("Please enter the book's author:");
            String author = scanner.nextLine();

            System.out.println("Please enter the book's genre:");
            String genre = scanner.nextLine();

            System.out.println("Please enter the book's year:");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter the book's condition (1-10):");
            int condition = Integer.parseInt(scanner.nextLine());
        }  catch (NumberFormatException e) {
    System.out.println("Invalid input format! Please enter a valid integer.");
    manageAddNewBook(scanner);
}
}