package ValidateBinarySearchTree;

import util.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        flag = isValid(root);
        return flag;

    }
    private static boolean isValid(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left==null&&root.right!=null){
            boolean temp  = findMin(root.right)>root.val;
            return isValid(root.right)&&temp;
        }
        if(root.left!=null&&root.right==null){
            boolean temp = (findMax(root.left)<root.val);
            return isValid(root.left)&&temp;
        }
        if(root.left!=null&&root.left!=null){
            boolean temp = (findMin(root.right)>root.val)&&(findMax(root.left)<root.val);
            return isValid(root.left)&&isValid(root.right)&&temp;
        }
        return true;
    }

    private static int findMax(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return root.val;
        }
        if(root.left!=null&&root.right==null){
            int max = Math.max(findMax(root.left),root.val);
            return max;
        }
        if(root.left==null&&root.right!=null){
            int max = Math.max(findMax(root.right),root.val);
            return max;
        }
        if (root.left != null && root.right != null) {
            int max = Math.max(findMax(root.right),Math.max(findMax(root.left),root.val));
            return max;
        }
        return 0;
    }
    private static int findMin(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return root.val;
        }
        if(root.left!=null&&root.right==null){
            int min = Math.min(findMin(root.left),root.val);
            return min;
        }
        if(root.left==null&&root.right!=null){
            int min = Math.min(findMin(root.right),root.val);
            return min;
        }
        if (root.left != null && root.right != null) {
            int min = Math.min(findMin(root.right),Math.min(findMin(root.left),root.val));
            return min;
        }
        return 0;
    }


}
