class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s1 : strs){

            int[] count = new int[26];  //Integer Fixed Size Array
            char[] c = s1.toCharArray(); // Converted to char array
            for(char c1 : c){
                count[c1-'a']++;        // increasing the indexes
            }
            StringBuilder st = new StringBuilder();
            for(int i :count){
                st.append(i);       // creting has values
                st.append('#');
            }

            String key = st.toString();
            if(!map.containsKey(key)) map.put(key,new ArrayList<String>());
            map.get(key).add(s1); // add into the list of hashmap
        }

        return new ArrayList<>(map.values());
    }
}

// Array Strings
// create count integer array
// choose each string and create a hash value for that
// Put hash value as a key in map along with values

// 1. Loop over all strings
// for (String s1 : strs)

// 👉 Runs n times

// 2. Count characters in each string
// for (char c1 : s1.toCharArray())

// 👉 Takes O(k)
// (k = length of each string)

// 3. Build key (26 letters)
// for (int i : count)

// 👉 Always 26 iterations → O(1)

// 🔥 Total Time
// O(n * k)


// 1. HashMap storage
// Map<String, List<String>> map
// What we store:
// All n strings
// Each string length ≈ k
// O(n * k)
// 2. Keys (frequency string)

// Each key length ≈ 26 numbers + separators → constant

// O(n)
// 3. Count array
// int[] count = new int[26];

// 👉 Constant space → O(1)

// 🔥 Total Space
// O(n * k)