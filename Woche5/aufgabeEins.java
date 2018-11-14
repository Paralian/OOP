package Woche5;

import java.util.Arrays;

public class aufgabeEins {
    static float getMinimum(float[] numbers) {
        float result = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (result >= numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
    
    static float getMaximum(float[] numbers) {
        if (numbers.length <= 2) {
            return (numbers[0] >= numbers[numbers.length - 1] ? numbers[0] : numbers[numbers.length - 1]);
        } else return (getMaximum(Arrays.copyOfRange(numbers, 0, numbers.length - 1)));
    }
    
    static float calculateAverage(float[] numbers) {
        float result = 0;
        for (float number :
                numbers) {
            result = result + (number / numbers.length);
        }
        return result;
        
    }
    
    static boolean isSorted(float[] numbers, boolean ascending) {
        int i = 0;
        boolean result = false;
        if (ascending) {
            while (i <= numbers.length - 2) {
                result = (numbers[i] <= numbers[i + 1]);
                if (!result ) break;
                i++;
            }
        } else {
            while (i <= numbers.length - 2) {
                result = (numbers[i] >= numbers[i + 1]);
                if (!result) break;
                i++;
            }
        }
        return result;
}
    
    public static void main(String[] args) {
        float[] num1sorted = {1, 2, 3, 4, 5};
        float[] num1unsorted = {1, 2, 3, 5, 4};
        float[] num2sorted = {6, 4, 3, 2, -1};
        float[] num2unsorted = {7, 3, 4, 0};
        float[] ident = {0, 0, 0, 0, 0, 0};
        
        System.out.println(getMinimum(num1sorted));                         // 1.0
        System.out.println(getMaximum(num2sorted));                         // 6.0
        System.out.println(calculateAverage(num2sorted));                   // 2.8
        System.out.println(isSorted(num1sorted, true));            // true
        System.out.println(isSorted(num2sorted, false));           // true
        System.out.println(isSorted(num1unsorted, true));          // false
        System.out.println(isSorted(num2unsorted, false));         // false
        System.out.println(isSorted(ident, true));                 // true
        System.out.println(isSorted(ident, false));                // true
    }
}
