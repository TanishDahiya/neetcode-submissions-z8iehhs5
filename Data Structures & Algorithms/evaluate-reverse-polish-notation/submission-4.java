class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        int result = -1 ;

        for(int i = 0;i<tokens.length;i++){

            if(tokens[i].equals("+")){
                int ele = stack.pop();
                result = ele + stack.pop();
                stack.push(result);
            }else if(tokens[i].equals("*")){
                int ele = stack.pop();
                result = ele * stack.pop();  
                stack.push(result);              
            }else if(tokens[i].equals("-")){
                int ele = stack.pop();
                result =  stack.pop() - ele;  
                stack.push(result);                    
            }else if(tokens[i].equals("/")){
                int ele = stack.pop();
                result =   stack.pop() /ele ;  
                stack.push(result);   
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return result;
    }
}
