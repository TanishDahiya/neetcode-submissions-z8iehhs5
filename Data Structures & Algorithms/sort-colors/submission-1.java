class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;  
            }else{
                count2++;
            }
        }

        for(int i =0;i<count0;i++){
            nums[i]=0;
        }
        for(int i =count0;i<count0+count1;i++){
            nums[i]=1;
        }   
        for(int i =count0+count1;i<n;i++){
            nums[i]=2;
        }                
    }
}


// Merge Sort ( BRUTE)
// Time: O(n log n)
// Space: O(n) ❌

//Count Array ( Better)
// TC: O(2n)
// Sc : O(1)

//Optimal -> Dutch National Flag Algorithm (3 pointers) because it only coantains 0,1,2
// Time: O(n)
// Space: O(1) ✅