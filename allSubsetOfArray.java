/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int j=0;j<n;j++) {
		        arr[j] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    Set<String> tree_Set = new TreeSet<String>(); 
		    int totalPossibleElements = (int)Math.pow(2,n);
		    for(int j=0;j<totalPossibleElements;j++) {
		        StringBuilder sb = new StringBuilder("");
		        for(int k=0;k<n;k++) {
		            if((j & (1<<k))>0) {
		                sb.append(arr[k]+" ");
		            }
		        }
		        if (sb.length() > 0) {
                   sb.setLength(sb.length() - 1);
                }
		        String s = sb.toString();
		        tree_Set.add(s.trim());
		    }
		     Iterator<String> itr=tree_Set.iterator();  
		      
              while(itr.hasNext()){  
               System.out.print("("+itr.next()+")");  
              } 
             System.out.println(); 
		}
	}
}