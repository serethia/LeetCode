class LRUCache {

    // 이전 노드도 조작 가능하도록 노드 클래스 구현
    class Node {
        int key;
        int value;
        Node prev; // 이전 노드
        Node next; // 다음 노드

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 인스턴스 공유
    private Map<Integer, Node> map;
    private int capacity;
    private Node head; // 맨 앞 더미
    private Node tail; // 맨 뒤 더미

    // cf.) LRU (맵) =/= FIFO (큐)

    public LRUCache(int capacity) {
        // 인스턴스 연결
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            // 현위치에서 제거
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            // 맨 앞으로 이동
            curr.next = head.next;
            curr.prev = head;
            head.next.prev = curr;
            head.next = curr;
            // get한 노드의 value 반환
            return curr.value;
        }
        // 없으면 -1 반환
        return -1;
    }

    public void put(int key, int value) {
        // 중복: 해당 key 제거
        if (map.containsKey(key)) {
            Node rmv = map.get(key);
            rmv.prev.next = rmv.next;
            rmv.next.prev = rmv.prev;
            map.remove(key);
        }

        // 용량 초과: tail 바로 앞의 LRU key 제거
        if (map.size() == capacity) {
            Node lru = tail.prev;
            lru.prev.next = tail;
            tail.prev = lru.prev;
            map.remove(lru.key);
        }

        // head 바로 뒤에 해당 key 추가
        Node curr = new Node(key, value);
        curr.next = head.next;
        curr.prev = head;
        head.next.prev = curr;
        head.next = curr;
        map.put(key, curr); // 자동 갱신도 가능
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */