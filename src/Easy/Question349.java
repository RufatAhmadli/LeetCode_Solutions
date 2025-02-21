package Easy;

import java.util.Arrays;

public class Question349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int count = 0;
        int[] freq = new int[1001];
        for (int num : nums1) {
            if (freq[num] == 0) {
                freq[num]++;
            }
        }
        for (int num : nums2) {
            if (freq[num] == 1) {
                freq[num]--;
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;

        for (int num : nums2) {
            if (freq[num] == 0) {
                result[index++] = num;
                freq[num]--;
            }
        }
        return result;
    }
}

