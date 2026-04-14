public class FirstAndLast {
        public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int first = firstOccurence(nums,low,high, target);
        int last = lastOccurence( nums, low, high, target);
        return new int[] {first, last};
    }
    public int firstOccurence(int nums[], int low, int high, int target) {
        int first = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                first = mid;
                high = mid-1;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return first;
    }

    public int lastOccurence(int[] nums, int low, int high, int target) {
        int last = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                last = mid;
                low = mid+1;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return last;
    }
}
