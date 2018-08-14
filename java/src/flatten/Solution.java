package flatten;
import util.TreeNode;
import java.util.ArrayList;

/**
 * Created by Harper on 2018.5.27
 * 对二叉树前序遍历，结果存入list,link方法连成链表
 */

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public void flatten(TreeNode root) {
        if(root!=null) {
            preorder(root);
            root.right = null;
            root.left = null;
            link(root);
        }
    }
    public void link(TreeNode root){
        TreeNode t = root;
        for(int i=1;i<list.size();i++){
            t.right = new TreeNode(list.get(i));
            t = t.right;
        }

    }
    public void preorder(TreeNode root){
        if(root==null){}
        else if(root.left==null&&root.right==null){
            list.add(root.val);
        }
        else if(root.left==null&&root.right!=null){
            list.add(root.val);
            preorder(root.right);
        }
        else if(root.left!=null&&root.right==null){
            list.add(root.val);
            preorder(root.left);
        }
        else if(root.left!=null&&root.right!=null){
            list.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

}