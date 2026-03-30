class Solution {
    public boolean isAnagram(String s, String t) {

        //initial check
        if(s.length()!= t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.equals(s1,s2);
    }
}

//TC : o(n log n) + o( m log m) 
//SC : o(1)