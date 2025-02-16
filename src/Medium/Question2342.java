package Medium;

import java.util.*;

public class Question2342 {
    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int n = nums.length;
        int maxSum = -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = digitSum(nums[i]);
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(nums[i]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                entry.getValue().sort(Collections.reverseOrder());
                maxSum = Math.max(maxSum, entry.getValue().get(0) + entry.getValue().get(1));
            }
        }
        return maxSum;
    }

    public int maximumSum2(int[] nums) {
        int[] max = new int[100];
        int res = -1;
        for (int x : nums) {
            int sum = 0;
            int temp = x;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (max[sum] != 0) res = Math.max(res, x + max[sum]);
            max[sum] = Math.max(max[sum], x);
        }
        return res;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}