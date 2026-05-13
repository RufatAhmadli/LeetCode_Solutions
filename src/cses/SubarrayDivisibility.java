//package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class SubarrayDivisibility {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (long) in.nval;
        }
        System.out.println(findCountOfSubarrays(arr));
    }

    private static long findCountOfSubarrays(long[] arr) {
        int n = arr.length;
        long[] prefixSum = findPrefixSum(arr);
        long count = 0;
        long[] mods = new long[n];
        for (int i = 0; i <= n; i++) {
            int remainder = Math.toIntExact(Math.abs(prefixSum[i]) % n);
            if (prefixSum[i] < 0) mods[(n - remainder) % n]++;
            else mods[remainder]++;
        }

        for (long mod : mods) {
            if (mod > 1) count += mod * (mod - 1) / 2;
        }
        return count;
    }

    private static long[] findPrefixSum(long[] arr) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        return prefix;
    }


}
