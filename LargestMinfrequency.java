

import java.util.*;



 
class Geeks
{
   
    public static int LargButMinFreq(int arr[], int n)
    {
         TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();  
         for(int i=0;i<n;i++) {
             
             if( map.get(arr[i]) != null) {
                 map.put(arr[i],  map.get(arr[i])+1);
             } else {
                 map.put(arr[i], 1);
             }
             
         }
         int min = n+1,k = arr[0];
         NavigableMap<Integer, Integer> nmap = map.descendingMap();
          for(NavigableMap.Entry m:nmap.entrySet()){
              if(m.getValue().equals(1)) {
                  k = (Integer) m.getKey();
                  return k;
              } else {
                  if((Integer) m.getValue() < min) {
                      min = (Integer) m.getValue();
                      k = (Integer) m.getKey();
                  }
              }   
          }   
        return k;
    }
}


class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    
		    for(int i = 0; i < n; i++)
		     arr[i] = sc.nextInt();
		     
		    Geeks obj = new Geeks();
		    System.out.println(obj.LargButMinFreq(arr, n));
		}
	}
} 