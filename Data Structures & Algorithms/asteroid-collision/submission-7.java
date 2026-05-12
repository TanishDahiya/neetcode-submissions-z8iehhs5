class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i : asteroids ){
            if(stack.empty() || i > 0){
                stack.add(i);
            }else{
                while(!stack.empty()){
                    int peekEle = stack.peek();
                    if(peekEle < 0){
                        stack.push(i);
                        break;
                    }
                    int absVal = Math.abs(peekEle);
                    if(absVal == Math.abs(i)){
                        stack.pop();
                        break;
                    }else if(absVal > Math.abs(i)) break;
                    else{
                        stack.pop();
                        if(stack.empty()){
                            stack.push(i);
                            break;
                        }
                    }

                }
            }
        }

        int []res = new int[stack.size()];
        int j = 0;
        for(int i : stack){
            res[j++] = i;
        }

        return res;
    }
}