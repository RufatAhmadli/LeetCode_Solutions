package Medium.HashMap;

import java.util.TreeMap;

public class Question2762 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long totalSubarrays = 0;

        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }


            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}
