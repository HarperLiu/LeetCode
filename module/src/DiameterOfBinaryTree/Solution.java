package DiameterOfBinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<TreeNode> treeNodes = new ArrayList<>();
    public int diameterOfBinaryTree(TreeNode root) {
        list.add(0); //如果是根节点是null可以防报错
        preorder(root);
        for(int i=0;i<treeNodes.size();i++){
            list.add(findMaxDiameter(treeNodes.get(i)));
        }
        return Collections.max(list);
    }
    public void preorder(TreeNode t){
        if(t!=null){
            treeNodes.add(t);
            preorder(t.left);
            preorder(t.right);
        }
    }
    public int findMaxDiameter(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return 0;
        }
        if(root.left==null&&root.right!=null){
            return height(root.right)+1;
        }
        if(root.right==null&&root.left!=null){
            return height(root.left)+1;
        }
        else{
            return height(root.left)+height(root.right)+2;
        }
    }
    public int height(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return 0;
        }
        if(root.left==null&&root.right!=null){
            return height(root.right)+1;
        }
        if(root.right==null&&root.left!=null){
            return height(root.left)+1;
        }
        else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
}
