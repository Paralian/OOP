<<<<<<< HEAD
package Woche3;
public class aufgabeZwei {
    public static double pStart ;//root of 12
    public static int n; //step
    public static double pNext;
//TODO: debug
    static double piIterative(int n) {
        while (n >= 0){
            pStart = Math.sqrt(12);
            pNext = Math.sqrt(12)*((Math.pow((-1.0/3.0),n))/(2*n+1)) + pStart;
            pStart = pNext;
            n--;
        }
        return pNext;
    }

    static double piRecursive(int n) {
        pStart = Math.sqrt(12);
        pNext = Math.sqrt(12)*((Math.pow((-1.0/3.0),n))/(2*n+1)) + pStart;
        pStart = pNext;
        n--;
        if (n >= 0) piRecursive(n);
        return pNext;
    }

    public static void main(String[] args) {
        System.out.println(piIterative(0));
        System.out.println(piIterative(3));
        System.out.println(piRecursive(3));
        System.out.println(piRecursive(6));
=======
public class aufgabeZwei {
    /**
     * This method approximates the value of PI with a while-loop after n steps.
     * @param n is the number of steps allowed.
     * @return an approximation of PI.
     */
    static double piIterative(int n) {
        double result = Math.sqrt(12.0);
        while (n > 0) {
            result = Math.sqrt(12.0) * Math.pow((-1.0 / 3.0), n) / (2.0 * n + 1.0) + result;
            n--;
        }
        return result;
    }

    /**
     * This method approximates the value of PI recursively after n steps.
     * @param n is the number steps allowed.
     * @return an approximation of PI.
     */
    static double piRecursive(int n) {
        double result = Math.sqrt(12.0);
        if (n > 0) {
            result = Math.sqrt(12.0) * Math.pow((-1.0 / 3.0), n) / (2.0 * n + 1.0) + piRecursive(n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result of piIterative with n = 5 is " + piIterative( 5));
        System.out.println("result of piIterative with n = 15 is " + piIterative( 15));
        System.out.println("result of piRecursive with n = 5 is " + piRecursive( 5));
        System.out.println("result of piRecursive with n = 15 is " + piRecursive( 15));
>>>>>>> KIEN
    }
}
