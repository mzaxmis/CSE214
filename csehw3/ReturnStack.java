import java.util.Date;
import java.util.EmptyStackException;
/**
 * Write a description of class ReturnStack here.
 *
 * @author (Misbah)
 * @version (04/23)
 */

public class ReturnStack {
    private ReturnLog topLog;

    public ReturnStack() {
        topLog = null;
    }

    public boolean pushLog(int returnISBN, int returnUserID, Date returnDate)
    throws Book.InvalidISBNException, Book.InvalidReturnDateException,
    Book.BookNotCheckedOutException, Book.BookCheckedOutBySomeoneElseException,
    Book.InvalidUserIDException {
        // Check if ISBN is valid
        if (!isValidISBN(returnISBN)) {
            throw new Book.InvalidISBNException("Invalid ISBN!");
        }

        // Check if return date is valid
        if (!isValidReturnDate(returnDate)) {
            throw new Book.InvalidReturnDateException("Invalid return date!");
        }
        // Convert the ISBN number to a string
        String returnISBNString = convertIntToString(returnISBN);
        // Check if book is checked out

        if (!isBookCheckedOut(returnISBNString)) {
            throw new Book.BookNotCheckedOutException("Book not checked out!");
        }

        // Check if book was checked out by this user
        if (!isBookCheckedOutByUser(returnISBNString, returnUserID)) {
            throw new Book.BookCheckedOutBySomeoneElseException("Book checked out by someone else!");
        }

        // Check if user ID is valid
        if (!isValidUserID(returnUserID)) {
            throw new Book.InvalidUserIDException("Invalid user ID!");
        }

        // Create new ReturnLog
        ReturnLog newLog = new ReturnLog(returnISBN, returnUserID, returnDate);

        // Add new ReturnLog to top of stack
        newLog.setNextLog(topLog);
        topLog = newLog;

        // Determine if book is late or on-time
        boolean isLate = returnDate.after(returnDate);

        return !isLate;
    }

    public ReturnLog popLog() throws EmptyStackException {
        if (topLog == null) {
            throw new EmptyStackException();
        }

        ReturnLog log = topLog;
        topLog = topLog.getNextLog();
        return log;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ISBN\tUser ID\tReturn Date\n");
        sb.append("---\t------\t-----------\n");

        ReturnLog currentLog = topLog;
        while (currentLog != null) {
            sb.append(currentLog.getISBN()).append("\t")
            .append(currentLog.getUserID()).append("\t")
            .append(currentLog.getReturnDate()).append("\n");
            currentLog = currentLog.getNextLog();
        }

        return sb.toString();
    }

    // Helper methods for checking validity of ISBN, user ID, return date, etc.
    private boolean isValidISBN(int ISBN) {
        // Implementation details for validating ISBN go here
    }

    public boolean isValidReturnDate(Date returnDate) {
        // Check if returnDate is null
        if (returnDate == null) {
            return false;
        }

        // Check if returnDate is in the past
        if (returnDate.before(new Date())) {
            return false;
        }
        // Return true if all checks pass
        return true;
    }

    public boolean isBookCheckedOut(String isbn) {
        // Check if the ISBN is null or empty
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }
        // Return false if the book is not checked out
        return false;
    }

    public boolean isBookCheckedOutByUser(String isbn, int userId) {
        // Check if the ISBN or user ID is null or empty
        if (isbn == null || isbn.isEmpty() || userId <= 0) {
            return false;
        }
        // Return false if the book is not checked out by the specified user
        return false;
    }

    public boolean isValidUserID(int userId) {
        // Check if the user ID is valid
        // This is just an example, so let's assume that a valid user ID is any positive integer
        return userId > 0;
    }

    public String convertIntToString(int number) {
        return String.valueOf(number);
    }
}
