package Woche3;

public class aufgabeEins {
    static double meine_berechnung(final double basis, final int exponent) {
        double result = 1;
        if (exponent < 0) {
            int anzahl = exponent * -1;
            while (anzahl > 0) {
                result = result / basis;
                anzahl -= 1;
            }
            return result;
        } else {
            int Count = exponent;
            while (Count > 0) {
                result = result * basis;
                Count -= 1;
            }
            return result;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(meine_berechnung(5.0, 2));
    }
}
