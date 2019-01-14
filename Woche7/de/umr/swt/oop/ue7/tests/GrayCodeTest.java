import de.umr.swt.oop.ue7.graycode.GrayCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrayCodeTest {

    @Test
    void findCode() {
        GrayCode grayCode4 = new GrayCode(4);
        assertEquals(3, grayCode4.findCode("0010"));
        assertEquals(5, grayCode4.findCode("0111"));
        assertEquals(9, grayCode4.findCode("1101"));
        assertEquals(14, grayCode4.findCode("1001"));
    }

    @Test
    void testConstructor() {
        assertArrayEquals(new String[]{"0000", "0001", "0011", "0010", "0110", "0111", "0101", "0100", "1100", "1101", "1111", "1110", "1010", "1011", "1001", "1000"}, new GrayCode(4).getGrayCode());
        assertArrayEquals(new String[]{"0", "1"}, new GrayCode(1).getGrayCode());
    }
}