package Medium;


public class Question1390 {
    public static void main(String[] args) {
        int[] nums = {21, 4, 7};
        System.out.println(sumFourDivisors(nums));
    }

    public static int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0;
            int sum = 0;
            double square = Math.sqrt(num);
            for (int i = 1; i < square; i++) {
                if (num % i == 0) {
                    count++;
                    sum = sum + i + (num / i);
                }
                if (count > 2) break;
            }
            if (num % square == 0 || count != 2) continue; //sqrt edge case
            res += sum;
        }
        return res;
    }
}
