package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class SumOfThreeValues {
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
        sumOfThree(arr, k);
    }

    public static void sumOfThree(long[] arr, long k) {
        int n = arr.length;
        HashMap<Long, Integer> map = new HashMap<>(n * 2, 1.0f);
        for (int i = 0; i < n; i++) {
            long twoSum = k - arr[i];
            map.clear();
            for (int j = i + 1; j < n; j++) {
                long sum = twoSum - arr[j];
                Integer existed = map.get(sum);
                if (existed != null) {
                    System.out.println(i + 1 + " " + (existed + 1) + " " + (j + 1));
                    return;
                }
                map.put(arr[j], j);
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
