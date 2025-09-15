/**
 * @author wyr on 2025/9/15
 */
public class _24SwapPairs {
    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode prev = dummy; // prev 指向待交换的两个节点的前一个节点
//
//        // 必须保证 prev 后面的两个节点都存在，才能进行交换
//        while (prev.next != null && prev.next.next != null) {
//            // 1. 定义待交换的两个节点
//            ListNode node1 = prev.next;
//            ListNode node2 = prev.next.next;
//
//            // 2. 进行交换 (和你的逻辑一样)
//            prev.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//
//            // 3. 更新 prev，移动到下一对要交换的节点的前面
//            // 交换后 node1 变成了第二个节点，所以 prev 移动到 node1 的位置
//            prev = node1;
//        }
//
//        return dummy.next;


        //###########递归解法###########

        // 递归终止条件：如果链表为空或只有一个节点，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }
        // 定义要交换的两个节点
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next); // 递归交换后续节点
        newHead.next = head; // 完成当前两个节点的交换
        return newHead; // 返回新的头节点
    }
}
