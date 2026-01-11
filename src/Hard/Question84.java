package Hard;

import java.util.Stack;

public class Question84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // If current bar is shorter than the top of the stack,
        // we've found the right boundary for the bar at the top.
        for (int i = 0; i <= n; i++) {
            int curHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? -1 : stack.peek();
                int area = h * (i - width - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
