package Medium;

import java.util.*;

public class Question1481 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(mp.values());

        int remainingUniques = mp.size();

        while (k > 0 && !minHeap.isEmpty()) {
            int freq = minHeap.poll(); // get the smallest frequency
            if (k >= freq) {
                k -= freq;
                remainingUniques--;
            } else {
                break; // can't remove this group completely
            }
        }

        return remainingUniques;
    }
}
