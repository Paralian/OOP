public class Card implements Comparable<Card>{

    private String name;
    private int date;

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    private String color;

    static final String WHITE = "white";
    static final String BLUE  = "blue";
    static final String BLACK = "black";
    static final String RED   = "red";
    static final String GREEN = "green";

    public Card(String name, int date, String color) {
        this.name = name;
        this.date = date;
        this.color = color;
    }
    //not sure about these getters
    //public static String getWHITE() { return WHITE; }
    //public static String getBLUE() { return BLUE; }
    //public static String getBLACK() { return BLACK; }
    //public static String getRED() { return RED; }
    //public static String getGREEN() { return GREEN; }

    /**
     * Rules:
     * Cards are sorted by date first
     * if date is the same then the order is white > blue > black > red > green
     * if both date and color are the same then the order is sorted by name
     * @return
     */
    @Override
    public int compareTo(Card card) {
        int comDate = Integer.compare(date, card.date);
        //TODO: color compare proofcheck
        int comCol = CharSequence.compare(color, card.color);
        int comName = CharSequence.compare(name, card.name);
        if (comDate < 0) {
            return -1;
        } else if (comDate > 0) {
            return 1;
        } else { //comDate == 0
            if (comCol > 0) {
               return 1;
            } else if (comCol < 0) {
                return -1;
            } else { //comCol == 0
                if (comName > 0) return 1;
                else if (comName < 0) return -1;
            }
        }
        return 0;
    }

    //not sure about this getter
    /*
   public String getColor() {
   return color;
   }
   */
}
