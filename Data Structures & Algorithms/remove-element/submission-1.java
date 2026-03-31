class Solution {
    public int removeElement(int[] nums, int val) {
        //swap method
        // less writes and memory efficent approach
        // TC: O(n) SC :O(1)
        int i=0;
        int n = nums.length;
        while(i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1]; // swap with last element
                n--;
            }else{
                i++;
            }
        }

        return n;
    }
}

// Dry Run
// while i<n (0<5)
// nums = [1,1,2,3,4], val = 1
// i->0  1==1 yes swap [4,1,2,3,1] n-- (n=4)

// while i<n (0<4)
// i->0  4==1 no i++
// i->1  1==1 yes swap [4,3,2,1,1] n-- (n=3)

// while i<n (1<3)
// i->1  3==1 no i++
// i->2  2==1 no i++

// i->3   while i<n (3<3) false

// return n that is 3