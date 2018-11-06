package ConvertBSTtoGreaterTree;

import util.TreeNode;

import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        list.clear();
        inOrder(root,list);
        setValue(root);
        return root;
    }

    private static void inOrder(TreeNode root,ArrayList list){
        if(root!=null){
            list.add(root.val);
            inOrder(root.left,list);
            inOrder(root.right,list);
        }
    }

    private static void setValue(TreeNode root){
        if(root!=null){
            root.val = getNewValue(root.val);
            setValue(root.left);
            setValue(root.right);
        }
    }

    private static int getNewValue(int val){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>val){
                sum+=list.get(i);
            }
        }
        return sum+val;
    }
}
