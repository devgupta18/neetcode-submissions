class Solution {
    public int calPoints(String[] op) {
        Deque<Integer> st = new ArrayDeque<>();

        for(String s:op) {
            if(s.equals("C")) {
                st.pop();
            } else if(s.equals("D")) {
                int temp = st.peek();
                st.push(temp * 2);
            } else if(s.equals("+")) {
                int temp = st.peek();
                st.pop();
                int temp2 = st.peek();
                st.push(temp);
                st.push(temp + temp2);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int ans = 0;
        while(!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}