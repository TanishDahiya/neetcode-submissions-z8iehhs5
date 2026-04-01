class MyHashMap {
    private final int ARRAY_SIZE = 100;
    private List<List<int[]>> parent;
    public MyHashMap() {
        parent = new ArrayList<>(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            parent.add(null);
        }
    }
    
    public void put(int key, int value) {
        int hash = key%ARRAY_SIZE;
        List<int[]> child = parent.get(hash);
        if(child == null){
            List<int[]> list = new LinkedList<>();
            list.add(new int[]{key,value});
            parent.set(hash,list);
        }else{
            for(int[] pair : child){
                if(pair[0] == key){
                    pair[1]=value;
                    return;
                } 
            }
            child.add(new int[]{key,value});
        }
    }
    
    public int get(int key) {
        int hash = key%ARRAY_SIZE;
        List<int[]> child = parent.get(hash);
        if (child == null) return -1;
        for(int[] pair : child){
            if(pair[0]==key) return pair[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key%ARRAY_SIZE;
        List<int[]> child = parent.get(hash);
        if(child == null) return;
        for(int i=0;i<child.size();i++){
            if(child.get(i)[0]==key){
                child.remove(i);
                return;
            } 
        }
    }
}

/**
 | Approach | Time     | Space        |
| -------- | -------- | ------------ |
| Array    | O(1)     | O(n) ❌ large |
| Bucket   | O(1) avg | O(n) ✅       |

 */