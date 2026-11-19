class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (st.size() == 0 || st.peek() != '(') return false;
                    st.pop(); break;
                case '}':
                    if (st.size() == 0 || st.peek() != '{') return false;
                    st.pop(); break;
                case ']':
                    if (st.size() == 0 || st.peek() != '[') return false;
                    st.pop(); break;
                default:
                    st.push((int)s.charAt(i));
            }
        }

        return st.size() == 0;
    }
}
