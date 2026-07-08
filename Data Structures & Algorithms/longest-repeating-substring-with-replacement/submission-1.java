class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left = 0, ans = 0;
        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(ch));
            if(i - left + 1 - maxFreq <= k) ans = i - left + 1;
            else {
                mp.put(s.charAt(left), mp.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return ans;
    }
}
