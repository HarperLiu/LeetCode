package flatten;

import util.TreeNode;

public class MainClass {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(6);
        Solution s = new Solution();
        s.flatten(t);
    }
}
