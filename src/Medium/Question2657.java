package Medium;

import java.util.Arrays;

public class Question2657 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{3,1,2};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] freq=new int[n+1];
        int[] res=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            freq[B[i]]++;
            if(freq[A[i]]==2){
                count++;
                if(freq[B[i]]==2 && A[i]!=B[i]){
                    count++;
                }
            } else if (freq[B[i]]==2) {
                count++;
                if(freq[A[i]]==2 && A[i]!=B[i]){
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }


}
