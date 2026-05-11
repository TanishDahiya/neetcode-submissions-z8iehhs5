class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}


// Previous approach O(n log n) + O(n) ~= O(n log n)
// Current TC :O(n) space: O(n)