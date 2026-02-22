import java.util.HashMap;
import java.util.Map;

/**
 * @author wyr on 2026/2/21
 */
class _LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Map<Integer, Node> cache;

    Node head;
    Node tail;

    public _LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将访问的 key 移到链表末尾，表示最近使用
        Node node = cache.get(key);
        removeNodeToTail(node);
        return node.value;
    }

    private void removeNodeToTail(Node node) {
        // 从链表中移除 node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 将 node 移到链表末尾
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 更新值并将 key 移到链表末尾
            Node node = cache.get(key);
            node.value = value;
            removeNodeToTail(node);
        } else {
            if (cache.size() >= capacity) {
                // 移除最久未使用的 key
                Node oldestNode = head.next;
                head.next = oldestNode.next;
                oldestNode.next.prev = head;
                cache.remove(oldestNode.key);
            }
            // 添加新 key 和 value
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            // 将新 key 移到链表末尾
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }
    }
}


