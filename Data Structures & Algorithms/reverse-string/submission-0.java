class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int k = s.length-1;
        while(i<k){
            char temp = s[i];
            s[i]=s[k];
            s[k]=temp;
            i++;
            k--;
        }
    }
}