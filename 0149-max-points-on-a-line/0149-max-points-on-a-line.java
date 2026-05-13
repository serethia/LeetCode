class Solution {
    // 1번째 for문: 기준점 고정 (y절편 볼 필요 X)
    // 2번째 for문: 기울기 count (map 활용)
    // * for문 3번: 시간 O(n^3) 공간 O(1)
    // * for문 2번 + map (이 코드): 시간 O(n^2(logm)) 공간 O(n)
    public int maxPoints(int[][] points) {
        int cnt = 1; // 동일 직선상 최대 개수
        int n = points.length; // 좌표 개수
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>(); // 기울기(기약분수), count
            int max = 0; // 현재 기준점에서 최대 수
            for (int j = i + 1; j < n; j++) {
                String s = slope(points[i], points[j]);
                map.put(s, map.getOrDefault(s, 0) + 1);
                max = Math.max(map.get(s), max);
            }
            // 전체 통틀어 최대 개수 갱신
            // (기준점제외+1개 vs. 기준점포함)
            cnt = Math.max(max + 1, cnt);
        }
        return cnt;
        // * map: 기준점의 상대적 cnt 비교
        // 만약 기준점 본인도 들어가면 논리가 깨짐!
        // cnt를 1, return을 cnt 그대로 하되,
        // map에 getordefault할 때는 0에 +1
        // 상대적 max 비교는 get값으로도 문제X
    }

    // 기울기(y차이/x차이) 기약분수를 String 반환
    private String slope(int[] st, int[] ed) {
        int top = ed[1] - st[1]; // y 차이 (기약분수화)
        int bottom = ed[0] - st[0]; // x 차이 (기약분수화)
        if (top == 0) {
            // 가로로 수평선 (표기 가능한 형태로)
            return "0/1";
        }
        if (bottom < 0) {
            // bottom은 항상 양수화하기로 통일
            top *= -1;
            bottom *= -1;
        } else if (bottom == 0) {
            // 세로로 수직선 (표기 가능한 형태로)
            return "1/0";
        }
        int g = gcd(top, bottom);
        return (top / g) + "/" + (bottom / g);
    }

    // 최대공약수 계산
    private int gcd(int a, int b) {
        if (b == 0) {
            // 음수 처리
            if (a < 0) {
                a *= -1;
            }
            return a;
        }
        return gcd(b, a % b);
    }
}