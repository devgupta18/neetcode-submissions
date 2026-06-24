class Solution {
    public int largestRectangleArea(int[] h) {
        Deque<Pair<Integer, Integer>> st = new ArrayDeque<>();
        int maxArea = 0, n = h.length;

        for(int i=0; i<n; i++) {
            int leftSmall = i;
            while(!st.isEmpty() && h[i] < st.peek().getValue()) {
                Pair<Integer, Integer> top = st.peek();
                maxArea = Math.max(maxArea, top.getValue() * (i - top.getKey()));
                st.pop();
                leftSmall = top.getKey();
            }
            st.push(new Pair<>(leftSmall, h[i]));
        }

        while(!st.isEmpty()) {
            Pair<Integer, Integer> top = st.peek();
            maxArea = Math.max(maxArea, top.getValue() * (n - top.getKey()));
            st.pop();
        }

        return maxArea;
    }
}
