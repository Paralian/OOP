package Woche3;
public class aufgabeZwei {
    public static double pStart ;//root of 12
    public static int n; //step
    public static double pNext;

    static double piIterative(int n){
        while (n != 0){
            pStart = Math.sqrt(12);
            pNext = Math.sqrt(12)*(((-1/3)^n)/(2*n+1)) + pStart;
            pStart = pNext;
            n--;
        }
        return pNext;
    }

    static double piRecursive(int n){
        pStart = Math.sqrt(12);
        pNext = Math.sqrt(12)*(((-1/3)^n)/(2*n+1)) + pStart;
        pStart = pNext;
        n--;
        if (n >= 0) piRecursive(n);
        return pNext;
    }

    public static void main(String[] args) {
        //TODO: test with n between 0 and 20
        System.out.println(piIterative(5));
        System.out.println(piRecursive(5));
    }
}
