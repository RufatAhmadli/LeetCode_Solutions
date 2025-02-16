class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>res=new ArrayList<>();
        int[]freq=new int[nums.length+1];
        for(int num:nums){
            if(freq[num]>=1) res.add(num);
            else freq[num]++;
        }
        return res;
    }
}
