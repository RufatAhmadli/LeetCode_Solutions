package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumSubarraySum2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int b = (int) in.nval;

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }
//        System.out.println(findMaxSubarraySumWithinRanges(nums, a, b));
        System.out.println(findMaxSubarraySumWithinRanges2(nums, a, b));
    }

//    private static long findMaxSubarraySumWithinRanges(long[] nums, int a, int b) {
//        long[] prefix = prefixSum(nums);
//        long max = Long.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = a; j <= b; j++) {
//                if (i + j >= prefix.length) continue;
//                max = Math.max(max, prefix[i + j] - prefix[i]);
//            }
//        }
//        return max;
//    }

    private static long findMaxSubarraySumWithinRanges2(long[] nums, int a, int b) {
        long max = Long.MIN_VALUE;
        long[] prefSum = prefixSum(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = a; i <= nums.length; i++) {
            int newIndex = i - a;
            while (!deque.isEmpty() && prefSum[deque.peekLast()] >= prefSum[newIndex]) {
                deque.pollLast();
            }
            deque.offerLast(newIndex);
            while (!deque.isEmpty() && deque.peekFirst() < i - b) {
                deque.pollFirst();
            }
            max = Math.max(max, prefSum[i] - prefSum[deque.peekFirst()]);
        }
        return max;
    }

    private static long[] prefixSum(long[] nums) {
        int length = nums.length;
        long[] prefix = new long[length + 1];
        prefix[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        return prefix;
    }
}
