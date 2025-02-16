package Easy;

import java.util.*;

public class Question2215 {
    public static void main(String[] args) {
        int[] nums1 = {48, -111, 73, 26, 382, -97, -129, 91, 110, 373, -360, -236, 194, 282, -229, 352, 25, 213, -15, 193, 365, 187, 277, -20};
        int[] nums2 = {-371, 41, 261, -294, -247, -63, -47, 384, 425, 58, 484, 393, 236, -265, -198, -415, -366, 284, 136, -470, 433, 390, -160, -410, -317, -252, -41, -423, 177, 350, -92, 448, -125, -229, 35, 110, 443, -73, 328};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
            s2.add(num);
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (Integer num : s1) {
            if (s2.contains(num)) {
                l1.add(num);
            }
        }
        for (Integer num : s2) {
            if (s1.contains(num)) {
                l2.add(num);
            }
        }
        res.add(l1);
        res.add(l2);
        return res;
    }
}
