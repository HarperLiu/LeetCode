package BinaryTreePath;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        TreeNode root=  new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Solution s = new Solution();
        List<String> res = s.binaryTreePaths(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
