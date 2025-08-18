import java.util.*;
import java.io.*;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if ((citations.length - i) > citations[i]) {
                break;
            }
            h = citations.length - i;
        }
        return h;
    }
}