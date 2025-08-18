import java.util.*;
import java.io.*;

class Solution {
    public int majorityElement(int[] nums) {
        int now = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                now = nums[i];
            }
            if (now == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return now;
    }
}