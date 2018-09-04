package IntersectionOfTwoLinkedList;

import util.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> list = new ArrayList<>();
        if(headA==null||headB==null){
            return null;
        }
        while(headA!=null){
            list.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(list.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
