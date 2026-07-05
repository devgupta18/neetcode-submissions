class Solution {
    public int[] asteroidCollision(int[] as) {
        Deque<Integer> st = new ArrayDeque<>();

        for(int i:as) {
            if(i > 0) st.push(i);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(i)) st.pop();
                else {
                    if(st.isEmpty() || st.peek() < 0) st.push(i);
                }
            }
        }

        int k = st.size();
        int[] ans = new int[k];
        while(!st.isEmpty()) {
            ans[--k] = st.peek();
            st.pop();
        }

        return ans;
    }
}