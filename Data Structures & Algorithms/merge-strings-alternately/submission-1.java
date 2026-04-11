class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i=0;
        int j=0;
        StringBuilder builder = new StringBuilder();
        while(i<n && j<m ){
           builder.append(word1.charAt(i));
           builder.append(word2.charAt(j));
           i++;
           j++;
        }
        while(i<n){
            builder.append(word1.charAt(i));
            i++;
        }
        while(j<m){
            builder.append(word2.charAt(j));
            j++;
        }
        return builder.toString();
    }
}



