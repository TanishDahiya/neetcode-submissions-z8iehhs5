class Solution {
    public void sortColors(int[] nums) {
        int n =nums.length;
        int low = 0;
        int high = n-1;

        mergeSort(nums,low, high);
    }

    private void mergeSort(int[] nums, int low, int high){

        int mid = (low+high)/2;
        if(low<high){
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }

    }

    private void merge(int[] nums,int low, int mid, int high ){

        List<Integer> list = new ArrayList<>();
        int i =low;
        int j = mid+1;
        while(i<=mid && j <= high){
            if(nums[i]<=nums[j]){
                list.add(nums[i]);
                i++;
            }else{
                list.add(nums[j]);
                j++;
            }
        }

        while(i<=mid){
            list.add(nums[i]);
            i++;
        }

        while(j<=high){
            list.add(nums[j]);
            j++;
        }

        int p =low;
        for(int k : list){
            nums[p++]=k;
        }
    }


}