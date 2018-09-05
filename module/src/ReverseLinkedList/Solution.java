package ReverseLinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * 遍历链表，得到链表中的节点数n
 * 用ptr遍历链表，依次获得第n个节点，第n-1个节点....第一个节点
 * 把每次获得的节点连接到ptr2的下一个，相当于连在新链表上
 * 返回新链表的表头
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newH = null;
        ListNode ptr, ptr2 = null; //ptr1是原链表的指针，ptr2是新链表的指针
        ListNode saveHead = head;
        if (head == null || head.next == null) {
            return head;
        }
        int counter = 0;
        while (head.next != null) {
            head = head.next;
            counter++;
        }
        newH = head;
        ptr2 = newH;
        while (counter >= 0) {
            ptr = saveHead;
            for (int i = 0; i < counter; i++) {
                ptr = ptr.next;
            }
            ptr2.next = ptr;
            ptr2 = ptr2.next;
            counter--;
        }
        saveHead.next = null;
        return newH;
    }
}
