package Easy;

import java.util.HashMap;

public class Question219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int[] nums2 = {1, 2, 3, 1, 2, 3};
        int k2 = 2;
        int[] nums3 = {99, 99};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate2(nums, k));
        System.out.println(containsNearbyDuplicate2(nums2, k2));
        System.out.println(containsNearbyDuplicate2(nums3, k3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < Math.min(n - i - 1, k); j++) {
                if (nums[i] == nums[i + j + 1]) return true;
            }

        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }else{
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
