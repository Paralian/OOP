package Woche3;

public class aufgabeDrei {
    static boolean isBetween(int val, int b1, int b2) {
        int lo = b1;
        int hi = b2;                        // set boundaries as they should normally be (from low to high)
        if (b1 > b2) {                      // check if boundaries ordered incorrectly
            hi = b1;                        // swap boundaries
            lo = b2;
        }
        return (lo <= val && val <= hi);    // compare lower bound with value AND compare higher bound with value
    }
    
    public static void main(String[] args) {
        System.out.println(isBetween(2, 1, 3));
        System.out.println(isBetween(2, 3, 1));
        System.out.println(isBetween(5, 5, 5));
        System.out.println(isBetween(6, 2, 4));
    }
}
