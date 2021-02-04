// https://leetcode.com/problems/integer-to-roman/

// Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman.
// Memory Usage: 38.9 MB, less than 51.61% of Java online submissions for Integer to Roman.

class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                roman.append('M');
                num -= 1000;
            } else if (num >= 900) {
                roman.append('C');
                roman.append('M');
                num -= 900;
            } else if (num >= 500) {
                roman.append('D');
                num -= 500;
            } else if (num >= 400) {
                roman.append('C');
                roman.append('D');
                num -= 400;
            } else if (num >= 100) {
                roman.append('C');
                num -= 100;
            } else if (num >= 90) {
                roman.append('X');
                roman.append('C');
                num -= 90;
            } else if (num >= 50) {
                roman.append('L');
                num -= 50;
            } else if (num >= 40) {
                roman.append('X');
                roman.append('L');
                num -= 40;
            } else if (num >= 10) {
                roman.append('X');
                num -= 10;
            } else if (num >= 9) {
                roman.append('I');
                roman.append('X');
                num -= 9;
            } else if (num >= 5) {
                roman.append('V');
                num -= 5;
            } else if (num >= 4) {
                roman.append('I');
                roman.append('V');
                num -= 4;
            } else {
                roman.append('I');
                num -= 1;
            }
        }
        return roman.toString();
    }
}