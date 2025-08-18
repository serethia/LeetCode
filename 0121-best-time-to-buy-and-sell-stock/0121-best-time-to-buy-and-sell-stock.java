import java.util.*;
import java.io.*;

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prof = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                int tmp = prices[i] - min;
                prof = Math.max(prof, tmp);
            }
        }
        if (prof > 0) {
            return prof;
        } else {
            return 0;
        }
    }
}