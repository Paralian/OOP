
import org.junit.Assert;

import java.util.Arrays;
public class CardTest {
    public void compareToTest() {
        Card card1  = new Card("The World", 20180201, Card.WHITE);
        Card card2  = new Card("The Fool", 20180202, Card.RED);
        Card card3  = new Card("The Chariot", 20180910, Card.WHITE);
        Card card4  = new Card("The Lovers", 20181011, Card.GREEN);
        Card card5  = new Card("Death", 20180903, Card.BLACK);
        Card card6  = new Card("The Devil", 20180323, Card.BLACK);
        Card card7  = new Card("The Tower", 20140201, Card.BLUE);
        Card card8  = new Card("The Star", 20120201, Card.WHITE);
        Card card9  = new Card("The Moon", 20131212, Card.BLUE);
        Card card10 = new Card("Judgement", 20120201, Card.RED);

        Card[] cards = new Card[10];
        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;
        cards[6] = card7;
        cards[7] = card8;
        cards[8] = card9;
        cards[9] = card10;

        Arrays.sort(cards);
        //TODO: fix cancerous JUnit path
        System.out.println(cards[0]);
        Assert.assertEquals(cards[0], card5);
    }

    public static void main(String[] args) {
        Card card1  = new Card("The World", 20180201, Card.WHITE);
        Card card2  = new Card("The Fool", 20180202, Card.RED);
        Card card3  = new Card("The Chariot", 20180910, Card.WHITE);
        Card card4  = new Card("The Lovers", 20181011, Card.GREEN);
        Card card5  = new Card("Death", 20180903, Card.BLACK);
        Card card6  = new Card("The Devil", 20180323, Card.BLACK);
        Card card7  = new Card("The Tower", 20140201, Card.BLUE);
        Card card8  = new Card("The Star", 20120201, Card.WHITE);
        Card card9  = new Card("The Moon", 20131212, Card.BLUE);
        Card card10 = new Card("Judgement", 20120201, Card.RED);
Assert.assertEquals(1,1);
        Card[] cards = new Card[10];
        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;
        cards[6] = card7;
        cards[7] = card8;
        cards[8] = card9;
        cards[9] = card10;

        //TODO: fix cancerous JUnit path
        for (int i = 0; i < cards.length; i++) {
            System.out.println("Card " + i + ": " + cards[i].getName() +" "+ cards[i]);
            System.out.println("        " + cards[i].getDate() + " with color " + cards[i].getColor());
        }
        Arrays.sort(cards);
        System.out.println("AFTER SORTING:");
        for (int i = 0; i < cards.length; i++) {
            System.out.println("Card " + i + ": " + cards[i].getName() +" "+ cards[i]);
            System.out.println("        " + cards[i].getDate() + " with color " + cards[i].getColor());
        }
        Assert.assertEquals(20120201, cards[0].getDate());
    }
}