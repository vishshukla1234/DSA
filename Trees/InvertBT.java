public class InvertBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{"
                + "val=" + val
                + ", left=" + left
                + ", right=" + right
                + '}';
        }
    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, 
            new TreeNode(2, null, null),
            new TreeNode(7, null, null)
        );
        System.out.println(invertBinaryTree(root).toString());
    }
}