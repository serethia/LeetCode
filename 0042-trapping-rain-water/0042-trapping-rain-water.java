class Solution {
    public int trap(int[] height) {
        // 왼=>오 최대 높이
        int[] order = new int[height.length];
        order[0] = height[0];
        for (int l = 1; l < height.length; l++) {
            order[l] = Math.max(order[l - 1], height[l]);
        }

        // 오=>왼 최대 높이
        int[] reverse = new int[height.length];
        reverse[height.length - 1] = height[height.length - 1];
        for (int r = height.length - 2; r >= 0; r--) {
            reverse[r] = Math.max(reverse[r + 1], height[r]);
        }

        // 두 최대 높이 중 최저값과 현재 높이의 차
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += (Math.min(order[i], reverse[i]) - height[i]);
        }
        return water;
    }
}