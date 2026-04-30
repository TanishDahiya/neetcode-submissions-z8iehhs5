class Solution {
    public int characterReplacement(String s, int k) {
        int []freq = new int[26];
        int left = 0;
        int maxWindow = 0;
        int maxFreq = 0;

        for(int right = 0;right<s.length();right++){

            freq[s.charAt(right)- 'A']++;

            int currentWindowSize = right-left+1;

            maxFreq = Math.max(maxFreq,freq[s.charAt(right)- 'A']);

            if((currentWindowSize - maxFreq) > k){
                freq[s.charAt(left) - 'A']--;
                left++;
                currentWindowSize = right-left+1;
            }

            
            maxWindow = Math.max(maxWindow,currentWindowSize);
        }

        return maxWindow;
    }
}
