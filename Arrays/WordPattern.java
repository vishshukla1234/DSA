import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        for(int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            } else {
                String ch = map.get(pattern.charAt(i));
                if(!ch.equals(words[i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";

        System.out.println(wordPattern(pattern, s));
    }
}
