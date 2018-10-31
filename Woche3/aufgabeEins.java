package Woche3;

public class aufgabeEins {
    static double meineBerechnung(final double BASIS, final int EXPONENT) {
        double result = 1;
        if (EXPONENT < 0) {
            int anzahl = EXPONENT * -1;
            while (anzahl > 0) {
                result = result / BASIS;
                anzahl -= 1;
            }
            return result;
        } else {
            int count = EXPONENT;
            while (count > 0) {
                result = result * BASIS;
                count -= 1;
            }
            return result;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(meineBerechnung(5.0, 2));
    }
}
