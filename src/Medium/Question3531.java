package Medium;

import java.util.*;

public class Question3531 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}
        };
        System.out.println(countCoveredBuildings(3, nums));
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            map1.putIfAbsent(x, new ArrayList<>());
            map2.putIfAbsent(y, new ArrayList<>());
            map1.get(x).add(y);
            map2.get(y).add(x);
        }

        for (List<Integer> ys : map1.values()) Collections.sort(ys);
        for (List<Integer> xs : map2.values()) Collections.sort(xs);

        int res = 0;
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            List<Integer> ys = map1.get(x);
            List<Integer> xs = map2.get(y);

            int yIndex = Collections.binarySearch(ys, y);
            int xIndex = Collections.binarySearch(xs, x);

            boolean hasAbove = yIndex > 0;
            boolean hasBelow = yIndex < ys.size() - 1;

            boolean hasLeft = xIndex > 0;
            boolean hasRight = xIndex < xs.size() - 1;

            if (hasAbove && hasBelow && hasLeft && hasRight) {
                res++;
            }
        }
        return res;
    }
}
