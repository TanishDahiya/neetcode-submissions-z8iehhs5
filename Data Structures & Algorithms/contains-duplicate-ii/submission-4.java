class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j = 0;
        while(j<n){

            if(j-i > k){
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j])){
                return true;
            }else{
                set.add(nums[j]);
            }

            j++;
        }

        return false;
    }
}

//           i  j
// nums = [2,1,2], k = 1       set =1,2   i=0  j=2
// 1.  0 >1
// 2.  1 > 1
// 3.  2 > 1


//            i     j
// // nums = [1,2,3,1], k = 3.      set = 1,2,3   i=0   j = 3
// 1.  0 > 3
// 2. 1 > 3
// 3. 2 > 3
// 4. 3 > 3