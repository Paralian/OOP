import java.util.Arrays;

public class arrayIteration {
    /**
     * gets the smallest element from an array of number with for-loop
     * @param numbers is the given array of numbers
     * @return the smallest number found
     */
    static float getMinimum(float[] numbers) {
        float result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (result >= numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

    /**
     * gets the greatest element from an array of numbers with foreach-loop
     * @param numbers is the given array of numbers
     * @return the greatest number found
     */
    static float getMaximum(float[] numbers) {
        float result = numbers[0];
        for (float number : numbers) {
            if (result < number) {
                result = number;
            }
        }
        return result;
    }

    /**
     * calculates the average value of elements in an array of numbers recursively
     * @param numbers is the given array of numbers
     * @return the calculated average value
     */
    static float calculateAverage(float[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            float[] temp = Arrays.copyOfRange(numbers, 0, numbers.length - 1);
            return (calculateAverage(temp) * temp.length + numbers[numbers.length - 1]) / numbers.length;
        }
    }

    /**
     * checks if the numbers in an array are sorted in ascending or descending order with while-loop
     * @param numbers is the given array of numbers
     * @param ascending is the order in question, true if ascending, false if descending
     * @return true if the numbers are sorted correctly in ascending or descending order, else false
     */
    static boolean isSorted(float[] numbers, boolean ascending) {
        int i = 0;
        if (ascending) {
            while (i < numbers.length - 1) {
                if (numbers[i] > numbers[i + 1]) {
                    return false;
                }
                i++;
            }
        } else {
            while (i < numbers.length - 1) {
                if (numbers[i] < numbers[i + 1]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        float[] numbers = {1.0f, 1.25f, 2.5f, 8.75f, 5.5f};
        System.out.println("Das Minimum ist " + getMinimum(numbers));
        System.out.println("Das Maximum ist " + getMaximum(numbers));
        System.out.println("Der Durchschnittswert ist " + calculateAverage(numbers));
        System.out.println("Ist das Array sortiert? " + isSorted(numbers,true));
    }
}
