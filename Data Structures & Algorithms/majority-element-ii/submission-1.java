class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = 0;
        int ele2 = 0;
        int count1 = 0;
        int count2 = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){

            if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }else if(count1==0){
                ele1 = nums[i];
                count1 =1;
            }else if(count2==0){
                ele2 = nums[i];
                count2 =1;
            }else{
                count1--;
                count2--;
            }
        }

        int freq1 = 0;
        int freq2 = 0;
        for(int i =0;i<n;i++){
            if(nums[i]==ele1) freq1++;
            if(nums[i]==ele2) freq2++;
        }

        if(freq1 > n/3) list.add(ele1);
        if(freq2 > n/3) list.add(ele2);

        return list;

    }
}

// BRUTE FORCE - HASHMAP
    //Put all values in hashmap along with freq
    // Then check value greter than n/3

// n/3 we have to find, in best case 2 elements we can found
// n/k =  k-1(max in best case)