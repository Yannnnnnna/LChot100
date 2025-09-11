/**
 * @author wyr on 2025/9/10
 */
public class _142DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        //再走一圈找到入口
        if(meet == null){
            return null;
        }
        ListNode ptr = head;
        while (ptr != meet) {
            ptr = ptr.next;
            meet = meet.next;
        }
        return ptr;
    }
}
