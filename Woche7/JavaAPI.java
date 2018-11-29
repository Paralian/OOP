import de.uni.marburg.oop.notifications.NotificationCenter;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class JavaAPI {
    /**
     * simulates a coin toss
     * @return either "Kopf" or "Zahl"
     */
    public static String tossCoin() {
        double face = Math.random();
        return (face >= 0.5) ? "Kopf" : "Zahl";
    }

    /**
     * gets the time difference between two given dates
     * @param a is the first date
     * @param b is the second date
     * @return the time difference between these dates in hours
     */
    public static int getTimeDifference(Calendar a, Calendar b) {
        long hoursBetween = ChronoUnit.HOURS.between(a.toInstant(),b.toInstant());
        return (int) hoursBetween;
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
        NotificationCenter.showMessage("Return values of methods", tossCoin() + ", " + getTimeDifference(Calendar.getInstance(), Calendar.getInstance()) + ", " + emi(0.07, 5, 50000));
    }
}
