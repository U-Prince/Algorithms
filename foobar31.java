import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int res =Solution(17,4);
	    System.out.println(res);
	}
	
	public static int Solution(int start, int length) {
	    int res = 0;
	   for(int i = length ; i > 0 ; i--) {
	        for(int j=start;j < start+i;j++) {
	            res = res  ^ j;
	        }
	        start += length;
	   }
	   return res;
	}
}
