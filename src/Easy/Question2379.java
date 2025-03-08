package Easy;


public class Question2379 {
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(blocks, k));
    }

    public static int minimumRecolors(String blocks, int k) {
        int oper = 0;
        int n = blocks.length();
        int ans;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') oper++;
        }
        ans = oper;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) != blocks.charAt(i)) {
                if (blocks.charAt(i - k) == 'W') oper--;
                else oper++;
            }
            if (ans > oper) {
                ans = oper;
                if (ans == 0) return ans;
            }
        }
        return ans;
    }
}
