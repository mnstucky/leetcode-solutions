package leetCode;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    newDigits[1] = 0;
                    System.arraycopy(digits, 1, newDigits, 2, digits.length - 1);
                    return newDigits;
                }
                digits[i - 1] += 1;
                digits[i] = 0;
            }
        }
        return digits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{8})));
    }
}
