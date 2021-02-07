// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (prefix.length() == 0) return prefix.toString();
            prefix.setLength(strs[i].length());
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    prefix.setLength(j);
                    break;
                }
            }
        }        
        return prefix.toString();
    }
}
