public class JumpGame1 {
    public static boolean canJump(int[] nums) {
        int maxInd = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxInd) return false;
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,0};
        System.out.println(canJump(nums));
    }
}
