package Medium;

public class Question2654 {
    public static void main(String[] args) {
        int[] nums = {12, 14, 7, 21};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;

        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) {
            return n - ones;
        }

        boolean con = false;
        int minGcdSubArray = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (minGcdSubArray == 2) {
                break;
            }
            int tmp = nums[i];
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                tmp = findGCD(tmp, nums[j]);
                if (tmp == 1) {
                    count = j - i + 1;
                    con = true;
                    break;
                }
            }
            if (tmp == 1) minGcdSubArray = Math.min(minGcdSubArray, count);
        }
        if (con) return minGcdSubArray + n - 2;
        else return -1;
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
