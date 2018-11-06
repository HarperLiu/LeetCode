package LRUCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    LinkedHashMap linkedHashMap;
    int capacity;
    Set<Integer> keys;
    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap(capacity,0.75f,true);
        this.capacity = capacity;
        keys = linkedHashMap.keySet();
    }

    public int get(int key) {
        if(linkedHashMap.containsKey(key)){
            return (int) linkedHashMap.get(key);
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        }
        else if(linkedHashMap.size()<capacity){
            linkedHashMap.put(key,value);
        }
        else{
            Iterator itr = keys.iterator();
            linkedHashMap.remove(itr.next());
            linkedHashMap.put(key,value);
        }

    }

    public void print(){
        Iterator<Map.Entry> iterator= linkedHashMap.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        //System.out.println(cache.get(1));       // returns 1
        //cache.put(3, 3);    // evicts key 2
        cache.print();
        //cache.get(2);
        //cache.print();
        /*
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
        */
    }

}
