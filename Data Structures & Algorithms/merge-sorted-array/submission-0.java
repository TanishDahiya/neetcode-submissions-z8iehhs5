class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = (m+n)-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
}




// Three pointers Appproach
// Imp -> Do not Merge from the front, merge from the back

// i → last valid element in nums1 (m-1)
// j → last element in nums2 (n-1)
// k → last position of nums1 (m+n-1)

// Step-by-step:
// Compare 40 vs 2 → put 40 at end
// [10,20,20,40,0,40]
// Compare 20 vs 2 → put 20
// [10,20,20,40,20,40]
// Compare 20 vs 2 → put 20
// [10,20,20,20,20,40]
// Compare 10 vs 2 → put 10
// [10,20,10,20,20,40]
// Now nums1 done, copy remaining nums2:
// [1,2,10,20,20,40]