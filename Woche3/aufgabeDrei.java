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
    
    /**
     * postage() rechnet Portokosten aus gegebenen Maßen des Pakets aus
     *
     * @param length Länge des Pakets
     * @param width  Breite des Pakets
     * @param height Höhe des Pakets
     * @param weight Gewicht
     * @return Preis in Cent
     */
    
    
    static int postage(int length, int width, int height, int weight) {
        int price = 0;                                                           //  Preis (Cent)
        
        //  m[i][const]: unterschiedliche Preisklassen
        //  m[const][j]: price, weight(lo, hi), height(lo, hi), width(lo, hi), length(lo, hi)
        final int[][] M = {{45, 0, 2, 0, 15, 90, 125, 140, 235},                       //  Postkarte
                {70, 0, 5, 0, 20, 90, 125, 140, 235},                            //  Standard
                {85, 0, 10, 0, 50, 70, 125, 100, 235},                           //  Kompakt
                {145, 0, 20, 0, 500, 70, 250, 100, 353},                         //  Gross
                {260, 0, 50, 0, 1000, 70, 250, 100, 353}};                       //  Maxi
        
        /*  Parameter des Pakets (Höhe, Gewicht, Breite, Länge), gespeichert als Array */
        int[] p = {height, weight, width, length};
        
        /*  vergleiche Paketabmessungen mit den Vorgaben */
        int pass = 0;                                                            // interner Zähler von passenden Parametern
        
        spalte:
        for (int i = 0; i < M.length; i++) {                                     // iteriere m[][] Zeilenweise
            zeile:
            for (int j = 1; j < M[i].length - 1; j = j + 2) {                    // iteriere m[][] Spaltenweise(2x)
                if (isBetween(p[((j + 1) / 2) - 1], M[i][j], M[i][j + 1])) {     // verknüpfe Pointer von p[] mit j aus m[][]
                    pass++;                                                      // und prüfe, ob Betrag P[x] im Intervall M
                    if (pass >= 4) {                                             // falls ja, inkrementiere PASS und prüfe ob alle Abmessungen gestimmt haben
                        price = M[i][0];
                        break spalte;                                            // wenn alles stimmt, nehme Preis
                    }                                                            // aus der ersten Spalte in M
                } else {                                                         // sonst beim ersten nehme nächste Zeile aus m[][]
                    pass = 0;                                                    // und setze PASS zurück
                    break zeile;
                }
            }
        }
        
        return price;
    }
    
    public static void main(String[] args) {
        int length = 141;
        int width = 92;
        int height = 31;
        int weight = 415;
        System.out.println(postage(length, width, height, weight));
        
    }
}
