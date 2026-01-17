class Solution {
    public int maxArea(int[] height) {
        // 투 포인터
        int lft = 0;
        int rgt = height.length - 1;
        int area = Math.min(height[lft], height[rgt]) * (rgt - lft);
        while (lft < rgt) {
            area = Math.max(Math.min(height[lft], height[rgt]) * (rgt - lft), area);
            // 더 낮은 쪽을 이동
            if (height[lft] <= height[rgt]) {
                lft++;
            } else {
                rgt--;
            }
        }
        return area;
    }
}