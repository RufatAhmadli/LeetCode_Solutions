package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class ArrayDivison {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (long) in.nval;
        }
        System.out.println(findMinimumOfMaxSum(nums, k));
    }


    private static boolean canDivide(long[] nums, int k, long sum) {
        long currSum = 0;
        int subarrays = 1;
        for (long num : nums) {
            if (currSum + num > sum) {
                subarrays++;
                currSum = 0;
            }
            currSum += num;
        }
        return subarrays <= k;
    }

    private static long findMaxElement(long[] nums) {
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private static long findSum(long[] nums) {
        long sum = 0;
        for (long num : nums) {
            sum += num;
        }
        return sum;
    }

    private static long findMinimumOfMaxSum(long[] nums, int k) {
        long l = findMaxElement(nums);
        long r = findSum(nums);
        while (l < r) {
            long mid = (l + r) / 2;
            if (canDivide(nums, k, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
