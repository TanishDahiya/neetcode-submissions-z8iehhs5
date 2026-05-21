class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = (k*10)+ (ch - '0');
                continue;
            }else if(ch == '['){
                numberStack.push(k);
                k = 0;
                stringStack.push(Character.toString(ch));
                continue;
            }else if(ch != ']'){
                stringStack.push(Character.toString(ch));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while(!stringStack.peek().equals("[")){
                temp.insert(0,stringStack.pop());
            }

            stringStack.pop();

            StringBuilder builder = new StringBuilder();
            int count = numberStack.pop();
            for(int i = 0;i<count;i++){
                builder.append(temp);
            }

            stringStack.push(builder.toString());

        }
        StringBuilder result = new StringBuilder();
        while(!stringStack.empty()){
            result.insert(0,stringStack.pop());
        }

        return result.toString();
    }
}