//package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbers2 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (long) in.nval;
        }
        System.out.println(distinctCountOfSubarrays(arr, k));
    }

    private static long distinctCountOfSubarrays(long[] arr, int k) {
        int n = arr.length;
        long res = 0;
        int left = 0;
        Map<Long, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.merge(arr[i], 1, Integer::sum);
            while (freq.size() > k) {
                freq.merge(arr[left], -1, Integer::sum);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                left++;
            }
            res += (i - left + 1);
        }
        return res;
    }
}
