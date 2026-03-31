class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String i: strs){
            //sorting
            char[] c = i.toCharArray(); // convert strint to char array
            Arrays.sort(c);    // sort the array
            String key = new String(c); // again convert it to the string

            if(!map.containsKey(key)) map.put(key,new ArrayList<String>()); //checking in map
            //map.putIfAbsent(key, new ArrayList<>()); - we can also write cleaner approach
            map.get(key).add(i);
        }

        return new ArrayList<>(map.values());
    }
}
// Time:
// Sorting each word → O(k log k)
// For n words:
// ==>TC :  O(n * k log k)

// n = number of strings
// k = average length of each string
// ==> SC : 0(n*m)
