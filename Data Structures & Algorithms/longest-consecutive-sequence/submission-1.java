class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int maxCount = 0;

        for(int i=0; i<nums.length; i++) {
            st.add(nums[i]);
        }

        for(int i:st) {
            if(st.contains(i-1)) continue;
            else {
                int count = 1, k=1;
                while(st.contains(i+k)) {
                    count++;
                    k++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }

        return maxCount;
    }
}
