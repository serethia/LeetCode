import java.util.*;
import java.io.*;

class RandomizedSet {
    List<Integer> valueList;
    Map<Integer, Integer> indexMap;
    Random rand;

    public RandomizedSet() {
        valueList = new ArrayList<>();
        indexMap = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, valueList.size());
        valueList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int currId = indexMap.get(val);
        int endId = valueList.size() - 1;
        swap(currId, endId);
        indexMap.remove(val);
        valueList.remove(endId);
        return true;
    }

    private void swap(int curr, int end) {
        int endVal = valueList.get(end);
        valueList.set(curr, endVal);
        indexMap.put(endVal, curr);
    }

    public int getRandom() {
        return valueList.get(rand.nextInt(valueList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */