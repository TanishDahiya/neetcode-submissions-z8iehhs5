class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i)!=s2.charAt(i)) break;

            ans.append(s1.charAt(i));
        }
        
        return ans.toString();
    }
}

// TC -> O(n log n * m) because in each string in array there is a sorting also
// SC :
// . Sorting Strings
// Java uses TimSort for objects (like String[])
// It uses O(n) extra space
// 2. Result string (StringBuilder)
// Takes O(m) space.   -- need to double check