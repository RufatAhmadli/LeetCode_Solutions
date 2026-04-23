package cses;

import java.util.Scanner;

public class WeirdNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(printWeirdNumber(n));
    }

    private static String printWeirdNumber(long n) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(n).append(" ");
            if (n == 1) break;
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        }
        return sb.toString().trim();
    }
}
