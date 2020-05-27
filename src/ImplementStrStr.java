package leetCode;

// https://leetcode.com/problems/implement-strstr/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
