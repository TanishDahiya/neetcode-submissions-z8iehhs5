class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String str : operations){
            if(str.equals("C")){
                stack.pop();
            }else if(str.equals("D")){
                stack.push(2 * stack.peek());
            }else if(str.equals("+")){
                int top = stack.pop();
                int conSum = top+ stack.peek();
                stack.push(top);
                stack.push(conSum);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            int popEle = stack.pop();
            sum += popEle;
        }

        return sum;
    }
}