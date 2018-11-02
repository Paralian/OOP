public class aufgabeDrei {
<<<<<<< HEAD
    public static boolean isBetween(int value, int lower, int upper) {
        if (value <= upper && value >= lower) {
            return true;
        } else return false;
    }
    //isBetween(length,140,235))
    public static int postage(int length, int width, int height, int weight) {
        if (isBetween(length,140,235)) {
            if (isBetween(width,90,125)){
                if (isBetween(height,0,2)){
                    if (isBetween(weight,0,15))
                        return 45;
                }
                if (isBetween(height,0,5)){
                    if (isBetween(weight,0,20))
                        return 70;
                }
            }
        }
        if (isBetween(length,100,235)){
            if (isBetween(width,70,125)) {
                if (isBetween(height,0,10)){
                    if (isBetween(weight,0,50))
                        return 85;
                }
            }
        }
        else if (isBetween(length,100,353)) {//gross + maxi
            if (isBetween(width,70,250)) {
                if (isBetween(height,0,20)){//gross
                    if (isBetween(weight,0,500))
                        return 145;
                }
                if (isBetween(height,0,50)){//maxi
                    if (isBetween(weight,0,1000))
                        return 260;
                }
=======
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
>>>>>>> KIEN
            }
        }
        return 0;
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        System.out.println(postage(180,100,2,2));//stufe1
        System.out.println(postage(180,100,4,17));//stufe2
        System.out.println(postage(110,80,2,2));//stufe3
        System.out.println(postage(300,80,2,2));//stufe4
        System.out.println(postage(300,80,2,800));//stufe5
=======
        System.out.println("Portokosten für Postkarte:" + postage(150, 100, 1, 10));
        System.out.println("Portokosten für Standard:" + postage(150, 100, 3, 18));
        System.out.println("Portokosten für Kompakt:" + postage(150, 100, 6, 30));
        System.out.println("Portokosten für Groß:" + postage(150, 100, 15, 100));
        System.out.println("Portokosten für Maxi:" + postage(150, 100, 20, 800));
        System.out.println("Nicht identifizierbar:" + postage(150, 100, 1, 1100));
>>>>>>> KIEN
    }
}
