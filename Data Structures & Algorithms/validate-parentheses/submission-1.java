class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            boolean opening = ch == '{' || ch == '[' || ch == '(';
            if(st.isEmpty() && !opening) return false;
            if(opening) st.push(ch);
            else {
                if(ch == ']' && st.peek() == '[') st.pop();
                else if(ch == '}' && st.peek() == '{') st.pop();
                else if(ch == ')' && st.peek() == '(') st.pop();
                else return false;
            }
        }

        return st.isEmpty() ? true : false;
    }
}
