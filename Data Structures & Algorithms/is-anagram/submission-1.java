class Solution {
    public boolean isAnagram(String s, String t) {
        //initial check
        if(s.length()!= t.length()) return false;

        int [] count = new int[26];

        //O(n)
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;  // increase for s
            count[t.charAt(i) - 'a']--;  // decrease for t
        }

        //O(n)
        for(int c :count){
            if(c!=0) return false;
        }

        return true;

    }
}

// Time: O(n)
// Space: O(1) (fixed size array = 26)

// | char | s count | t count | final |
// | ---- | ------- | ------- | ----- |
// | l    | +1      | -1      | 0     |
// | i    | +1      | -1      | 0     |
// | s    | +1      | -1      | 0     |
// | t    | +1      | -1      | 0     |
// | e    | +1      | -1      | 0     |
// | n    | +1      | -1      | 0     |

// This works only if:

// Characters are lowercase English letters (a–z) -not capital or large charset or unicode

// s.charAt(i) - 'a'
// It converts a character into an index (0–25)

// Because characters are stored as ASCII / Unicode values (numbers).
// | Character | ASCII Value |
// | --------- | ----------- |
// | 'a'       | 97          |
// | 'b'       | 98          |
// | 'c'       | 99          |
// | ...       | ...         |
// | 'z'       | 122         |


// char c = 'c';
// int index = c - 'a';

// 'c' = 99
// 'a' = 97
// 99 - 97 = 2 <- index