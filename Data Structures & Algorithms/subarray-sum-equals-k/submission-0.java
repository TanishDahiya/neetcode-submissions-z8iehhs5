class Solution {
    public int subarraySum(int[] nums, int k) {
        int n =nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        // initialize
        map.put(0,1);

        int prefixSum = 0;
        int resultCount = 0;

        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum-k)){
                resultCount += map.get(prefixSum-k);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return resultCount;
    }
}