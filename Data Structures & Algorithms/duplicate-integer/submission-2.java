class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            if(!st.contains(nums[i])) st.add(nums[i]);
            else return true;
        }
        return false;
    }
}