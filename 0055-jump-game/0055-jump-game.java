import java.util.*;
import java.io.*;

class Solution {
    public boolean canJump(int[] nums) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curr) {
                return false;
            }
            curr = Math.max(curr, nums[i] + i);
        }
        return true;
    }
}