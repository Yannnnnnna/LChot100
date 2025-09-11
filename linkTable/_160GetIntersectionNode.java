/**
 * @author wyr on 2025/9/8
 */

/**
 * Definition for singly-linked list. */
 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) {
       val = x;
        next = null;
    }
 }

public class _160GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
