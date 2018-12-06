import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void add() {
        RomanNumber test = new RomanNumber("XX");
        test.add(new RomanNumber("V"));
        assertEquals("XXV", test.romanNumber);
        test.add(new RomanNumber("C"));
        assertEquals("CXXV", test.romanNumber);
    }

    @Test
    void subtract() {
        RomanNumber test = new RomanNumber("XX");
        test.subtract(new RomanNumber("V"));
        assertEquals("XV", test.romanNumber);
        test.subtract(new RomanNumber("IIII"));
        assertEquals("XI", test.romanNumber);
    }

    @Test
    void multiply() {
        RomanNumber test = new RomanNumber("XX");
        test.multiply(new RomanNumber("V"));
        assertEquals("C", test.romanNumber);
        test.multiply(new RomanNumber("X"));
        assertEquals("M", test.romanNumber);
    }

    @Test
    void divide() {
        RomanNumber test = new RomanNumber("XX");
        test.divide(new RomanNumber("V"));
        assertEquals("IIII", test.romanNumber);
        test.divide(new RomanNumber("IIII"));
        assertEquals("I", test.romanNumber);
    }
}