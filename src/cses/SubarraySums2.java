package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class SubarraySums2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        long k = (long) in.nval;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (long) in.nval;
        }

        System.out.println(findSubarraySums(arr, k));
    }

    private static long findSubarraySums(long[] arr, long k) {
        long[] prefix = prefixSum(arr);
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long count = 0;
        for (int i = 1; i <= arr.length; i++) {
            count += map.getOrDefault(prefix[i] - k, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
    }

    private static long[] prefixSum(long[] arr) {
        int length = arr.length;
        long[] prefix = new long[length + 1];
        prefix[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        return prefix;
    }
}
