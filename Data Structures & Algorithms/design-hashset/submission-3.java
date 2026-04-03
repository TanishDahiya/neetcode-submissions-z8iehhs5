class MyHashSet {

    private final int ARRAY_SIZE = 100; // initialize the array size
    private List<List<Integer>> parent;  // created a list 

// parent:
// Index:    0      1      2      3      4      5
//         null   null   null   null   null   null
    public MyHashSet() {
       parent = new ArrayList<>(ARRAY_SIZE);   
       for(int i=0;i<ARRAY_SIZE;i++){ 
        parent.add(null);
       }
    }
    // finding hash value  example 5
    // List<Integer> child = parent.get(5);
    // parent[5] = null
    // child = null
    // List<Integer> child = null
    // child ───────▶ null
    // List<Integer> list = new LinkedList<>();
    // list.add(105);
    // parent.set(5, list);
//   Index:    0      1      2      3      4      5
//         null   null   null   null   null   ↓
//                                              [105]
// parent[5] ───────▶ [105]

// child ───────────▶ [105]
    public void add(int key) {
        int hash = key % ARRAY_SIZE;  
        List<Integer> child = parent.get(hash); 

        if(child == null) {
            child = new LinkedList<>();
            child.add(key);
            parent.set(hash, child);
        } else {
            if(!child.contains(key)) child.add(key);
        }
    }
    
    public void remove(int key) {
        int hash = key % ARRAY_SIZE;
        List<Integer> child = parent.get(hash);
        if(child != null) child.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int hash = key % ARRAY_SIZE;
        List<Integer> child = parent.get(hash);
        return child != null && child.contains(key);
    }
}

// 🧠 The Problem

// You wrote:

// childList.remove(key);

// 👉 Looks correct, but it’s NOT doing what you think

// 🔥 Why?

// Because List has two remove methods:

// remove(int index)      // removes by index
// remove(Object o)       // removes by value
// ❌ What happens with your code?
// childList.remove(key);

// 👉 key is int

// 👉 Java chooses:

// remove(int index)
// 🧪 Example
// List<Integer> list = [105, 205, 305];
// list.remove(205);

// 👉 Java thinks:

// remove element at index 205 ❌

// 👉 Result:

// IndexOutOfBoundsException ❌
// ✅ Correct Way
// childList.remove(Integer.valueOf(key));
// 🔍 Why this works
// Integer.valueOf(key)

// 👉 Converts:

// int → Integer (object)

// Now Java chooses:

// remove(Object o) ✅
