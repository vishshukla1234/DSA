public class ElementGreaterThanPreviousAverage {
    public static int countElemenstGreaterThanPreviousAverage(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i-1];
            if(nums[i] > sum/i) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {43, 33, 55, 12, 3};
        System.out.println(countElemenstGreaterThanPreviousAverage(nums));
    }
}
