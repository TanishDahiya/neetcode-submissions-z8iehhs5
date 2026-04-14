class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;

        while(left < right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }
            else if(numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }
        }

        return new int[]{-1,-1};
    }
}
