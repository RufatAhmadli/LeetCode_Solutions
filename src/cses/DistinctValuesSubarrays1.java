package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class DistinctValuesSubarrays1 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (long) in.nval;
        }
        System.out.println(findDistinctNumbers(arr));
    }

    private static long findDistinctNumbers(long[] arr) {
        int n = arr.length;
        long res = 0;
        Map<Long, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            map.merge(arr[right], 1, Integer::sum);
            while (map.get(arr[right]) > 1) {
                map.merge(arr[left], -1, Integer::sum);
//                if (map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }
}
