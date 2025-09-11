/**
 * @author wyr on 2025/9/8
 */
public class _206ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        if (c == null) {
            return null;
        }
        while (c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}
