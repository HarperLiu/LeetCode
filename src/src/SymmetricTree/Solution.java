package SymmetricTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HarperLiu on 2017.5.28
 *  判断一个数是否为镜像对称：先判断根，在判断左右子树。如果左右子树都为空那就是，如果左右子树不是同时为空那就不是
 *  当左右子树都存在的时候，判断他们的值是否相等,如果相等那么久递归的对他们的字节点判断（左边的左=右边的右；左边的右==右边的左）
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root!=null){
            return symmetric(root.left,root.right);
        }
        return true;
    }
    public boolean symmetric(TreeNode t1,TreeNode t2){
       if(t1==null&&t2==null){
           return true;
       }
       else if(t1!=null&&t2==null){
           return false;
       }
       else if(t1==null&&t2!=null){
           return false;
       }
       else{
           return t1.val==t2.val&&symmetric(t1.left,t2.right)&&symmetric(t1.right,t2.left);
       }

    }
}