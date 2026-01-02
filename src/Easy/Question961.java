package Easy;

public class Question961 {
    public int repeatedNTimes(int[] nums) {
        boolean[] freq = new boolean[10001];
        int res = 0;
        for (int num : nums) {
            if (freq[num]) {
                res = num;
                break;
            }
            freq[num] = true;
        }
        return res;
    }
}
