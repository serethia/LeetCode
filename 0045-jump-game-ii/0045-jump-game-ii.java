import java.util.*;
import java.io.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int able = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            able = Math.max(able, nums[i] + i);
            if (i == curr) {
                curr = able;
                cnt++;
            }
        }
        return cnt;
    }
}