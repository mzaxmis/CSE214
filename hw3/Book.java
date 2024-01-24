/**
 * Write a description of class Book here.
 *
 * @author (Misbah)
 * @version (04/23)
 */
public class Book {
    public enum Condition {
        NEW,
        LIKE_NEW,
        GOOD,
        ACCEPTABLE,
        POOR
    }
    // member variables
    private String name;
    private String author;
    private int ISBN;
    private String genre;
    private Condition bookCondition;
    private int yearPublished;
    private boolean checkedOut;
    private int checkOutUserID;
    private Date checkOutDate;
    private Date returnDate;
    private Book nextBook;

    // constructors
    public Book() {
        // default constructor
    }

    public Book(String name, String author, int ISBN, String genre, Condition bookCondition, int yearPublished) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.bookCondition = bookCondition;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
        this.checkOutUserID = -1;
        this.checkOutDate = null;
        this.returnDate = null;
        this.nextBook = null;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public Condition getBookCondition() {
        return bookCondition;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public int getCheckOutUserID() {
        return checkOutUserID;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Book getNextBook() {
        return nextBook;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setBookCondition(Condition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void setCheckOutUserID(int checkOutUserID) {
        this.checkOutUserID = checkOutUserID;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setNextBook(Book nextBook) {
        this.nextBook = nextBook;
    }

    // toString method
    public String toString() {
        String bookString = String.format("%-20s%-20s%-15d%-20s%-15s%-15d%-15b%-15d", name, author, ISBN, genre, bookCondition, yearPublished, checkedOut, checkOutUserID);
        if (checkedOut) {
            bookString += String.format("%-20s%-20s", checkOutDate, returnDate);
        } else {
            bookString += String.format("%-20s%-20s", "N/A", "N/A");
        }
        return bookString;
    }
        public static class InvalidISBNException extends Exception {
    public InvalidISBNException(String errorMessage) {
        super(errorMessage);
    }
}

public static class InvalidReturnDateException extends Exception {
    public InvalidReturnDateException(String errorMessage) {
        super(errorMessage);
    }
}

public static class BookNotCheckedOutException extends Exception {
    public BookNotCheckedOutException(String errorMessage) {
        super(errorMessage);
    }
}

public static class BookCheckedOutBySomeoneElseException extends Exception {
    public BookCheckedOutBySomeoneElseException(String errorMessage) {
        super(errorMessage);
    }
}

public static class InvalidUserIDException extends Exception {
    public InvalidUserIDException(String errorMessage) {
        super(errorMessage);
    }
}
 public static class BookAlreadyExistsException extends Exception {
        public BookAlreadyExistsException(String message) {
            super(message);
        }
    }
     public static class BookDoesNotExistException extends Exception {
    public BookDoesNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
public static class InvalidSortCriteriaException extends Exception {
        public InvalidSortCriteriaException(String message) {
            super(message);
        }
    }
}
