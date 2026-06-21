class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = temp.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temp[st.peek()] < temp[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            ans[st.peek()] = 0;
            st.pop();
        }

        return ans;
    }
}
