class Solution {
    public int longestConsecutive(int[] nums) {
        int longestCount = 0;
        int n = nums.length;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num,Boolean.FALSE);
        }

        for(int i=0;i<n;i++){
            int currentCount = 1; 
            int nextele = nums[i]+1;
            while(map.containsKey(nextele) && map.get(nextele)==false){
                currentCount++;
                // next ele
                map.put(nextele,Boolean.TRUE);
                nextele++;
            }

            int prevele = nums[i]-1;
            while(map.containsKey(prevele) && map.get(prevele)==false){
                currentCount++;
                // next ele
                map.put(nextele,Boolean.TRUE);
                prevele--;
            } 

            longestCount =  Math.max(longestCount,currentCount);              
            
        }

        return longestCount;
    }
}
