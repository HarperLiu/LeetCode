package BinaryTreeZigzagLevelOrderTraversal;

import util.TreeNode;

import java.util.*;

/**
 * Created by HarperLiu on 2018.5.28
 * 在二叉树非递归层次遍历的基础上，如果res的size为奇数，就把tempList翻转后再存入res
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<Integer>();
            int tempSize = queue.size();
            while(tempSize>0){
                TreeNode t = queue.poll();
                tempList.add(t.val);
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                tempSize--;
            }
            if(res.size()%2==1){
                Collections.reverse(tempList);
            }
            res.add(tempList);
        }
        return res;
    }
}