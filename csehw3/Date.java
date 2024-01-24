
/**
 * Write a description of class Date here.
 *
 * @author (Misbah)
 * @version (04/23)
 */
public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * Default constructor for the Date class. Sets the date to January 1, 1900.
     */
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1900;
    }

    /**
     * Constructor for the Date class. Allows the user to specify the day, month, and year.
     *
     * @param day   The day of the month.
     * @param month The month (1-12).
     * @param year  The year.
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Compares two Date objects to determine their chronological order.
     *
     * @param d1 The first Date object.
     * @param d2 The second Date object.
     * @return 0 if d1 is equal to d2, -1 if d1 is before d2, and 1 if d1 is after d2.
     */
    public static int compare(Date d1, Date d2) {
        if (d1.year < d2.year) {
            return -1;
        } else if (d1.year > d2.year) {
            return 1;
        } else if (d1.month < d2.month) {
            return -1;
        } else if (d1.month > d2.month) {
            return 1;
        } else if (d1.day < d2.day) {
            return -1;
        } else if (d1.day > d2.day) {
            return 1;
        } else {
            return 0;
        }
    }
}

