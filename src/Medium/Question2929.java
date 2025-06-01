package Medium;

public class Question2929 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(5,2));
    }

    public static long distributeCandies(int n, int limit) {
        long count = 0;
        for (int a = 0; a <= Math.min(n, limit); a++) {
            int remaining = n - a;
            int low = Math.max(0, remaining - limit);
            int high = Math.min(limit, remaining);
            if (high >= low) {
                count += (high - low + 1);
            }
        }
        return count;
    }
}
