class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][]arr = new double[n][2];
        int count = 0;
        double prevSpeed = 0;

        for(int i =0 ;i < n;i++){
            arr[i][0] = position[i];
            arr[i][1] = (double)(target - position[i] )/speed[i];
        }

        Arrays.sort(arr, (a,b) -> Double.compare(b[0], a[0]) );

        for(double []itr : arr){
            if(itr[1] > prevSpeed ){
                count++;
                prevSpeed = itr[1] ;
            }
        }

        return count;
    }
}


// 1.  create 2d array, to store position and speed
// 2.  sort the array
// 3. then if current speed is > prev count++
