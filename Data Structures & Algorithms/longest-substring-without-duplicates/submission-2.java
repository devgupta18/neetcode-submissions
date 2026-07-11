class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int left=0, ans = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!mp.containsKey(ch)) {
                mp.put(ch, i);
            } else {
                left = Math.max(left, mp.get(ch) + 1);
                mp.put(ch, i);
            }
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}