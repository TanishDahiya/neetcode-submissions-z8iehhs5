class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;

        int []freqs1 = new int[26];
        int []window = new int[26];

        for(char i : s1.toCharArray()){
            freqs1[i - 'a']++;
        }

        int i = 0;
        int j = 0;
        while(j < m){

            // freq increment
            window[s2.charAt(j) - 'a']++;

            // shrink
            if(j-i+1 > n){
                window[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(window,freqs1)) return true;

            j++;
        }

        return false;
    }
}
