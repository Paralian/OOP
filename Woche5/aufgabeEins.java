package Woche5;

import static java.util.Arrays.copyOf;

public class aufgabeEins {
    
    /**
     * finds the minimal value in a float array
     *
     * @param numbers this array
     * @return the minimum of this array
     */
    static float getMinimum(float[] numbers) {
        float result = numbers[0];
        for (int i = 1; i < numbers.length - 1; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
    
    /**
     * finds the maximal value in a float array
     *
     * @param numbers this array
     * @return maximum of this array
     */
    static float getMaximum(float[] numbers) {
        float maximum = (numbers[0] > numbers[numbers.length - 1] ? numbers[0] : numbers[numbers.length - 1]);
        ;
        while (numbers.length > 2) {
            numbers = copyOf(numbers, numbers.length - 1);
            maximum = (getMaximum(numbers) > maximum ? getMaximum(numbers) : maximum);
            return maximum;
        }
        return maximum;
    }
    
    /**
     * calculates the average value of a float array
     *
     * @param numbers this array
     * @return arithmetic average of this array
     */
    
    static float calculateAverage(float[] numbers) {
        float sum = 0;
        for (float number : numbers) {
            sum = sum + number;
        }
        return sum / numbers.length;
        
    }
    
    /**
     * checks if this float array is sorted, ascending or descending
     *
     * @param numbers   this array
     * @param ascending if TRUE, checks for ascending order of sorting; descending if FALSE
     * @return TRUE if array is sorted in a set order, FALSE otherwise
     */
    static boolean isSorted(float[] numbers, boolean ascending) {
        int i = 0;
        boolean result = false;
        if (ascending) {
            while (i < numbers.length - 1) {
                result = (numbers[i] <= numbers[i + 1]);
                if (!result) break;
                i++;
            }
        } else {
            while (i < numbers.length - 1) {
                result = (numbers[i] >= numbers[i + 1]);
                if (!result) break;
                i++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        float[] num1sorted = {1, 2, 3, 4, 5};
        float[] num1unsorted = {1, 2, 20, 5, 4};
        float[] num2sorted = {6, 4, 3, 2, -1};
        float[] num2unsorted = {7, 3, 4, 0};
        float[] ident = {0, 0, 0, 0, 0, 0};
        
        System.out.println(getMinimum(num1sorted));                         // 1.0
        System.out.println(getMaximum(num1sorted));                         // 5.0
        System.out.println(getMaximum(num2sorted));                         // 6.0
        System.out.println(getMaximum(num1unsorted));                       // 20.0
        System.out.println(getMaximum(ident));                              // 0.0
        System.out.println(calculateAverage(num2sorted));                   // 2.8
        System.out.println(isSorted(num1sorted, true));            // true
        System.out.println(isSorted(num2sorted, false));           // true
        System.out.println(isSorted(num1unsorted, true));          // false
        System.out.println(isSorted(num2unsorted, false));         // false
        System.out.println(isSorted(ident, true));                 // true
        System.out.println(isSorted(ident, false));                // true
    }
}
