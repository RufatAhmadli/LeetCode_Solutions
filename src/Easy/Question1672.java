package Easy;

public class Question1672 {
    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
    }

    public static int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) {
            int tmp = 0;
            for (int num : account) {
                tmp += num;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
