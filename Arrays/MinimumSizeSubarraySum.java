public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        while(j<n) {
            sum+=nums[j];
            j++;
            while(sum>=target) {
                int len = j-i;
                minLen = Math.min(minLen, len);
                sum -= nums[i];
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE ? 0: minLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, arr));
    }
}
