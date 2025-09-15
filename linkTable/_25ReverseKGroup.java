/**
 * @author wyr on 2025/9/15
 */
public class _25ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy; // prev 指向待反转的 k 个节点的前一个节点
        ListNode groupEnd = prev; // groupEnd 指向待反转的 k 个节点的最后一个节点
//        ListNode nextGroupStart = null; // nextGroupStart 指向下一组待反转的 k 个节点的第一个节点
        while (true){
            groupEnd = prev; // 重置 groupEnd 为 prev
            // 1. 检查是否有 k 个节点可以反转
            for (int i = 0; i < k ; i++) {
                if (groupEnd.next != null) {
                    groupEnd = groupEnd.next;
                }else {
                    return dummy.next; // 不足 k 个节点，直接返回结果
                }

            }
            ListNode nextGroupStart = groupEnd.next; // 保存下一组的起始节点
            ListNode groupStart = prev.next; // 当前组的起始节点
            groupEnd.next = null; // 暂时断开链表，便于反转
            // 2. 反转 k 个节点
            prev.next = reverseList(prev.next); // 反转当前组

            // 3. 连接反转后的部分与未反转的部分
            groupStart.next = nextGroupStart; // 连接后一部分
            prev = groupStart; // 更新 prev，指向新组的尾节点
        }
    }

    // 辅助函数：反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
