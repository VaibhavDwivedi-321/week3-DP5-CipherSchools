class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int distributeCoins(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) return 0;
        int L = dfs(node.left, res), R = dfs(node.right, res);
        res[0] += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
    
        Solution solution = new Solution();
        int result = solution.distributeCoins(root);
    
        System.out.println("Result: " + result);
    }
    
}
