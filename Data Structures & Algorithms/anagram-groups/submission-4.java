class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            List<String> ls = mp.getOrDefault(temp, new ArrayList<>());
            ls.add(strs[i]);
            mp.put(temp, ls);
        }

        for(Map.Entry<String, List<String>> m : mp.entrySet()) {
            ans.add(m.getValue());
        }

        return ans;
    }
}
