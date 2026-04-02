class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        List<Integer>[] bucket = new ArrayList[n+1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int itr : nums){
            map.put(itr, map.getOrDefault(itr,0)+1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i=n;i>=0;i--){
            if (index == k) break;
            if(bucket[i]!=null){
                for(int itr : bucket[i]){
                    res[index++]=itr;
                    if(index==k) break;
                }
                
            }
        }

        return res;
    }
}
// TC :O(n) SC:O(n)
/*
 * PROBLEM: Top K Frequent Elements
 * INPUT:  nums = [1, 1, 1, 2, 2, 3],  k = 2
 * OUTPUT: [1, 2]
 *
 * APPROACH: Bucket Sort by Frequency
 * ─────────────────────────────────────────────────────────────────
 * Key Insight: A number can appear at most n times (n = nums.length).
 * So we create n+1 buckets where bucket[i] holds all numbers
 * that appear exactly i times.
 * Then we scan buckets from high freq → low freq and pick top k.
 * ─────────────────────────────────────────────────────────────────
 * Time:  O(n)  — no sorting needed!
 * Space: O(n)  — bucket array + frequency map
 */

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         int n = nums.length;  // n = 6

//         /*
//          * STEP 1 — Create the bucket array
//          * ─────────────────────────────────
//          * bucket has n+1 = 7 slots (indices 0 to 6)
//          * Each slot will hold a List of numbers with that frequency.
//          * All slots start as null.
//          *
//          * bucket index = frequency of a number
//          *
//          * bucket[0] → null   (frequency 0 — never used)
//          * bucket[1] → null
//          * bucket[2] → null
//          * bucket[3] → null
//          * bucket[4] → null
//          * bucket[5] → null
//          * bucket[6] → null
//          */
//         List<Integer>[] bucket = new ArrayList[n + 1];

//         /*
//          * STEP 2 — Build frequency map
//          * ─────────────────────────────
//          * map.getOrDefault(itr, 0) + 1
//          *   → if key exists, increment its count
//          *   → if key is new,  start count at 1
//          *
//          * After loop:
//          * ┌─────┬───────┐
//          * │ key │ count │
//          * ├─────┼───────┤
//          * │  1  │   3   │
//          * │  2  │   2   │
//          * │  3  │   1   │
//          * └─────┴───────┘
//          */
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int itr : nums) {
//             map.put(itr, map.getOrDefault(itr, 0) + 1);
//         }

//         /*
//          * STEP 3 — Place each number into its frequency bucket
//          * ──────────────────────────────────────────────────────
//          * For each entry in map:
//          *   freq = map.get(key)
//          *   → create a new ArrayList at bucket[freq] if null
//          *   → add the number to bucket[freq]
//          *
//          * Iteration 1: key=1, freq=3  → bucket[3] = [1]
//          * Iteration 2: key=2, freq=2  → bucket[2] = [2]
//          * Iteration 3: key=3, freq=1  → bucket[1] = [3]
//          *
//          * Final bucket state:
//          *
//          * index │ bucket[index]
//          * ──────┼──────────────
//          *   0   │ null
//          *   1   │ [3]          ← number 3 appears 1 time
//          *   2   │ [2]          ← number 2 appears 2 times
//          *   3   │ [1]          ← number 1 appears 3 times
//          *   4   │ null
//          *   5   │ null
//          *   6   │ null
//          */
//         for (int key : map.keySet()) {
//             int freq = map.get(key);
//             if (bucket[freq] == null) {
//                 bucket[freq] = new ArrayList<>();
//             }
//             bucket[freq].add(key);
//         }

//         /*
//          * STEP 4 — Collect top k from buckets (high freq → low freq)
//          * ─────────────────────────────────────────────────────────────
//          * We scan from i=n down to i=0.
//          * We stop as soon as we've collected k elements.
//          *
//          * res   = [_, _]     (k=2 slots)
//          * index = 0          (points to next empty slot in res)
//          *
//          * i=6 → bucket[6] = null  → skip
//          * i=5 → bucket[5] = null  → skip
//          * i=4 → bucket[4] = null  → skip
//          * i=3 → bucket[3] = [1]   → res[0] = 1,  index=1
//          * i=2 → bucket[2] = [2]   → res[1] = 2,  index=2
//          * index == k (2 == 2)     → break!
//          *
//          * res = [1, 2]   ✓
//          *
//          * Why scan high → low?
//          * Higher index = higher frequency = more "frequent" element.
//          * We want the most frequent first.
//          */
//         int[] res   = new int[k];
//         int index   = 0;
//         for (int i = n; i >= 0; i--) {
//             if (index == k) break;                // collected enough, stop
//             if (bucket[i] != null) {
//                 for (int itr : bucket[i]) {
//                     res[index++] = itr;
//                     if (index == k) break;        // inner early exit
//                 }
//             }
//         }

//         /*
//          * FINAL STATE
//          * ────────────────────────────────────
//          * nums        = [1, 1, 1, 2, 2, 3]
//          * freq map    = {1→3, 2→2, 3→1}
//          * buckets     = [null, [3], [2], [1], null, null, null]
//          * scan order  = index 6 → 5 → 4 → 3✓ → 2✓ → stop
//          * result      = [1, 2]
//          */
//         return res;
//     }
// }