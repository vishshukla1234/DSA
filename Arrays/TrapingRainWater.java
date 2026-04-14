public class TrapingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int l_wall[] = new int[n];
        int r_wall[] = new int[n];
        l_wall[0] = height[0];
        for (int i = 1; i < n; i++) {
            l_wall[i] = Math.max(l_wall[i - 1], height[i]);
        }
        r_wall[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r_wall[i] = Math.max(r_wall[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(l_wall[i], r_wall[i]) - height[i];
        }
        return ans;
    }
}
