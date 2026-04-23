package cses;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(findMinMoves(arr, n));
    }

    private static long findMinMoves(long[] arr, int length) {
        long res = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                res += arr[i - 1] - arr[i];
                arr[i] = arr[i - 1];
            }
        }
        return res;
    }
}
