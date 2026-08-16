import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        int i = 1;
        while(i < intervals.length) {
            int currEnd = intervals[i][1];
            int currStart = intervals[i][0];
            if(currStart <= prevEnd) {
                prevEnd = Math.max(prevEnd, currEnd);
            } else {
                res.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
            i++;
        }
        res.add(new int[]{prevStart, prevEnd});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
