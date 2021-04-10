import java.util.HashMap;

class mulKey<key1,key2> {
    public key1 k1;
    public key2 k2;
    
    public mulKey(key1 k1, key2 k2) {
        this.k1 = k1;
        this.k2 = k2;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        mulKey key = (mulKey) o;
        if(k1 != null ? !k1.equals(key.k1) : key.k1 != null) return false;
        if(k2 != null ? !k2.equals(key.k2) : key.k2 != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = k1 != null ? k1.hashCode() : 0;
        result = 31 * result + (k2 != null ? k2.hashCode() : 0);
        return result;
    }
}

public class Solution {
 
    public static int solution(int n) {
        HashMap<Key, Integer> store = new HashMap<Key, Integer>();
        return numOfStairCases(1,n, store) - 1;
    }
    
    public static int numOfStairCases(int currStairHeight, int bricksLeft, HashMap<Key, Integer> store) {
        Key k = new Key(currStairHeight, bricksLeft);
        if(store.get(k) != null) {
            return arr[currStairHeight][bricksLeft];
         }
        if(bricksLeft == 0) return 1;
        if(bricksLeft < currStairHeight) return 0;
        int res =  numOfStairCases(currStairHeight + 1, bricksLeft - currStairHeight, store)
            + numOfStairCases(currStairHeight + 1, bricksLeft, store);
        store.put(k,res);
        return res;
    }
}