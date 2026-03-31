class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore algo approach
        int n= nums.length;
        int ele = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            if(count == 0){
                ele = nums[i];
                count = 1;
            } 
            if(nums[i] == ele){
                count++;
            }else{
                count--;
            }

        }

        // if we are not sure majority element exist or not
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele) {
                cnt1++;
            }
        }
        
        // Return element if it is a majority element
        if (cnt1 > (n / 2)) {
            return ele;
        }


        return -1;
    }
}


// DRY RUN
// [5,5,1,1,1,5,5]
// ele = 5   count =1
// i=1   count!=0   nums[i]==ele count =2
// i=2.  count!=0.  nums[i]!=ele count =1
// i=3.  count!=0.  nums[i]!=ele count =0.  [5,5,1,1] not greater than n/2 that is obvious and that is moore's algo ( because of 2 five and 2 ones)
//.............
