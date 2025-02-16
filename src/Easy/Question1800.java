package Easy;

import java.util.Arrays;

public class Question1800 {
    public static void main(String[] args) {
        int []arr=new int[]{5,7,7,8,8,10};
        System.out.println(findMaxAverage(arr,1));
        int []res=searchRange(arr,8);
        System.out.println(Arrays.toString(res));

    }
    public static double findMaxAverage(int[] nums, int k) {
        double maxSum=0;
        for(int i=0;i<k-1;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum+=nums[j];
            }
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum/k;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findFirstPosition(nums, target);
        res[1] = findLastPosition(nums, target);
        return res;
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                pos = mid;
                right = mid - 1;  // Move left to find the first occurrence
            }
        }

        return pos;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                pos = mid;
                left = mid + 1;  // Move right to find the last occurrence
            }
        }

        return pos;
    }

}
