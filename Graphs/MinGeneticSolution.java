import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinGeneticSolution {
    class Pair {
        String gene;
        int mutations;

        Pair(String gene, int mutations) {
            this.gene = gene;
            this.mutations = mutations;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(endGene)) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startGene,0));
        char[] arr = new char[] {'A', 'C', 'G', 'T'};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int mutations = p.mutations;
            String gene = p.gene;

            if(endGene.equals(gene)) {
                return mutations;
            }
           StringBuilder sb = new StringBuilder(gene);
           for(int i = 0; i < gene.length(); i++) {
                char temp = sb.charAt(i);
                for(char c: arr) {
                    if(c != temp) {
                        sb.replace(i,i+1,c+"");
                        if(set.contains(sb.toString())) {
                            q.offer(new Pair(sb.toString(), mutations+1));
                            set.remove(sb.toString());
                        }
                    }
                }
                sb.replace(i,i+1,temp+"");
           }
        }
        return -1;
    }
}
