package Medium;

import java.util.*;

public class Question873 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        System.out.println(lenLongestFibSubseq(arr));
    }


    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int maxLength = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int k = arr[j] - arr[i];
                if (k < arr[i] && indexMap.containsKey(k)) {
                    int prevIndex = indexMap.get(k);
                    dp.putIfAbsent(i, new HashMap<>());
                    dp.get(i).put(j, dp.getOrDefault(prevIndex, new HashMap<>()).getOrDefault(prevIndex, 2) + 1);
                    maxLength = Math.max(maxLength, dp.get(i).get(j));
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }
}



