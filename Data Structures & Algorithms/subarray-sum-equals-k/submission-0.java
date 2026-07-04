class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count=0;
        int[] prefixSum = new int[n+1];

        for(int i=0; i<=n; i++) {
            if(i == 0) prefixSum[i] = 0;
            else prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<=n; i++) {
            int tmp = prefixSum[i] - k;
            if(hm.containsKey(tmp)) {
                count += hm.get(tmp);
            }
            hm.put(prefixSum[i], hm.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}