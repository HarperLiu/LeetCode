package ConstructBinaryTreefromPreorderandInorderTraversal;

import util.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = this.indexOf(inorder,preorder[0]);
        int n = inorder.length-(index+1);
        if(index==0&&n!=0){//无左子树有右子树
            int[] rightIn = new int[n];
            int[] rightPre = new int[n];
            for(int i=0;i<n;i++){
                rightIn[i] = inorder[i+index+1];
            }
            for(int j=0;j<n;j++){
                rightPre[j] = preorder[j+index+1];
            }
            root.right = buildTree(rightPre,rightIn);
            return root;
        }
        if(index!=0&&n==0){//无右子树有左子树
            int[] leftIn = new int[index];
            int[] leftPre = new int[index];
            for(int i=0;i<index;i++){
                leftIn[i] = inorder[i];
            }
            for(int j=0;j<index;j++){
                leftPre[j] = preorder[j+1];
            }
            root.left = buildTree(leftPre,leftIn);
            return root;
        }
        if(index==0&&n==0){//叶
            return new TreeNode(preorder[index]);
        }
        else{//左右子树都有
            int[] leftIn = new int[index];
            int[] rightIn = new int[n];
            int[] leftPre = new int[index];
            int[] rightPre = new int[n];
            for(int i=0;i<index;i++){
                leftIn[i] = inorder[i];
            }
            for(int i=0;i<n;i++){
                rightIn[i] = inorder[i+index+1];
            }
            for(int j=0;j<index;j++){
                leftPre[j] = preorder[j+1];
            }
            for(int j=0;j<n;j++){
                rightPre[j] = preorder[j+index+1];
            }
            root.left = buildTree(leftPre,leftIn);
            root.right = buildTree(rightPre,rightIn);
            return root;
        }
    }
    public int indexOf(int[] list, int target){
        for(int i=0;i<list.length;i++){
            if(list[i]==target){
                return i;
            }
        }
        return -1;
    }
}