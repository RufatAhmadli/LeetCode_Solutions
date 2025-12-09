package Medium;

import java.util.HashMap;

public class Question3583 {
    public static void main(String[] args) {
        int[] nums = {16, 22, 0, 11, 36, 6, 24, 22};
        int[] nums2 = {0, 1, 0, 0};
        System.out.println(specialTriplets(nums));
        System.out.println(specialTriplets(nums2));
    }

    /*public static int specialTriplets(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean zeroCheck = false;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] * 2;
            if (map.containsKey(target)) {
                int prev = 0;
                int next = 0;
                for (int num : map.get(target)) {
                    if (target == 0 && zeroCheck) continue;
                    if (target == 0) {
                        prev = 1;
                        next = map.get(target).size() - 2;
                        if (next < 0) next = 0;
                        zeroCheck = true;
                    } else {
                        if (i > num) prev++;
                        else next++;
                    }
                }
                ans += prev * next;
            }
        }
        return ans;
    }*/ // TLE
    public static int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }

        long ans = 0;

        // Step 2: treat each index as j
        for (int x : nums) {
            right.put(x, right.get(x) - 1);

            long L = left.getOrDefault(2 * x, 0);
            long R = right.getOrDefault(2 * x, 0);

            ans = (ans + L * R) % MOD;
            left.put(x, left.getOrDefault(x, 0) + 1);
        }

        return (int) ans;
    }
}
