import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void add() {
        Number test = new RomanNumber("XX");
        test.add(new RomanNumber("V"));
        assertEquals("XXV", ((RomanNumber) test).getRomanNumber());
        test.add(new RomanNumber("C"));
        assertEquals("CXXV", ((RomanNumber) test).getRomanNumber());
    }

    @Test
    void subtract() {
        Number test = new RomanNumber("XX");
        test.subtract(new RomanNumber("V"));
        assertEquals("XV", ((RomanNumber) test).getRomanNumber());
        test.subtract(new RomanNumber("IIII"));
        assertEquals("XI", ((RomanNumber) test).getRomanNumber());
    }

    @Test
    void multiply() {
        Number test = new RomanNumber("XX");
        test.multiply(new RomanNumber("V"));
        assertEquals("C", ((RomanNumber) test).getRomanNumber());
        test.multiply(new RomanNumber("X"));
        assertEquals("M", ((RomanNumber) test).getRomanNumber());
    }

    @Test
    void divide() {
        Number test = new RomanNumber("XX");
        test.divide(new RomanNumber("V"));
        assertEquals("IIII", ((RomanNumber) test).getRomanNumber());
        test.divide(new RomanNumber("IIII"));
        assertEquals("I", ((RomanNumber) test).getRomanNumber());
    }
}