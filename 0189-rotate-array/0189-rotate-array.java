import java.util.*;
import java.io.*;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rev(nums, nums.length - k, nums.length - 1);
        rev(nums, 0, nums.length - k - 1);
        rev(nums, 0, nums.length - 1);
    }

    public void rev(int[] nums, int st, int ed) {
        while (st < ed) {
            int tmp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = tmp;
            st++;
            ed--;
        }
    }
}