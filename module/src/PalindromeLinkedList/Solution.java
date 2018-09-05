package PalindromeLinkedList;

import util.ListNode;

import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        //System.out.println(list);
        return isPalindromeStr(list);
    }

    public boolean isPalindromeStr(ArrayList str) {
        if (str.size() == 0 || str.size() == 1) {
            return true;
        }
        //System.out.println(str.get(0).equals(str.get(str.size()-1)));
        if (str.get(0).equals(str.get(str.size()-1))) {
            str.remove(0);
            str.remove(str.size()-1);
            return true && isPalindromeStr(str);
        } else {
            return false;
        }

    }
}
