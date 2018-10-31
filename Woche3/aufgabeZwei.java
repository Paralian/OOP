package Woche3;

import static java.lang.Math.*;

public class aufgabeZwei {
    
    // approx Pi ~= P0=sqrt(12); Pn=sqrt(12)*((-1.0/3.0)**n)/(2n+1)+Pn-1
    static final double PI0 = sqrt(12);
    static double piN;
    static double third = (-1.0 / 3.0);
    
    /**
     * piIterative berechnet die Zahl pi in n Iterationen
     *
     * @param n Genauigkeit der Berechnung
     * @return liefert die Zahl pi
     */
    
    
    static double piIterative(int n) {
        piN = 0;
        int i = 0;
        while (i <= n) {
            piN = piN + PI0 * (pow(third, i) / (2 * i + 1));
            ++i;
        }
        return piN;
    }
    
    static double piRecursive(int n) {
        if (n == 0) {
            return PI0;
        }
        piN = PI0 * (pow(third, n)) / (2 * n + 1) + piRecursive(n - 1);
        return piN;
    }
    
    public static void main(String[] args) {
        int n = 20;
        int m = 20;
        double a = piIterative(n);
        double b = piRecursive(m);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
    }
}
    
