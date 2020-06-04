package leetCode;

// https://leetcode.com/problems/length-of-last-word/

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.equals("")) return 0;
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0 && s.charAt(i) == ' ') continue;
            if (s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
