package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question202 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (true) {
            int sq = findSquare(list.getLast());
            if (sq == 1) return true;
            if (list.contains(sq)) {
                return false;
            } else {
                list.add(sq);
            }
        }
    }

    private static int findSquare(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
