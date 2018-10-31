package Woche2;

public class aufgabeEins {
    static int predecessor(int a) {
        return a - 1;
    }
    
    static double square(double b) {
        return b * b;
    }
    
    static boolean isEqual(String s, String t) {
        return s.equals(t);
    }
    static void echo(String s) {
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        int pa = 43;
        int pb = 101011;
        double sa = 12.0;
        double sb = 0.5;
        String ie = "";
        String ig = "test this string";
        String ic = "test this String";
        String ih = "test this string";
        
        System.out.println(predecessor(pa));    // 42
        System.out.println(predecessor(pb));    // 101010
        System.out.println(square(sa));         // 144.0
        System.out.println(square(sb));         // 0.25
        System.out.println(isEqual(ie, ie));    //true
        System.out.println(isEqual(ie, ig));    //false
        System.out.println(isEqual(ig, ie));    //false
        System.out.println(isEqual(ig, ic));    //false
        System.out.println(isEqual(ig, ih));    //true
        echo(ic);
        echo(ie);
    }
}
