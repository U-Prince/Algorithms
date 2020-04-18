import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
		    String str = sc.nextLine();
		    System.out.println(longestPalindromeSubsequence(str.toCharArray(), 0, str.length()-1));
		}
	}
	
	static int max(int x, int y) {
	    return x > y ? x : y;
	}
	
	static int longestPalindromeSubsequence(char str[], int start, int end) {
	    if(start == end) {
	        return 1;
	    }
	    if((end == start+1) && (str[start] == str[end])) {
	        return 2;
	    }
	    if(str[start] == str[end]) {
	        return longestPalindromeSubsequence(str, start+1, end-1) + 2;
	    }
	    return max(longestPalindromeSubsequence(str, start, end-1),longestPalindromeSubsequence(str, start+1, end));
	}
}