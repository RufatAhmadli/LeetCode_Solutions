package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class SubarraySums {
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
        System.out.println(countSubarraySums(arr, k));
    }

//    private static int countSubarraySums(long[] arr, int k) {
//        int length = arr.length;
//        long[] prefix = prefixSum(arr);
//        Deque<Integer> deq = new ArrayDeque<>();
//        deq.add(0);
//        int count = 0;
//        for (int i = 1; i <= length; i++) {
//            while (!deq.isEmpty() && prefix[i] - prefix[deq.peekFirst()] > k) {
//                deq.pollFirst();
//            }
//            if (!deq.isEmpty() && prefix[i]-prefix[deq.peekFirst()] == k) {
//                count++;
//            }
//            deq.addLast(i);
//
//        }
//        return count;
//    }

    private static int countSubarraySums(long[] arr, int k) {
        int length = arr.length;
        long sum = 0;
        int count = 0, left = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            while (sum > k) {
                sum -= arr[left++];
            }
            if (sum == k) count++;
        }
        return count;
    }


}
