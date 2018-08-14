package BalacedBinaryTree;

import util.TreeNode;

/**
 * Created by HarperLiu on 2018.5.28
 * 前序遍历二叉树，对每一个节点，判断它的左右子树的高度差是否大于1，是则把全局变量isBalsnced改为false
 * 前序遍历二叉树一次递归，计算树的高度一次递归
 */

class Solution {
    Boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root!=null){
            preorder(root);
        }
        return isBalanced;
    }
    public void preorder (TreeNode root){
        if(root==null){}
        else if(root.left==null&&root.right==null){}
        else if(root.left!=null&&root.right==null){
            boolean flag = depth(root.left)<=1;
            if(flag==false){
                isBalanced = flag;
            }
            preorder(root.left);
        }
        else if(root.left==null&&root.right!=null){
            boolean flag = depth(root.right)<=1;
            if(flag==false){
                isBalanced = flag;
            }
            preorder(root.right);
        }
        else if(root.left!=null&&root.right!=null){
            boolean flag = Math.abs(depth(root.left)-depth(root.right))<=1;
            if(flag==false){
                isBalanced = flag;
            }
            preorder(root.left);
            preorder(root.right);
        }
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        else if(root.right==null&&root.left==null){
            return 1;
        }
        else if(root.left!=null&&root.right==null){
            return 1+depth(root.left);
        }
        else if(root.left==null&&root.right!=null){
            return 1+depth(root.right);
        }
        else{
            return 1+Math.max(depth(root.left),depth(root.right));
        }
    }
}