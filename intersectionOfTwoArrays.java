import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int binarySearch(int arr[], int left, int right, int num) {
        if(right >= left) {
            int mid = (left + right)/2;
            if(arr[mid] == num) 
                return mid;
            else if(arr[mid] > num) {
                right = mid-1;
                return binarySearch(arr, left, right, num);
            }else {
                left = mid+1;
                return binarySearch(arr, left, right, num);
            }
        }
        return -1;
    }
	public static void main (String[] args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    int arrA[] = new int[N];
		    int arrB[] = new int[M];
		    Set<Integer> arrI = new HashSet<Integer>();
		    for(int j=0;j<N;j++) {
		        arrA[j] = sc.nextInt();
		    }
		    for(int j=0;j<M;j++) {
		        arrB[j] = sc.nextInt();
		    }
		    if(arrA.length < arrB.length) {
		        Arrays.sort(arrA);
		        for(int j=0;j<M;j++) {
		          if(binarySearch(arrA, 0, N-1, arrB[j]) != -1) {
		              arrI.add(arrB[j]);
		          }
		        }
		    } else {
		        Arrays.sort(arrB);
		        for(int j=0;j<N;j++) {
		          if(binarySearch(arrB, 0, M-1, arrA[j]) != -1) {
		              arrI.add(arrA[j]);
		          }
		        }
		        
		    }
		    System.out.println(arrI.size());
		}
	}
}