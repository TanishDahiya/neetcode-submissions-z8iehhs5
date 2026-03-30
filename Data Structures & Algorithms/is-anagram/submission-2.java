class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n!=m) return false;

        Map<Character, Integer> map = new HashMap<>(); //Default size 16, ig filled 75% then doubled up

        for(char c : s.toCharArray() ){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray() ){

            if(!map.containsKey(c)) return false;   //containsKey

            map.put(c,map.get(c)-1);

            if(map.get(c)==0) map.remove(c);    //remove
        }

        return map.isEmpty();     //isEmpty

    }
}


// Time complexity is O(n) with O(n) space due to HashMap storing character frequencies."
// | Approach      | Time       | Space | Reliable |
// | ------------- | ---------- | ----- | -------- |
// | Sorting       | O(n log n) | O(n)  | ✅        |
// | HashMap       | O(n)       | O(n)  | ✅        |
// | Frequency arr | O(n)       | O(1)  | ✅ (best) |
// | XOR trick     | O(n)       | O(1)  | ❌        |


// int xor = 0;

// for (char c : s.toCharArray()) xor ^= c;
// for (char c : t.toCharArray()) xor ^= c;

// return xor == 0;

// "abc" ^ "abc" = 0 ✅

// ❌ Why it FAILS (IMPORTANT)
// s = "aab"
// t = "abb"
// a ^ a ^ b ^ a ^ b ^ b
// (a ^ a) → 0
// (b ^ b) → 0

// Left: a ^ b ≠ 0 ❌ (inconsistent behavior)