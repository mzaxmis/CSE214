import java.util.Objects;
/**
 * Write a description of class Shelf here.
 *
 * @author (Misbah)
 * @version (04/23)
 */

public class Shelf {
    public enum SortCriteria {
    NAME,
    AUTHOR,
    YEAR,
    ISBN
}
    private Book headBook;
    private Book tailBook;
    private int length;
    private SortCriteria shelfSortCriteria;

    public Shelf() {
        headBook = null;
        tailBook = null;
        length = 0;
        shelfSortCriteria = SortCriteria.NAME; // default sorting criteria
    }

    public void addBook(Book addedBook) throws Book.BookAlreadyExistsException {
        if (headBook == null) { // empty list
            headBook = addedBook;
            tailBook = addedBook;
            length++;
            return;
        }

        Book currentBook = headBook;
        Book previousBook = null;

        while (currentBook != null) {
            if (addedBook.getISBN() == currentBook.getISBN()) {
                throw new Book.BookAlreadyExistsException("A book with the same ISBN already exists.");
            } else if (shelfSortCriteria == SortCriteria.NAME && addedBook.getName().compareTo(currentBook.getName()) < 0
            || shelfSortCriteria == SortCriteria.AUTHOR && addedBook.getAuthor().compareTo(currentBook.getAuthor()) < 0
            || shelfSortCriteria == SortCriteria.YEAR && addedBook.getYearPublished() < currentBook.getYearPublished()) {
                addedBook.setNextBook(currentBook);

                if (previousBook == null) { // insert at head
                    headBook = addedBook;
                } else { // insert at middle
                    previousBook.setNextBook(addedBook);
                }

                length++;
                return;
            }

            previousBook = currentBook;
            currentBook = currentBook.getNextBook();
        }

        // insert at tail
        previousBook.setNextBook(addedBook);
        tailBook = addedBook;
        length++;
    }

    public Book removeBook(int removedISBN) throws Book.BookDoesNotExistException {
        if (headBook == null) { // empty list
            throw new Book.BookDoesNotExistException("The shelf is empty.");
        }

        Book currentBook = headBook;
        Book previousBook = null;

        while (currentBook != null) {
            if (removedISBN == currentBook.getISBN()) {
                if (previousBook == null) { // remove at head
                    headBook = currentBook.getNextBook();
                } else if (currentBook.getNextBook() == null) { // remove at tail
                    previousBook.setNextBook(null);
                    tailBook = previousBook;
                } else { // remove at middle
                    previousBook.setNextBook(currentBook.getNextBook());
                }

                length--;
                return currentBook;
            }

            previousBook = currentBook;
            currentBook = currentBook.getNextBook();
        }

        throw new Book.BookDoesNotExistException("A book with the same ISBN does not exist.");
    }

    public void sort(SortCriteria sortCriteria) {
        shelfSortCriteria = sortCriteria;

        if (headBook == null) { // empty list
            return;
        }

        Book currentBook = headBook.getNextBook();
        Book previousBook = headBook;
        previousBook.setNextBook(null);

        while (currentBook != null) {
            Book nextBook = currentBook.getNextBook();

            while (previousBook != null) {
                if (shelfSortCriteria == SortCriteria.NAME && currentBook.getName().compareTo(previousBook.getName()) < 0
                || shelfSortCriteria == SortCriteria.AUTHOR && currentBook.getAuthor().compareTo(previousBook.getAuthor()) < 0
                || shelfSortCriteria == SortCriteria.YEAR && currentBook.getYearPublished() < previousBook.getYearPublished()) {                if (previousBook == headBook) { // insert

                    }
                }
            }
        }
    }
}

