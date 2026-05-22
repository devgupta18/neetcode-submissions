class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[k];
        int cntr = 0;

        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }

        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> m : mp.entrySet()) {
            int a = m.getValue(), b = m.getKey();
            freq[a].add(b);
        }

        for(int i=freq.length-1; i>=0; i--) {
            for(int j : freq[i]) {
                if(cntr == k) break;
                ans[cntr++] = j;
            }
        }
        return ans;
    }
}
