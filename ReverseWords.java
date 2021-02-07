import java.util.Arrays;

// https://leetcode.com/problems/reverse-words-in-a-string/

// Runtime: 5 ms, faster than 70.62% of Java online submissions for Reverse Words in a String.
// Memory Usage: 38.9 MB, less than 91.67% of Java online submissions for Reverse Words in a String.

public class ReverseWords {

    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        String[] result = new String[sArr.length];
        int j = 0;
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i].length() != 0) {
                result[j] = sArr[i].strip();
                j++;
            }
        }
        return String.join(" ", Arrays.copyOfRange(result, 0, j)).strip();
    }

    public static void main(String[] args) {
        ReverseWords tester = new ReverseWords();
        System.out.println(tester.reverseWords("  hello world  "));
    }
}