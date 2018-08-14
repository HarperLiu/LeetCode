package LinkedListCycle;

import util.ListNode;

import java.util.ArrayList;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode>path = new ArrayList<ListNode>();
        while(head!=null){
            if(path.indexOf(head)!=-1){
                return true;
            }
            path.add(head);
            head = head.next;
        }
        return false;
    }
}