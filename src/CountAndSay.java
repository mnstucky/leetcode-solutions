package leetCode;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                sb.append(count + s.charAt(i));
            else if (s.charAt(i + 1) == s.charAt(i)) count++;
            else {
                sb.append(count + s.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
    }
}
