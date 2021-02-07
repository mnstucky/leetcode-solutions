public class PalindromeNumber {
	
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int length = (int) (Math.log10(x) + 1);
        long leftModulo = (long) Math.pow(10, length);
        int rightModulo = 10;
        while (leftModulo > 10) {
        	if (x % leftModulo / (leftModulo / 10) != x % rightModulo / (rightModulo / 10))
                return false;
        	leftModulo /= 10;
        	rightModulo *= 10;
        }
        return true;
    }
}