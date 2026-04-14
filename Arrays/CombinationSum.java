import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;

        helper(candidates, ans, temp, target, n-1);
        return ans;
    }

    public void helper(int[] candidates, List<List<Integer>> ans, List<Integer> temp, int target, int idx) {
        

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (idx < 0) return;

        if(candidates[idx] <= target) {
            temp.add(candidates[idx]);
            helper(candidates, ans, temp, target - candidates[idx], idx);
            temp.remove(temp.size()-1);
        } 
        helper(candidates, ans, temp, target, idx-1);
        
    }
}
