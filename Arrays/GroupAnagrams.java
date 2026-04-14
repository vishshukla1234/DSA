import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public String getFreqString(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder freqString = new StringBuilder("");
        char c = 'a';

        for (int i : freq) {
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> freqMap = new HashMap<>();

        for (String str : strs) {
            String freqString = getFreqString(str);

            if (freqMap.containsKey(freqString)) {
                freqMap.get(freqString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqMap.put(freqString, strList);
            }
        }
        return new ArrayList<>(freqMap.values());
    }
}
