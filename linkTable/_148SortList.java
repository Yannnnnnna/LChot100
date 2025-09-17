/**
 * @author wyr on 2025/9/16
 */
public class _148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //1、找到中点，断开链表
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        //2、递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        //3、合并两个有序链表
        return merge(left, right);

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ptr = new ListNode(-1);
        ListNode cur = ptr;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return ptr.next;

        }
}
