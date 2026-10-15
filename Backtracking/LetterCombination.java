package DSA.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    List<String> res = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>(8);
    public void backtrack(int i, String currStr, String digits) {
        if(currStr.length()==digits.length()) {
            res.add(currStr);
            return;
        }
        String str = map.get(digits.charAt(i));
        for(char c: str.toCharArray()) {
            backtrack(i+1, currStr+c, digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(!digits.isEmpty() || digits!=null) {
            backtrack(0,"",digits);
        }
        return res;
    }
}
