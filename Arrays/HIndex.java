public class HIndex {
    public static boolean isValid(int mid, int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= mid) {
                count++;
            }
        }
        return count >= mid;
    }

    public static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length;
        int ans = -1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (isValid(mid, arr)) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,1};
        System.out.println(binarySearch(arr));
    }
}
