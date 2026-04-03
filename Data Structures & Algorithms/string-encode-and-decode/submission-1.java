class Solution {

    StringBuilder builder = new StringBuilder();

    public String encode(List<String> strs) {
        for(String s1 : strs ){
            builder.append(s1);
            builder.append("~");
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        String[] arr = str.split("~", -1); //Imp that handles dummy_input=[""], if not done then in return [], but expected " "

        for(int i=0;i<arr.length-1;i++){  // n-1 important ["Hello","World",""], Expected output:["Hello","World"] - wee need to avoid last emty string
            list.add(arr[i]);
        }

        return list;

    }
}

//Time: O(n)
// Space: O(n)
