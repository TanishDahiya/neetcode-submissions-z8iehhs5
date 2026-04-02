class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int itr : nums){
            map.put(itr, map.getOrDefault(itr,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k) minheap.poll();
        }

        int[] res = new int[k];
        int p =0;
        while(!minheap.isEmpty()){
            res[p++]=minheap.poll().getKey();
        }

        return res;
    }
}

// Brute approach :
// Finding the freq of each elements
// Sort in desc order
// select or store the first k elements
// Tc : O( n log n)

// Optimal : using Min Heap


/*
 * PROBLEM: Top K Frequent Elements
 * INPUT:  nums = [1, 1, 1, 2, 2, 3],  k = 2
 * OUTPUT: [1, 2]
 *
 * APPROACH: Min-Heap using Map.Entry<Integer,Integer>
 * ─────────────────────────────────────────────────────────────────
 * Instead of storing just the key in the heap and looking up its
 * frequency via the map, we store the ENTIRE Map.Entry (key + value)
 * directly in the heap. Cleaner — no map lookup inside comparator.
 *
 * Map.Entry looks like this:
 *   ┌──────────┬───────────┐
 *   │  getKey()│getValue() │
 *   │  (number)│ (freq)    │
 *   ├──────────┼───────────┤
 *   │    1     │     3     │
 *   │    2     │     2     │
 *   │    3     │     1     │
 *   └──────────┴───────────┘
 *
 * Time:  O(n log k)
 * Space: O(n + k)
 * ─────────────────────────────────────────────────────────────────
 */
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         int n = nums.length;   // n = 6

//         /*
//          * STEP 1 — Build frequency map
//          * ──────────────────────────────────────────────────────────
//          * One pass through nums. Each number becomes a key;
//          * its count is the value.
//          *
//          * nums = [1, 1, 1, 2, 2, 3]
//          *
//          * iteration 1 : itr=1 → map={1:1}
//          * iteration 2 : itr=1 → map={1:2}
//          * iteration 3 : itr=1 → map={1:3}
//          * iteration 4 : itr=2 → map={1:3, 2:1}
//          * iteration 5 : itr=2 → map={1:3, 2:2}
//          * iteration 6 : itr=3 → map={1:3, 2:2, 3:1}
//          *
//          * Final map:
//          *   ┌─────┬───────┐
//          *   │ key │ value │
//          *   ├─────┼───────┤
//          *   │  1  │   3   │  ← 1 appears 3 times
//          *   │  2  │   2   │  ← 2 appears 2 times
//          *   │  3  │   1   │  ← 3 appears 1 time
//          *   └─────┴───────┘
//          */
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int itr : nums) {
//             map.put(itr, map.getOrDefault(itr, 0) + 1);
//         }

//         /*
//          * STEP 2 — Create a MIN-HEAP of Map.Entry, ordered by VALUE (freq)
//          * ──────────────────────────────────────────────────────────────────
//          * Comparator: (a, b) -> a.getValue() - b.getValue()
//          *   → entry with SMALLER frequency floats to the root (top)
//          *   → root = weakest candidate, easiest to evict
//          *
//          * This is different from the previous approach which stored only
//          * the key and called map.get(key) inside the comparator.
//          * Here, the entry already carries its own frequency — no map lookup.
//          *
//          * Heap visual (root = smallest freq):
//          *
//          *       ROOT
//          *      ┌──────────────┐
//          *      │ key | freq   │  ← always the LEAST frequent
//          *      └──────────────┘
//          *       /            \
//          *  ┌─────────┐   ┌─────────┐
//          *  │k  | f   │   │k  | f   │
//          *  └─────────┘   └─────────┘
//          *
//          * Initial state: heap = []
//          */
//         PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>(
//             (a, b) -> a.getValue() - b.getValue()
//         );

//         /*
//          * STEP 3 — Feed each entry into the heap, evict if size > k
//          * ─────────────────────────────────────────────────────────────────
//          *
//          * map.entrySet() gives us all three entries to iterate.
//          *
//          * ── Entry {1,3} ──────────────────────────────────────────
//          * add({1,3})
//          *
//          *      [1|f=3]          size=1 ≤ k=2 → no eviction ✓
//          *
//          * ── Entry {2,2} ──────────────────────────────────────────
//          * add({2,2})
//          * min-heap reorders → smaller freq (2) rises to root
//          *
//          *      [2|f=2]          size=2 ≤ k=2 → no eviction ✓
//          *      /
//          *  [1|f=3]
//          *
//          * ── Entry {3,1} ──────────────────────────────────────────
//          * add({3,1})
//          * freq=1 is smallest → bubbles to root
//          *
//          *      [3|f=1]          size=3 > k=2 → poll() !
//          *      /      \
//          *  [2|f=2]  [1|f=3]
//          *
//          * poll() removes root {3,1} (least frequent → out)
//          *
//          *      [2|f=2]          size=2 = k → done ✓
//          *      /
//          *  [1|f=3]
//          *
//          * Survivors in heap:
//          *   ┌─────┬───────┐
//          *   │ key │ freq  │
//          *   ├─────┼───────┤
//          *   │  2  │   2   │  ← root (lower freq)
//          *   │  1  │   3   │
//          *   └─────┴───────┘
//          */
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             minheap.add(entry);
//             if (minheap.size() > k) minheap.poll();   // evict least frequent
//         }

//         /*
//          * STEP 4 — Drain the heap into result array
//          * ──────────────────────────────────────────────────────────
//          * heap = [{2,2}, {1,3}]   (root first = lowest freq first)
//          * p    = 0                (pointer to next empty slot in res)
//          *
//          * while heap not empty:
//          *
//          *   poll() #1 → entry {2,2} → getKey() = 2 → res[0] = 2,  p=1
//          *
//          *      heap before:        heap after:
//          *       [2|f=2]             [1|f=3]
//          *       /
//          *   [1|f=3]
//          *
//          *   poll() #2 → entry {1,3} → getKey() = 1 → res[1] = 1,  p=2
//          *
//          *      heap before:        heap after:
//          *       [1|f=3]             (empty)
//          *
//          * res = [2, 1]
//          *        ↑    ↑
//          *       p=0  p=1
//          *
//          * NOTE: order is lowest-freq first because it's a min-heap.
//          * The problem accepts any order, so this is fine.
//          */
//         int[] res = new int[k];
//         int p = 0;
//         while (!minheap.isEmpty()) {
//             res[p++] = minheap.poll().getKey();   // .getKey() extracts the number
//         }

//         /*
//          * FINAL TRACE — everything in one view
//          * ─────────────────────────────────────────────────────────────────
//          * nums    = [1, 1, 1, 2, 2, 3]
//          * map     = {1→3, 2→2, 3→1}
//          *
//          * heap log:
//          *   add {1,3}              heap=[{1,3}]            size=1 ✓
//          *   add {2,2}              heap=[{2,2},{1,3}]      size=2 ✓
//          *   add {3,1} + poll()     heap=[{2,2},{1,3}]      {3,1} evicted ✗
//          *
//          * drain log:
//          *   poll() → {2,2} → res[0]=2
//          *   poll() → {1,3} → res[1]=1
//          *
//          * result  = [2, 1]   ← both are top-2 most frequent ✓
//          *
//          * ─────────────────────────────────────────────────────────────────
//          * KEY DIFFERENCE vs previous approach (storing only key in heap):
//          *
//          *   Previous:  heap stores Integer (key)
//          *              comparator does map.get(a) - map.get(b)  ← map lookup
//          *
//          *   This code: heap stores Map.Entry (key + freq together)
//          *              comparator does a.getValue() - b.getValue() ← no lookup
//          *
//          *   Both are O(n log k). This version is slightly cleaner because
//          *   the entry is self-contained — no external map reference needed
//          *   inside the comparator.
//          * ─────────────────────────────────────────────────────────────────
//          */
//         return res;
//     }
// }