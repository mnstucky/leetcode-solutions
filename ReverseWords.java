// https://leetcode.com/problems/reverse-words-in-a-string/

// Runtime: 2 ms, faster than 99.35% of Java online submissions for Reverse Words in a String.
// Memory Usage: 39.6 MB, less than 31.37% of Java online submissions for Reverse Words in a String.

public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        int end;
        while (i >= 0) {
            // Find end of next word in s, ignoring spaces
            while (true) {
                if (s.charAt(i) == ' ' && i > 0) {
                    i--;
                } else {
                    end = i;
                    break;
                }
            }
            // If i is at 0, the start of s is empty spaces, so break
            if (i == 0 && s.charAt(i) == ' ') {
                break;
            }
            // Move i to the start of the word
            while (true) {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    break;
                }
                i--;
            }
            // Don't add a space at the start of result
            if (result.length() > 0) {
                result.append(' ');
            }
            // Add the found word to the end of result
            result.append(s.substring(i, end + 1));
            // Move i off the current word and onto the next space
            i--;
        }
        return result.toString();
    }
}