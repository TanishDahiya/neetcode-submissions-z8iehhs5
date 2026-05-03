class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length-1;

        while(right-left+1 > k){
            //shrink window

                if(Math.abs(arr[left]-x) > Math.abs(arr[right]-x)) {
                    left++;
                }else{
                    right--;
                }

        }

        for(int i = left; i<=right ;i++){
            list.add(arr[i]);
        }

        return list;

    }
}

// arr=[1,3,5,7,9] k=3 x=6

//   i   j
// 1,3,5,7,9  5 > 3  