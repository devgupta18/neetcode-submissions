class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodeString = new StringBuilder();
        for(int i=0; i<strs.size(); i++) {
            int n = strs.get(i).length();
            encodeString.append(n);
            encodeString.append("#");
            encodeString.append(strs.get(i));
        }
        return encodeString.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            StringBuilder n = new StringBuilder();
            StringBuilder st = new StringBuilder();
            while(!(str.charAt(i) == '#')) {
                n.append(str.charAt(i));
                i++;
            }
            int num = Integer.parseInt(n.toString());

            for(int j=i+1; j<=i+num; j++) {
                st.append(str.charAt(j));
            }

            ans.add(st.toString());
            i += num;
        }

        return ans;
    }
}
