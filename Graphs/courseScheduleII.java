import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course); 
            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for(int neighbour: graph.get(curr)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
            }
        return res.size() == numCourses?ans:new int[0];
    }
}
