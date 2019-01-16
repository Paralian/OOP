import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationTest {

    @Test
    void replace() {
        assertEquals("The very hungry cthulhupillar", StringOperation.replace("The very hungry caterpillar", "ater", "thulhu"));
        assertEquals("The Adventures of Tom Lawyer", StringOperation.replace("The Adventures of Tom Sawyer", "S", "L"));
        assertEquals("Petty Woman", StringOperation.replace("Pretty Woman", "r", ""));
        assertEquals("True Grit", StringOperation.replace("True Grit", "R", ""));
        assertEquals("acbc", StringOperation.replace("abc", "b", "cb"));
    }

    @Test
    void isPalindrome() {
        assertTrue(StringOperation.isPalindrome("o"));
        assertTrue(StringOperation.isPalindrome("Ebbe"));
        assertFalse(StringOperation.isPalindrome("Array"));
        assertTrue(StringOperation.isPalindrome("Al lets Della call Ed 'Stella'."));
    }

    @Test
    void isSorted() {
        assertTrue(StringOperation.isSorted("bijoux", true));
        assertFalse(StringOperation.isSorted("Racecar", true));
        assertFalse(StringOperation.isSorted("cbaZYX", false));
        assertTrue(StringOperation.isSorted("Spoonfeed", false));
    }
}