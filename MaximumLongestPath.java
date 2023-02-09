class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaximumLongestPath {
    private int maxLength = 0;

    public int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxLength = Math.max(maxLength, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    
        MaximumLongestPath solution = new MaximumLongestPath();
        System.out.println(solution.longestPath(root));
    }


}
