import java.util.PriorityQueue;

/**
 * @author wyr on 2025/9/17
 */
public class _23MergeKLists {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        return merge(lists, 0, lists.length - 1);
//    }
//
//    private ListNode merge(ListNode[] lists, int l, int r) {
//        if(l == r) {
//            return lists[l];
//        }
//        if (l > r) {
//            return null;
//        }
//        // 分治
//        int mid = l + (r - l) / 2;
//        ListNode left = merge(lists, l, mid);
//        ListNode right = merge(lists, mid + 1, r);
//
//        return mergeTwoLists(left, right);
//    }
//    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        ListNode ptr = new ListNode(-1);
//        ListNode cur = ptr;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = list1 == null ? list2 : list1;
//        return ptr.next;
//    }

    //优先队列

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        //创建优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        //将所有链表的头节点加入优先队列
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        //创建哨兵节点
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            //取出队列中最小的节点
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;
            //如果取出的节点有下一个节点，则将下一个节点加入队列
            if (minNode.next != null) {
                pq.add(minNode.next);
            }

        }
        return dummy.next;

    }
}
