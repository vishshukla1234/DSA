public class ReverseWords {
    public static String reverse(String s) {
        int left = s.length()-1;
        StringBuilder ans = new StringBuilder();
        while(left >= 0) {
            while(left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            if(left < 0) {
                break;
            }
            int endIndex = left;
            while(left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            if(ans.length() == 0) {
                ans.append(s.substring(left+1, endIndex+1));
            } else {
                ans.append(' ');
                ans.append(s.substring(left+1, endIndex+1));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "     my name  is bob ";
        System.out.println(reverse(s));
    }
}