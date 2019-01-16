public interface Number {
    /**
     * @return the value of the instance in int
     */
    int toIntValue();

    /**
     * assigns a new value to the instance
     * @param value is the new value to be assigned to the instance
     */
    void fromIntValue(int value);

    /**
     * adds a number to the value of instance
     * @param number is the number to be added
     */
    default void add(Number number) {
        fromIntValue(number.toIntValue() + this.toIntValue());
    }

    /**
     * subtracts a number from the value of instance
     * @param number is the number to be subtracted
     */
    default void  subtract(Number number) {
        fromIntValue(this.toIntValue() - number.toIntValue());
    }

    /**
     * multiplies the value of instance with a number
     * @param number is the multiplying number
     */
    default void multiply(Number number) {
        fromIntValue(this.toIntValue() * number.toIntValue());
    }

    /**
     * divides the value of instance by a number
     * @param number is the dividing number
     */
    default void divide(Number number) {
        fromIntValue(this.toIntValue() / number.toIntValue());
    }
}
