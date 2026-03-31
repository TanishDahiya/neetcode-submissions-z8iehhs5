class Solution {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]!= val){
                nums[k]=nums[i] ;
                k++;
            } 
        }

        return k;
    }
}

// Dry Run
// nums = [1,1,2,3,4], val = 1

// i=0 → skip
// i=1 → skip
// i=2 → nums[0]=2
// i=3 → nums[1]=3
// i=4 → nums[2]=4

// nums = [2,3,4,...]
// k = 3


//TC : O(n)
//SC : O(1)