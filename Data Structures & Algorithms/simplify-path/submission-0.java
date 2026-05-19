class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String itr : arr){
            if(itr.equals("") || itr.equals(".")){
                continue;
            }else if(itr.equals("..") ){
                if(!stack.empty()){
                    stack.pop();
                }
                
            }else{
                stack.push(itr);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(String str : stack){
            builder.append("/");
            builder.append(str);
        }

        return builder.length()==0 ? "/" : builder.toString();

    }
}