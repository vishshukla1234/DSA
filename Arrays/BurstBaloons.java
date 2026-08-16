import java.util.Arrays;

public class BurstBaloons {
        public static int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int curEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > curEnd) {
                arrows++;
                curEnd = Math.max(curEnd, points[i][1]);
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2}, {3,4}, {5,6}, {7,8}};
        System.out.println(findMinArrowShots(points));
    }
}
