package Medium;

import java.util.*;

public class Question2785 {
    public static void main(String[] args) {

    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int tempSum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                tempSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, tempSum);
                tempSum = nums[i];
            }
        }
        return Math.max(maxSum, tempSum);
    }
}
