public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(6));
        String str="Hello World";
        String str2=str;
        System.out.println(str);
        System.out.println(str2);
        int a=12;
        int b=7;
        float c=10f;
        float d=15f;
        double e=c/d;
        System.out.println(a++);
        System.out.println(++b);
        System.out.println(a+b);
        System.out.println(e);
    }

    static class Solution {
        public int fib(int n) {
            if (n == 0) return 0;
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int copy = b;
                b = b + a;
                a = copy;
            }
            return b;
        }
    }
}