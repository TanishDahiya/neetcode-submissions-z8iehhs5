class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push expected closing bracket
            if (ch == '(') {
                stack.push(')');
            } 
            else if (ch == '[') {
                stack.push(']');
            } 
            else if (ch == '{') {
                stack.push('}');
            } 
            else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}