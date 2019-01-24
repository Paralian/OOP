public class Card implements Comparable<Card> {
    private String name;
    private String color;
    private int yearOfRelease;

    private final static String WHITE = "White";
    private final static String BLUE = "Blue";
    private final static String BLACK = "Black";
    private final static String RED = "Red";
    private final static String GREEN = "Green";

    Card(String name, String color, int yearOfRelease) {
        this.name = name;
        this.color = color;
        this.yearOfRelease = yearOfRelease;
    }

    private String getName() {
        return name;
    }

    private String getColor() {
        return color;
    }

    private int getYearOfRelease() {
        return yearOfRelease;
    }

    static String getWHITE() {
        return WHITE;
    }

    static String getBLUE() {
        return BLUE;
    }

    static String getBLACK() {
        return BLACK;
    }

    static String getGREEN() {
        return GREEN;
    }

    static String getRED() {
        return RED;
    }

    @Override
    public int compareTo(Card card) {
        if (compareYearOfRelease(card) == 0){
            if (compareColor(card) == 0) {
                return compareName(card);
            } else {
                return compareColor(card);
            }
        } else {
            return compareYearOfRelease(card);
        }
    }

    private int compareYearOfRelease(Card card) {
        return Integer.compare(this.yearOfRelease, card.yearOfRelease);
    }

    private int compareColor(Card card) {
        if (this.color.equals(card.color)) {
            return 0;
        }
        if (card.color.equals(Card.GREEN) || (card.color.equals(Card.RED) && !this.color.equals(Card.GREEN)) || (card.color.equals(Card.BLACK) && (this.color.equals(Card.WHITE) || this.color.equals(Card.BLUE))) || (card.color.equals(Card.BLUE)) && this.color.equals(Card.WHITE)) {
            return -1;
        } else {
            return 1;
        }
    }

    private int compareName(Card card) {
        return this.name.compareTo(card.name);
    }

    void printInfo() {
        System.out.println(this.getColor() + " " + this.getName() + " " + this.getYearOfRelease());
    }
}
