class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        int right = 0;
        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                result = Math.max(result,right - left);
                set.remove(s.charAt(left));
                left++;
            }
        }

        result = Math.max(result, right - left); // this is the last case when in last case, when unable to go in else case

        return result;
    }
}

