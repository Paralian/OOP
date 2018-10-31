package Woche3;
public class aufgabeEins {
    double meine_berechnung(double basis, int exponent) {
        double result = 1;
        if (exponent < 0) {
            int anzahl = exponent * -1;
            while (anzahl > 0) {
                result = result / basis;
                anzahl -= 1;
            }
            return result;
        } else {
            int count = exponent;
            while (count > 0) {
                result = result * basis;
                count -= 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        aufgabeEins auf1 = new aufgabeEins();
        double test = auf1.meine_berechnung(2,4);
        System.out.println(test);
    }
}
