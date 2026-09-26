import javax.swing.tree.TreeNode;
import java.util.*;

public class ZigzagTraversal {
    public static List<List<Integer>> res = new ArrayList<>();;
    public static List<List<Integer>> ZigzagLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return res;
        }
        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(q.right);
                }
                temp.add(curr.val);
            }
            res.add(temp);
        }

        for(int i = 0; i < res.size(); i+=2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
