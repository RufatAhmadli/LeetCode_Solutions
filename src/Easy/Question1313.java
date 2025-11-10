package Easy;

import java.util.Arrays;


public class Question1313 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(Arrays.toString(decompressRLElist(arr)));
    }

    //81.89%
    public static int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int size = 0;
        for (int i = 0; i < n; i += 2) {
            size += nums[i];
        }
        int[] res = new int[size];
        int k = 0;
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[k++] = nums[i + 1];
            }
        }
        return res;
    }
}
