class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();

        for(int i=0; i<tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int top = Integer.parseInt(st.peek());
                st.pop();
                int secTop = Integer.parseInt(st.peek());
                st.pop();
                switch(s) {
                    case "+":
                        st.push(String.valueOf(top + secTop));
                        break;
                    case "-":
                        st.push(String.valueOf(secTop - top));
                        break;
                    case "*":
                        st.push(String.valueOf(secTop * top));
                        break;
                    case "/":
                        st.push(String.valueOf(secTop / top));
                        break;
                }
            } else {
                st.push(s);
            }
        }
        return Integer.valueOf(st.peek());
    }
}
