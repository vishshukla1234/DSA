import java.util.*;

import javax.swing.tree.TreeNode;

public class ConstructBT {

    public static int search(int[] inorder, int target) {
        for(int i = 0; i < inorder.length; i++) {
            if(target == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int preIdx, int left, int right) {
        if(preIdx>inorder.length-1 || left>right) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        int inIdx = search(root.val, inorder);
        root.left = helper(preorder, inorder, preIdx, left, inIdx-1);
        root.right = helper(preorder, inorder, preIdx, inIdx+1, inorder.length-1);
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
    }
}
