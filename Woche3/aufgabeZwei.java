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
    }
}
