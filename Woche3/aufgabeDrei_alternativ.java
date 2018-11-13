public class aufgabeDrei_alternativ {
    static boolean isBetween(int value, int lower, int upper) {
        return (value <= upper) && (lower <= value);
    }

    static int postage(int length, int width, int height, int weight) {
        if (isBetween(length, 140, 235) && isBetween(width, 90, 125)) {
            if (isBetween(height, 0, 2) && isBetween(weight, 0, 15)) {
                return 45;
            }
            if (isBetween(height, 0, 5) && isBetween(weight, 0, 20)) {
                return 70;
            }
        }
        if (isBetween(length, 100, 235) && isBetween(width, 70, 125) && isBetween(height, 0, 10) && isBetween(weight, 0, 50)) {
            return 85;
        }
        if (isBetween(length, 100, 353) && isBetween(width, 70, 250)) {
            if (isBetween(height, 0, 20) && isBetween(weight, 0, 500)) {
                return 145;
            }
            if (isBetween(height, 0, 50) && isBetween(weight, 0, 1000)) {
                return 260;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Portokosten für Postkarte:" + postage(150, 100, 1, 10));
        System.out.println("Portokosten für Standard:" + postage(150, 100, 3, 18));
        System.out.println("Portokosten für Kompakt:" + postage(150, 100, 6, 30));
        System.out.println("Portokosten für Groß:" + postage(150, 100, 15, 100));
        System.out.println("Portokosten für Maxi:" + postage(150, 100, 20, 800));
        System.out.println("Nicht identifizierbar:" + postage(150, 100, 1, 1100));
    }
}
