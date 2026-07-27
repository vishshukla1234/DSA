public class IsSubsequence {
    public static boolean helper(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < t.length() && j < s.length()) {
            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        String s = "abx";
        String t = "skdjdabdejdoihc";
        System.out.println(helper(s, t));
    }
}
