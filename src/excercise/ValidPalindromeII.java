package excercise;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb = sb.deleteCharAt(i);
            if (isValidPalindrome(sb.toString())) {
                return true;
            } else {
                sb.insert(i, c);
            }
        }
        return isValidPalindrome(sb.toString());
    }

    private static Boolean isValidPalindrome(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;

        Boolean isValid = true;

        while (i < j) {
            if (cs[i++] != cs[j--]) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

}
