class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if(mp.containsKey(temp)) {
                List<String> ls = mp.get(temp);
                ls.add(strs[i]);
                mp.put(temp, ls);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                mp.put(temp, ls);
            }
        }

        for(Map.Entry<String, List<String>> m : mp.entrySet()) {
            ans.add(m.getValue());
        }

        return ans;
    }
}
