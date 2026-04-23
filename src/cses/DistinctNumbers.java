package cses;


import java.io.*;
import java.util.Arrays;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }

        Arrays.sort(arr);

        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) count++;
        }

        System.out.println(count);
    }
}