import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    @Test
    void toIntValue() {
        assertEquals(35, new RomanNumber("XXXV").toIntValue());
        assertEquals(1666, new RomanNumber("MDCLXVI").toIntValue());
        assertEquals(1984, new RomanNumber("MDCCCCLXXXIIII").toIntValue());
    }

    @Test
    void fromIntValue() {
        RomanNumber testSubject = new RomanNumber("");
        testSubject.fromIntValue(35);
        assertEquals("XXXV", testSubject.romanNumber);
        testSubject.fromIntValue(1666);
        assertEquals("MDCLXVI", testSubject.romanNumber);
        testSubject.fromIntValue(1984);
        assertEquals("MDCCCCLXXXIIII", testSubject.romanNumber);
    }
}