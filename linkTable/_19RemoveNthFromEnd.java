/**
 * @author wyr on 2025/9/15
 */
public class _19RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //退出循环时，slow指针在倒数第n+1个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //删除slow节点
        slow.next = slow.next.next;
        return dummy.next;

    }
}
