import java.util.HashMap;

/**
 * @author wyr on 2025/9/16
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class _138CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node tmp = head;
        //第一遍遍历，复制节点
        while (tmp != null) {
            map.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        //第二遍遍历，连接next和random
        while (tmp != null) {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(head);
    }
}
