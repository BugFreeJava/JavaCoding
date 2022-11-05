/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 1. LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * 2. int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * 3. void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
 *    add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 *    evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * leetcode: https://leetcode.com/problems/lru-cache/
*/
class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        delete(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                cache.remove(head.key);
                delete(head);
            }
            
            node = new Node(key, value);
        } else {
            node.update(value);
            delete(node);
        }
        
        insert(node);
        cache.put(key, node);
    }
    
    private void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        
        if (node == head) {
            head = head.next;
        }
        
        if (node == tail) {
            tail = tail.prev;
        }
        
        node.prev = null;
        node.next = null;
    }
    
    private void insert(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public void update(int value) {
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */