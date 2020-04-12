import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
		    String str = sc.nextLine();
		    int n = Integer.parseInt(sc.nextLine());
		    String []arr = new String[n];
		    Arrays.fill(arr,"");
		    int len = str.length();
		    int r=0;
		    boolean goDown = true;
		    for(int j=0;j<len;j++) {
		        arr[r] += str.charAt(j);
		        if(r==0) {
		            goDown = true;
		        }
		        if(r==n-1) {
		            goDown = false;
		        }
		        if(goDown && r<n) {
		            r++;
		        }else if(r>0){
		            r--;
		        }
		    }
		    for(int j=0;j<n;j++) {		    
		        System.out.print(arr[j]);
		    }
		     System.out.println();
		}
	}
}