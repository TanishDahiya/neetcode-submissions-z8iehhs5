class Solution {
    public void rotateByPosition(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        rotateByPosition(nums,0,n-1);
        rotateByPosition(nums,0,k-1);
        rotateByPosition(nums,k,n-1);
        
    }
}




// 1 2 3 4 5 6 7 8 
// //reverse cmplt array
// 8 7 6 5 4 3 2 1
// //reverse the last k values
// 8 7 6 5 1 2 3 4
// //reverse the k+1 values from the last
// 5 6 7 8 1 2 3 4

// if k > length then edge case handle for optimization


// 1 2 3 4 5 6 7
// 7 6 5 4 3 2 1
// 5 6 7 
