package SubtreeofAnotherTree;

import util.TreeNode;

import java.util.ArrayList;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        ArrayList<TreeNode> sList = new ArrayList<>();
        ArrayList<TreeNode> tList = new ArrayList<>();
        inOrder(s,sList);
        inOrder(t,tList);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<sList.size();i++){
            if(sList.get(i)!=null){
                sb1.append("'"+sList.get(i).val+"',");
            }else {
               sb1.append("null,");
            }
        }
        sb1.deleteCharAt(sb1.length()-1);
        for(int i=0;i<tList.size();i++){
            if(tList.get(i)!=null){
                sb2.append("'"+tList.get(i).val+"',");
            }else {
                sb2.append("null,");
            }
        }
        sb2.deleteCharAt(sb2.length()-1);
        return sb1.toString().contains(sb2.toString());
    }
    private static void inOrder(TreeNode root,ArrayList list){
        if(root!=null){
            list.add(root);
            inOrder(root.left,list);
            inOrder(root.right,list);
        }else{
            list.add(null);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(s.isSubtree(root,root2));

    }
}
