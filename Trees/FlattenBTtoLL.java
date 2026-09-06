public class FlattenBTtoLL {

    static TreeNode temp = null;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = temp;
        temp = root;
    }

    public static void main(String[] args) {
       TreeNode root = new TreeNode(
        new TreeNode(
        new TreeNode(null, null, 3),
        new TreeNode(null, null, 4),
        2
        ),
        new TreeNode(null, null, 5),
        1
        );

        flatten(root);

        TreeNode curr = root;
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.right;
        }
        System.out.println("null");
    }
}
