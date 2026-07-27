import java.util.Arrays;

public class TwoSumII {
    public static int[] helper(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int[] result = new int[2];

        while(l < r) {     
            if(nums[l]+nums[r]<target) {
                l++;
            } else if(nums[l]+nums[r]>target) {
                r--;
            } else {
                result[0] = l+1;
                result[1] = r+1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int t = 9;
        System.out.println(Arrays.toString(helper(nums, t)));
    }
}
