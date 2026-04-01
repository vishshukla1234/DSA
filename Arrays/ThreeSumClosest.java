import java.util.Arrays;

public class ThreeSumClosest {
        public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int minD = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];

        for(int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;

            while(left < right) {
                int sum = nums[i]+nums[left]+nums[right];

                if(sum < target) {
                    left++;
                } else if(sum == target){
                    return target;
                } else {
                    right--;
                }

                int currMinDiff = Math.abs(sum - target);
                if(currMinDiff < minD) {
                    minD = currMinDiff;
                    result = sum;
                }
            }
        }
        return result;
    }
}
