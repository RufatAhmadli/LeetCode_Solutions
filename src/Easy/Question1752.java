package Easy;

import java.util.Arrays;

public class Question1752 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(check(nums));
        System.out.println(check2(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        int x = 0;
        while (x < n) {
            if (Arrays.equals(copy, nums)) return true;
            int last = copy[n - 1];
            for (int i = n - 1; i > 0; i--) {
                copy[i] = copy[i - 1];
            }
            copy[0] = last;

            x++;
        }

        return false;
    }
    public static boolean check2(int[] nums) {
        int breaks = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                breaks++;
            }
        }
        if(breaks>1){
            return false;
        }
        return true;
    }
}
