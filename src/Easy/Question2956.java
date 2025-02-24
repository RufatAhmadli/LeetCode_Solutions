package Easy;

import java.util.Arrays;

public class Question2956 {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};
        System.out.println(Arrays.toString(findIntersectionValues(nums1, nums2)));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int common1 = 0;
        int common2 = 0;
        int[] freq1 = new int[101];
        int[] freq2 = new int[101];
        for (int j : nums1) {
            freq1[j]++;
        }
        for (int j : nums2) {
            freq2[j]++;
        }
        for (int i = 0; i < 101; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                common1 += freq1[i];
                common2 += freq2[i];
            }
        }
        return new int[]{common1, common2};
    }
}
