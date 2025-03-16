package Medium;

import java.util.HashMap;

public class Question560 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, -2, 2, 1, 4, 2};
        int k = 7;
        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int[] preSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            preSum[i] = sum;

        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int count = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (mp.containsKey(preSum[i] - k)) {
                count = count + mp.get(preSum[i] - k);
            }

            if (mp.containsKey(preSum[i])) {
                mp.put(preSum[i], mp.get(preSum[i]) + 1);
            } else {
                mp.put(preSum[i], 1);
            }
        }
        return count;
    }
}