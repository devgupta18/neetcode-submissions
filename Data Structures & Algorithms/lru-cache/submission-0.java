class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            this.delete(node);
            this.insert(node);
        } else {
            return -1;
        }
        return cache.get(key).val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            this.delete(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        this.insert(newNode);
        if(this.cache.size() > this.capacity) {
            this.cache.remove(this.left.next.key);
            this.delete(this.left.next);
        }
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

class Node {
    int key, val;
    Node prev, next;
    
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}