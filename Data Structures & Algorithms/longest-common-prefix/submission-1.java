class Solution {
    public String longestCommonPrefix(String[] strs) {
        String temp = strs[0];
        StringBuilder ans = new StringBuilder();
        int k=0, n=temp.length();

        for(int i=0; i<strs.length; i++) {
            if(n > strs[i].length()) {
                temp = strs[i];
                n = temp.length();
            }
        }

        while(k < n) {
            for(int i=1; i<strs.length; i++) {
                if(temp.charAt(k) != strs[i].charAt(k)) return ans.toString();
            }
            ans.append(temp.charAt(k));
            k++;
        }

        return ans.toString();
    }
}