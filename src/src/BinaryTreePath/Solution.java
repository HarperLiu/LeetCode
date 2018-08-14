package BinaryTreePath;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Harper Liu on 2018.6.2
 * 二叉树从根节点到每个叶的所有路径
 * 如果根节点不为null，当前节点为根节点
 * 循环开始：
 * 如果当前节点的左右子节点都不为空，那么把右节点压栈，把当前节点加入路径,当前节点变成左子节点；
 * 如果当前节点的左右子节点有一个不为空，那么把当前节点加入路径，当前节点变为不为空的那个子节点
 * 如果当前节点是叶：
 *   • 把路径加叶的结果存入结果集，注意叶本身并不加入路径
 *   • 如果栈非空并且栈顶元素不是路径最前端节点的子节点，那么路径一直回退直到符合条件
 *   • 如果栈为空说明最后一条路径查询结束，返回结果集，否则弹出栈顶节点作为当前节点，continue;
 */


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null){
            return res;
        }
        if(root.right==null&&root.left==null){
            res.add(root.val+"");
            return res;
        }
        else{
            TreeNode currentNode = root;
            while(true){
                if(currentNode.left!=null&&currentNode.right!=null){
                    stack.push(currentNode.right);
                    path.add(currentNode);
                    currentNode = currentNode.left;
                }else if(currentNode.left!=null&&currentNode.right==null){
                    path.add(currentNode);
                    currentNode = currentNode.left;
                }else if(currentNode.right!=null&&currentNode.left==null){
                    path.add(currentNode);
                    currentNode = currentNode.right;
                }else if(currentNode.left==null&&currentNode.right==null){//叶子
                    //搜到叶，加入结果
                    res.add(jointAndToString(path,currentNode));
                    while(!stack.isEmpty()&&!isSon(stack.peek(),path.get(path.size()-1))){
                        path.remove(path.size()-1);
                    }
                    if(!stack.isEmpty()){
                        currentNode = stack.pop();
                    }else {
                        return res;
                    }
                }
            }
        }

    }
    public String jointAndToString(ArrayList<TreeNode> path,TreeNode t){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<path.size();i++){
            sb.append(path.get(i).val+"->");
        }
        sb.append(t.val);
        return sb.toString();
    }

    public boolean isSon(TreeNode peek,TreeNode pathHead){
        if(pathHead.left!=null&&pathHead.left==peek){
            return true;
        }
        if(pathHead.right!=null&&pathHead.right==peek){
            return true;
        }
        return false;
    }
}