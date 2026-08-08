import java.util.HashMap;

public class RansomeNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aab";

        System.out.println(canConstruct(s, t));
    }
}
