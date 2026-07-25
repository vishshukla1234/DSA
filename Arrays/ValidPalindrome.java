public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb);
        int left = 0;
        int right = sb.length()-1;
        while( left <= right) {
            if(sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
