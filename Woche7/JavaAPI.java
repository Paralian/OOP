import de.uni.marburg.oop.notifications.NotificationCenter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JavaAPI {
    /**
     * simulates a coin toss
     * @return either "Kopf" or "Zahl"
     */
    public static String tossCoin() {
        double face = Math.random();
        System.out.println(face);
        return (face >= 0.5) ? "Kopf" : "Zahl";
    }

    /**
     * gets the time difference between two given dates
     * @param a is the first date
     * @param b is the second date
     * @return the time difference between these dates in hours
     */
    public static int getTimeDifference(Calendar a, Calendar b) {
        long time1 = a.getTimeInMillis();
        long time2 = b.getTimeInMillis();
        long time;
        if (time1 > time2) {
            time = time1 - time2;
        } else {
            time = time2 - time1;
        }
        return (int) (time / (1000 * 60 * 60));
    }

    /**
     * calculates the installment of a credit from the following information:
     * @param interest is the rate of interest
     * @param payments is the number of payment
     * @param loan is the loan in Cent
     * @return the installment calculated in Cent
     */
    public static int emi(double interest, int payments, int loan) {
        return (int) (loan * (interest * Math.pow(1 + interest, payments)) / (Math.pow(1 + interest, payments) - 1));
    }

    public static void main(String[] args) {
        NotificationCenter.showMessage("Return values of methods", tossCoin() + ", " + getTimeDifference(new GregorianCalendar(2018, 12, 16), new GregorianCalendar(2018, 12, 15)) + ", " + emi(0.07, 5, 50000));
    }
}
