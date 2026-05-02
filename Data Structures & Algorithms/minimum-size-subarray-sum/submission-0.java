class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int currentWindowSum = 0;
        int length = 1000;
        int i = 0;
        int j = 0;
        while(j<n){
            currentWindowSum += nums[j];
            if(currentWindowSum >= target){
                length = Math.min(j-i+1, length);
                currentWindowSum -= nums[i];
                currentWindowSum -= nums[j];
                i++;
                
            }else{
                j++;
            }
            
        }

        if(length == 1000) return 0;
        return length;
    }
}


// currentWindowSum = 6   length = 3

//           i
// // [2,1,5,1,5,3] target = 10
//                 j



