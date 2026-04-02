class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low=0;
        int mid =0;
        int high = n-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}



// 0 ->low-1 = 0 (extremely left)
// low->mid-1 = 1
// mid->high = 0/1/2 ( random numbers)
// high+1->n-1 = 2 ( extremely right)

// 0    l-1 l     m-1   m       h h+1     n-1
// 0 0 0 0  1 1 1  1    0 1 2 0 1  2  2 2 2
//                     swp with l ( because that is first element of 1)
//    if mid[i]==0     swap (a[low],a[mid]) low++ mid++
//    if mid[i]==1 mid++
//    if mid[i]==2     swap(a[mid], a[high]) high --