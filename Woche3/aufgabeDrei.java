package Woche3;

public class aufgabeDrei {
    static boolean isBetween(int value, int lo, int hi) {
        if (lo <= hi) {                                     // prüfe ob Grenzen OK
            return (lo <= value && value <= hi);                // vergleiche Untergrenze mit Wert & Wert mit Obergrenze
        } else {
            return (hi <= value && value <= lo);                // falls Grenzen nicht OK, swap Grenzen & vergleiche mit Wert
        }

    }

    /**
     * rechnet Portokosten aus gegebenen Maßen des Pakets aus
     *      mittels verschachtelter for-Schleife,
     *      eines 2D-Arrays mit Preisbedingungen
     *      und eines Arrays mit Paketparametern
     *
     * @param length Länge des Pakets
     * @param width  Breite des Pakets
     * @param height Höhe des Pakets
     * @param weight Gewicht
     * @return Preis in Cent
     */


    static int postage(int length, int width, int height, int weight) {
        int price = 0;                                                           //  Preis (Cent)

        /*  M[i][const]: unterschiedliche Preisklassen
        *   M[const][j]: price, height(lo, hi), weight(lo, hi), width(lo, hi), length(lo, hi)
        */
        final int[][] M = {{45, 0, 2, 0, 15, 90, 125, 140, 235},                 //  Postkarte
                {70, 0, 5, 0, 20, 90, 125, 140, 235},                            //  Standard
                {85, 0, 10, 0, 50, 70, 125, 100, 235},                           //  Kompakt
                {145, 0, 20, 0, 500, 70, 250, 100, 353},                         //  Gross
                {260, 0, 50, 0, 1000, 70, 250, 100, 353}};                       //  Maxi

        /*  Parameter des Pakets (Höhe, Gewicht, Breite, Länge), gespeichert als Array */
        int[] p = {height, weight, width, length};

        /*  vergleiche Paketabmessungen mit den Vorgaben */
        int pass = 0;                                                            // interner Zähler von passenden Parametern

        check:
        for (int i = 0; i < M.length; i++) {                                     // iteriere M[][] Zeilenweise
            line:
            for (int j = 1; j < M[i].length - 1; j = j + 2) {                    // iteriere M[][] innerhalb der Zeile, Spaltenweise(2x)
                if (isBetween(p[((j + 1) / 2) - 1], M[i][j], M[i][j + 1])) {     // verknüpfe Pointer von p[] mit j aus m[][]
                    pass++;                                                      // und prüfe, ob Betrag P[x] im Intervall M
                    if (pass >= 4) {                                             // falls ja, inkrementiere PASS
                        price = M[i][0];                                         // und prüfe ob alle Abmessungen gestimmt haben
                        break check;                                             // wenn alles stimmt, nehme Preis
                    }                                                            // aus der ersten Spalte in M
                } else {                                                         // sonst beim ersten nehme nächste Zeile aus m[][]
                    pass = 0;                                                    // und setze PASS zurück
                    break line;
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
