import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public double dfs(String dividend, String divisor, double prod, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map) {
        double ret = -1.0;
        visited.add(dividend);
        if(map.get(dividend).containsKey(divisor)) {
            ret = map.get(dividend).get(divisor) * prod;
        } else {
            for(String neighbour: map.get(dividend).keySet()) {
                if(!visited.contains(neighbour)) {
                    ret = dfs(neighbour, divisor, prod*map.get(dividend).get(neighbour),visited,map);
                    if(ret != -1) {
                        break;
                    }
                }
            }
        }
        visited.remove(dividend);
        return ret;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double res = values[i];
            if(!map.containsKey(dividend)) {
                map.put(dividend, new HashMap<String, Double>());
            }
            if(!map.containsKey(divisor)) {
                map.put(divisor, new HashMap<String, Double>());
            }
            map.get(dividend).put(divisor,res);
            map.get(divisor).put(dividend,1/res);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if(!map.containsKey(dividend) || !map.containsKey(dividend)) {
                res[i] = -1.0;
            } else if(dividend.equals(divisor)) {
                res[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(dividend, divisor, 1, visited, map);
            }
        }
        return res;
    }
}