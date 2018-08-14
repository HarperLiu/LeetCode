package BinaryTreeLevelOrderTraversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by HarperLiu on 2018.5.26
 * 二叉树非递归层次遍历
 * 若根节点非空，则将根节点入队，然后，判断队列是否为空，若不为空，则将队首节点出队，访问，并判断其左右子节点是否为空，若不为空，则压入队列。
 * 初始化tempSize记录队列中节点数（也就是一层的节点数），tempList临时存放一层的节点,如果不需要每一层放入一个数组则不需要
 */


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        queue.offer(root); //把根节点入栈
        while(!queue.isEmpty()){
            int tempSize = queue.size();//同层元素个数
            List<Integer> tempList = new ArrayList<Integer>();
            while(tempSize>0){
                TreeNode t = queue.poll();
                tempList.add(t.val);
                if(t.left!=null){
                    queue.offer(t.left);
                }
                if(t.right!=null){
                    queue.offer(t.right);
                }
                tempSize--;
            }
            res.add(tempList);

        }
        return res;
    }
}