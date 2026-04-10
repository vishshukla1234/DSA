public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int dist = right - left;
            int H = Math.min(height[left], height[right]);
            int currwater = dist*H;
            maxwater = Math.max(currwater, maxwater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxwater;
    }
}
