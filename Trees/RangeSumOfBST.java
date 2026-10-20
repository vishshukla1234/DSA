
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class RangeSumOfBST {

    public int rangeSum(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val > low) {
            ans += rangeSum(root.left, low, high);
        }
        if (root.val < high) {
            ans += rangeSum(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        System.out.println(rangeSumOfBST.rangeSum(root, 7, 15));
    }
}
