public class RomanNumber implements Number {
    String romanNumber;

    /**
     * Constructor
     * @param romanNumber is the value to be initialised
     */
    public RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    /**
     * @return the value of the instance in int
     */
    @Override
    public int toIntValue() {
        int result = 0;
        if (romanNumber.equals("")) {
            return result;
        }
        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i) == 'I') {
                result += 1;
            }
            if (romanNumber.charAt(i) == 'V') {
                result += 5;
            }
            if (romanNumber.charAt(i) == 'X') {
                result += 10;
            }
            if (romanNumber.charAt(i) == 'L') {
                result += 50;
            }
            if (romanNumber.charAt(i) == 'C') {
                result += 100;
            }
            if (romanNumber.charAt(i) == 'D') {
                result += 500;
            }
            if (romanNumber.charAt(i) == 'M') {
                result += 1000;
            }
        }
        return result;
    }

    /**
     * assigns a new value to the instance
     * @param value is the new value to be assigned to the instance
     */
    @Override
    public void fromIntValue(int value) {
        String romanValue = "";
        while (value >= 1000) {
            romanValue += "M";
            value -= 1000;        
        }
        while (value >= 500) {
            romanValue += "D";
            value -= 500;
        }
        while (value >= 100) {
            romanValue += "C";
            value -= 100;
        }
        while (value >= 50) {
            romanValue += "L";
            value -= 50;
        }
        while (value >= 10) {
            romanValue += "X";
            value -= 10;
        }
        while (value >= 5) {
            romanValue += "V";
            value -= 5;
        }
        while (value >= 1) {
            romanValue += "I";
            value -= 1;
        }
        this.romanNumber = romanValue;
    }
}
