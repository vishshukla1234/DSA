import java.util.HashSet;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int l = 0;
        int r = 0;
        while(r < nums.length) {
            while(r - l > k) {
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
