import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void compareTo() {
        Card card1 = new Card("Pegasus", Card.getWHITE(), 2001);
        Card card2 = new Card("Panther", Card.getBLUE(), 2002);
        Card card3 = new Card("Eagle", Card.getBLACK(), 2003);
        Card card4 = new Card("Carbuncle", Card.getRED(), 2004);
        Card card5 = new Card("Tortoise", Card.getGREEN(), 2005);
        Card card6 = new Card("Wolf", Card.getBLACK(), 2006);
        Card card7 = new Card("Wolf", Card.getBLACK(), 2002);
        Card card8 = new Card("Monkey", Card.getRED(), 2001);
        Card card9 = new Card("Cat", Card.getGREEN(), 2004);
        Card card10 = new Card("Viper", Card.getBLUE(), 2007);
        Card card11 = new Card("Viper", Card.getWHITE(), 2007);
        Card[] cardArray = {card11, card1, card2, card3, card4, card5, card6, card7, card2, card8, card9, card10, card11};
        Arrays.sort(cardArray);
        for (Card card : cardArray) {
            card.printInfo();
        }
    }
}