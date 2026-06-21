class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> st = new ArrayDeque<>();
        int n = speed.length;
        int[][] m = new int[n][2];

        for(int i=0; i<n; i++) {
            m[i][0] = position[i];
            m[i][1] = speed[i];
        }

        Arrays.sort(m, (a, b) -> b[0] - a[0]);

        for(int i=0; i<n; i++) {
            double time = (double)(target - m[i][0]) / m[i][1];
            if(st.isEmpty()) st.push(time);
            else if(!st.isEmpty() && st.peek() < time) st.push(time);
        }

        return st.size();
    }
}
