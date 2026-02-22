/**
 * @author wyr on 2026/2/21
 */
public class _25reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode groupEnd = pre; // groupEnd 指向待反转的 k 个节点的最后一个节点
        while (true) {
            for (int i = 0; i < k; i++) {
                if (groupEnd.next == null) {
                    return dummy.next; // 不足 k 个节点，直接返回结果
                }
                groupEnd = groupEnd.next;
            }
            ListNode nextGroupStart = groupEnd.next; // 记录下一组的起始节点
            groupEnd.next = null;
            ListNode groupStart = pre.next;
            pre.next = reverse(groupStart); // 反转当前组
            groupStart.next = nextGroupStart; // 连接反转后的组与下一组
            pre = groupStart; // 更新 pre 指向下一组的前一个节点
            groupEnd = pre; // 重置 groupEnd 指向下一组的前一个节点
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

}
