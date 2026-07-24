public class LongestCommenPrefix {
    public static String prefix(String[] s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s[0].length(); i++) {
            Character ch = s[0].charAt(i);
            for(int j = 1; j < s.length; j++) {
                if(i >= s[j].length() || ch != s[j].charAt(i)) {
                    return ans.toString();
                }
            }
            ans.append(ch);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String[] s = {"flow", "flight", "flower"};
        System.out.println(prefix(s));
    }
}
