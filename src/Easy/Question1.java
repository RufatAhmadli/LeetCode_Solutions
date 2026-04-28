package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer j = mp.get(sub);
            if (j != null) {
                ans[0] = j;
                ans[1] = i;
                break;
            }
            mp.put(nums[i], i);
        }
        return ans;

    }
}
