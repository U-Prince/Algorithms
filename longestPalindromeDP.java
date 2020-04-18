
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
		    String str = sc.nextLine();
		    System.out.println(longestPalindromeSubsequence(str.toCharArray(), str.length()));
		}
	}
	
	static int max(int x, int y) {
	    return x > y ? x : y;
	}
	
	static int longestPalindromeSubsequence(char str[], int len) {
	    int arr[][] = new int[len][len];
	    
	    for(int i=0;i<len;i++) {
	        arr[i][i] = 1;
	    }
	    
	    int i,j,k;
	    
	    for(k = 2;k<=len;k++) {
	        for(i=0;i<len-k+1;i++) {
	            j = i+k-1;
	            
	            if(str[i]==str[j] && k==2) {
	                arr[i][j] =2;
	            }else if(str[i]==str[j]) {
	                arr[i][j] = arr[i+1][j-1] + 2;
	            }else {
	                arr[i][j] = max(arr[i][j-1], arr[i+1][j]);
	            }
	        }
	    }
	    return arr[0][len-1];
	}
}