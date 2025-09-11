/**
 * @author wyr on 2025/9/8
 */
public class _234IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 快慢指针找到链表的后半部分起点
        ListNode slow = head;
        ListNode fast = head;
        // 使用 fast.next 和 fast.next.next 可以让 slow 停在前半部分的末尾
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // secondHalfStart 是后半部分的头节点
        ListNode secondHalfStart = slow.next;

        // 2. 断开前半部分和后半部分
        slow.next = null;

        // 3. 反转后半部分链表
        ListNode reversedSecondHalf = reverseList(secondHalfStart);

        // 4. 比较前后两部分链表
        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;
        boolean isPalindrome = true;
            while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 5. (可选) 恢复原始链表
        slow.next = reverseList(reversedSecondHalf);

        return isPalindrome;
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
