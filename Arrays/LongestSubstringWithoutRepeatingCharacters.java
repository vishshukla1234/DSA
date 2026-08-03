import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
