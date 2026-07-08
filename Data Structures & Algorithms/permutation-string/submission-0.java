class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            mp1.put(ch, mp1.getOrDefault(ch,0) + 1);
        }

        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            if(i < s1.length()) {
                mp2.put(ch, mp2.getOrDefault(ch,0) + 1);
            } else {
                char temp = s2.charAt(i - s1.length());
                mp2.put(temp, mp2.getOrDefault(temp,0) - 1);
                mp2.put(ch, mp2.getOrDefault(ch,0) + 1);

                if(mp2.get(temp) == 0) mp2.remove(temp);
            }
            if(mp1.equals(mp2)) return true;
        }
        
        return false;
    }
}
