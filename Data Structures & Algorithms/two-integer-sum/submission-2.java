class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int smallIdx = -1, largeIdx = -1;
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(target - nums[i]) && i != mp.get(target - nums[i])) {
                smallIdx = Math.min(i, mp.get(target - nums[i]));
                largeIdx = Math.max(i, mp.get(target - nums[i]));
                break;
            }
        }
        int[] ans = {smallIdx, largeIdx};
        return ans;
    }
}
