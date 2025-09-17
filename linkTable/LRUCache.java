/**
 * @author wyr on 2025/9/17
 */

import java.util.Map;

/**
 * LeetCode 146: LRU 缓存
 *
 * 核心思想：使用一个哈希表和一个双向链表。
 * 1. 哈希表 (HashMap): 实现 O(1) 的快速查找。Key 存储键，Value 存储指向双向链表节点的引用。
 * 2. 双向链表 (Doubly Linked List): 维护键值对的使用顺序。
 * - 越靠近链表头部的节点，表示最近被使用。
 * - 越靠近链表尾部的节点，表示最久未被使用。
 *
 * get(key) 操作:
 * - 通过哈希表找到节点。
 * - 将该节点移动到链表头部。
 *
 * put(key, value) 操作:
 * - 如果 key 已存在，更新 value，并将节点移动到链表头部。
 * - 如果 key 不存在，创建一个新节点，放置在链表头部，并存入哈希表。
 * - 如果超出容量，则删除链表尾部节点，并从哈希表中移除。
 */
public class LRUCache {

    // 内部类：定义双向链表的节点
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Map<Integer, DLinkedNode> cache;
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;
    public LRUCache(int capacity) {
        this.cache = new java.util.HashMap<>();
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头部和伪尾部节点简化边界条件处理
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // 未找到
        }
        // 将节点移动到头部（表示最近使用）
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            if (size > capacity) {
                // 超出容量，删除尾部节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果 key 存在，更新 value 并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}
