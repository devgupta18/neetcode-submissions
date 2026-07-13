class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mpS = new HashMap<>();
        Map<Character, Integer> mpT = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            mpT.put(ch, mpT.getOrDefault(ch, 0) + 1);
        }

        int have=0, need=mpT.size(), left=0;
        int minLen=Integer.MAX_VALUE, minLeft=0, minRight=0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            mpS.put(ch, mpS.getOrDefault(ch, 0) + 1);
            if(!mpS.isEmpty() && mpT.containsKey(ch) && mpT.get(ch) == mpS.get(ch)) have++;
            while(have == need) {
                char temp = s.charAt(left);
                if(i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minLeft = left;
                    minRight = i;
                }
                mpS.put(temp, mpS.get(temp)-1);
                if(mpT.containsKey(temp) && mpT.get(temp) > mpS.get(temp)) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}
