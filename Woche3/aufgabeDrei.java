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
    
    static int postage(int length, int width, int height, int weight) {
        int price = 0;          //  init variable in cent
        
        if (isBetween(length, 140, 235)
                && isBetween(width, 90, 125)) {
            if (isBetween(height, 0, 2)
                    && isBetween(weight, 0, 15)) {
                price = 45;                                         //  Postkarte
            } else if (isBetween(height, 0, 5)
                    && isBetween(weight, 0, 20)) {
                price = 70;                                         //  Standard
            }
        } else if (isBetween(length, 100, 235)
                && isBetween(width, 70, 125)
                && isBetween(height, 0, 10)
                && isBetween(weight, 0, 50)) {
            price = 85;                                             //  Kompakt
        } else if (isBetween(length, 100, 353)
                && isBetween(width, 70, 250)) {
            if (isBetween(height, 0, 20)
                    && isBetween(weight, 0, 500)) {
                price = 145;                                        //  Gross
            } else if (isBetween(height, 0, 50)
                    && isBetween(weight, 0, 1000)) {
                price = 260;                                        //  Maxi
            }
        }
        
        return price;
    }
    
    public static void main(String[] args) {
        int length = 144;
        int width = 90;
        int height = 13;
        int weight = 420;
        System.out.println(postage(length, width, height, weight));
    }
}
