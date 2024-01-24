import java.util.Date;
/**
 * Write a description of class BookRepository here.
 *
 * @author (Misbah)
 * @version (04/23)
 */


public class BookRepository {
    private final Shelf[] shelves;

    // Constructor
    public BookRepository() {
        shelves = new Shelf[10];
        for (int i = 0; i < shelves.length; i++) {
            shelves[i] = new Shelf();
        }
    }

    // Adds a book to the correct shelf based on its name
    public void addBook(int addISBN, String addName, String addAuthor, String addGenre, Book.Condition addCondition)
    throws Book.InvalidISBNException, Book.BookAlreadyExistsException {
        Book newBook = new Book(addISBN, addName, addAuthor, addGenre, addCondition);
        int shelfIndex = addName.toLowerCase().charAt(0) - 'a';
        shelves[shelfIndex].addBook(newBook);
    }

    // Removes a book by its ISBN
    public void removeBook(int removeISBN) throws Book.InvalidISBNException {
        boolean removed = false;
        for (Shelf shelf : shelves) {
            if (shelf.removeBook(removeISBN)) {
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new Book.InvalidISBNException("Book with ISBN " + removeISBN + " not found in repository");
        }
    }

    // Checks out a book by its ISBN, user ID, and date
    public void checkOutBook(int checkedOutISBN, int checkOutUserID, Date checkOutDate)
    throws Book.InvalidISBNException, Book.InvalidUserIDException, Book.BookCheckedOutBySomeoneElseException {
        boolean checkedOut = false;
        for (Shelf shelf : shelves) {
            if (shelf.checkOutBook(checkedOutISBN, checkOutUserID, checkOutDate)) {
                checkedOut = true;
                break;
            }
        }
        if (!checkedOut) {
            throw new Book.InvalidISBNException("Book with ISBN " + checkedOutISBN + " not found in repository");
        }
    }

    // Checks in a book by its ISBN, user ID, and date
    public void checkInBook(int checkedInISBN, int checkInUserID, Date checkInDate)
    throws Book.InvalidISBNException, Book.InvalidReturnDateException {
        boolean checkedIn = false;
        for (Shelf shelf : shelves) {
            if (shelf.checkInBook(checkedInISBN, checkInUserID, checkInDate)) {
                checkedIn = true;
                break;
            }
        }
        if (!checkedIn) {
            throw new Book.InvalidISBNException("Book with ISBN " + checkedInISBN + " not found in repository");
        }
    }

    // Sorts a specific shelf by some criteria
    public void sortShelf(int shelfInd, String sortCriteria) throws InvalidSortCriteriaException {
        try {
            Shelf.SortCriteria criteria = Shelf.SortCriteria.valueOf(sortCriteria.toUpperCase());
            shelves[shelfInd].sortBooks(criteria);
        } catch (IllegalArgumentException e) {
            throw new Book.InvalidSortCriteriaException("Invalid sort criteria: " + sortCriteria);
        }
    }
}