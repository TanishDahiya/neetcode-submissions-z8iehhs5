class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                int index = map.get(nums[i]);
                int result = Math.abs(index - i);
                if(result <= k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }
            
        }

        return false;
    }
}


// Map approach

// 1. Iterate over the array and put into the hashmap
//     key -> arr value
//     value - > arr index
// 2. if already present then check the conditon if not then add into the map    