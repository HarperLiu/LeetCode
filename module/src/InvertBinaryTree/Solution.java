package InvertBinaryTree;

import util.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){}
        else if (root.left==null&&root.right==null){}
        else if (root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        }
        else if (root.left==null&&root.right!=null){
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        }
        else if(root.left!=null&&root.right!=null){
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
