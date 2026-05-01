/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

// val, isLeaf 모두 boolean 변수
// isLeaf: 값 모두 같으면 T, 다르면 F & 4등분 후 각각 재귀 호출
// isLeaf가 T일 때 val: 모두 동일한 그 해당 값
// isLeaf가 F일 때 val: 1 = T, 0 = F 중 아무거나
// new Node 생성 시 leaf일 때만 val 의미 있음
// * 작성한 코드는 recursion (초심자 추천)이지만,
// * 문제는 2D prefix sum array 사용을 권장했음
// * 값이 0 or 1뿐이므로 누적합은 3가지 경우뿐!
// * 모두 0: 0 / 모두 1: len*len / 0,1 섞임: 그 외 중간값
// * prefix sum은 누적합을 따로 저장해서 
// * 바로 쓸 수 있도록 해 현재 효율을 더욱 높여 줌
// * (큰 영역 - 위쪽 - 왼쪽 + 겹치는 작은 영역)
// * 같은 값인지 매번 탐색(O(len*len))하는 것보다 
// * 저장된 누적합으로 3가지 경우 중 어느 경우인지 판단(O(1))하는 게 더 빠름
// * 큰 영역을 가져와 (0,0)부터의 누적합을 보고
// * 원하는 범위에서의 누적합을 보기 위해 좌,상을 뺌
// * 이 때, 빼면서 겹치는 영역은 다시 더해 복구
class Solution {
    // quad 트리의 root 반환
    public Node construct(int[][] grid) {
        return make(0, 0, grid, grid.length);
    }

    private Node make(int row, int col, int[][] map, int len) {
        // len이 1 (1칸 = 값 항상 동일 = leaf) 되면 재귀 종료
        if (len == 1) {
            return new Node(map[row][col] == 1, true); // 그 좌표 값이 1이면 T, 아니면 F로 노드 생성
        }

        // 값 모두 같은지
        int st = map[row][col];
        boolean equal = true;
        // row, col부터 len 더한 곳까지 반복!
        for (int r = row; r < (row + len); r++) {
            for (int c = col; c < (col + len); c++) {
                if (map[r][c] != st) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                break;
            }
        }

        // 같다면: 노드 생성 후 종료
        if (equal) {
            // val: st가 1이면 T, 1이 아니면 F로 노드 생성
            // isLeaf: 모두 같아서 leaf가 맞아 T로 노드 생성
            return new Node(st == 1, true);
        }

        // 다르다면: 주변 4등분 후 재귀 호출 반복
        int div = len / 2; // 4등분 준비
        Node curr = new Node(true, false); // 노드 초기화 생성

        // 해당 노드 주변 4등분에서 각각 재귀 호출
        curr.topLeft = make(row, col, map, div); // 좌상
        curr.topRight = make(row, (col + div), map, div); // 우상
        curr.bottomLeft = make((row + div), col, map, div); // 좌하
        curr.bottomRight = make((row + div), (col + div), map, div); // 우하
        return curr;
    }
}