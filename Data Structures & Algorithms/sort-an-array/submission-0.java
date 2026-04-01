class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        helper(nums,low,high);
        return nums;
    }
     void helper(int[] nums, int low, int high){
        if(low<high){ // just a check array does not have one element
            int index= partition(nums, low, high);
            helper(nums, low, index-1);
            helper(nums, index+1, high);
        }
    }

    int partition(int[] arr, int low, int high){
        int i=low;
        int j=high;
        int pivot=arr[low];

        while(i<j){
            while(i<=high&& arr[i]<= pivot ) i++;
            while(j>=low && arr[j]>pivot) j--;

            if(i<j){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }

        }

        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
}