class MyHashSet {

    List<Integer> list ; // single list

    public MyHashSet() {
        list = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list.add(null); // intial assigning all values to null
        }
    }
    
    public void add(int key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key) return; // checking if already exist then we can not add
        }
        list.add(key);
    }
    
    public void remove(int key) {
        for(int i =0;i<list.size();i++){
            if(list.get(i)== key) list.remove(i); // if exist then removing the index
        }
    }
    
    public boolean contains(int key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key) return true;
        }

        return false;
    }
}

// HashSet only contains unique elements