class MinStack {
    Deque<Integer> st, min;

    public MinStack() {
        st = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || val <= min.peek()) min.push(val);
    }
    
    public void pop() {
        if(min.peek().equals(st.peek())) min.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
