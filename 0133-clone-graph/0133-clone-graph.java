/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // deep copy & BFS
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int n = curr.neighbors.size();
            // 이웃 순회
            for (int i = 0; i < n; i++) {
                Node tmp = curr.neighbors.get(i);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new Node(tmp.val)); // 없는 노드 값 추가(복제)
                    q.offer(tmp);
                }
                map.get(curr).neighbors.add(map.get(tmp)); // 이웃 리스트 추가(복제)
            }
        }
        return map.get(node);
    }
}