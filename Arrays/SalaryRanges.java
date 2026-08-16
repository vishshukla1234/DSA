import java.util.*;

public class SalaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        if(nums.length == 0) return ans;
        int i = 1;
        int start = nums[0];
        while(i < nums.length) {
            if(nums[i] != nums[i-1]+1) {
                if(start == nums[i-1]) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + nums[i-1]);
                }
                start = nums[i];
            }
            i++;
        }

        if(start == nums[nums.length-1]) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(start + "->" + nums[nums.length-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
}
