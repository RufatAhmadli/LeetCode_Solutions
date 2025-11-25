package Medium;

public class Question1015 {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(15));
    }

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int minn = 0;
        int num = 0;
        boolean[] seen = new boolean[k];
        while (true) {
            num = (num * 10 + 1) % k;
            minn++;
            if (num == 0) break;
            if (seen[num]) return -1;
            seen[num] = true;
        }
        return minn;
    }
}
