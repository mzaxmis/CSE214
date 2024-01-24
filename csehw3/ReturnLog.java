import java.util.Date;
/**
 * Write a description of class ReturnLog here.
 *
 * @author (Misbah)
 * @version (04/2)
 */


public class ReturnLog {
    private int ISBN;
    private int userID;
    private Date returnDate;
    private ReturnLog nextLog;

    public ReturnLog() {
        ISBN = 0;
        userID = 0;
        returnDate = null;
        nextLog = null;
    }

    public ReturnLog(int returnISBN, int returnUserID, Date date) {
        ISBN = returnISBN;
        String returnISBNString = String.valueOf(returnISBN);
        userID = returnUserID;
        returnDate = date;
        nextLog = null;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getUserID() {
        return userID;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setNextLog(ReturnLog log) {
        nextLog = log;
    }

    public ReturnLog getNextLog() {
        return nextLog;
    }
}
