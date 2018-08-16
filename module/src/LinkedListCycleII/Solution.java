package LinkedListCycleII;

import util.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ArrayList<ListNode> path = new ArrayList<ListNode>();
        while(head!=null){
            if(path.indexOf(head)!=-1){
                return head;
            }
            path.add(head);
            head = head.next;
        }
        return null;
    }
}
