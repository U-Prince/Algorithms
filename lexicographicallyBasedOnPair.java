import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());   
        for(int i=0;i<t;i++) {
            String arr[] = s.nextLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int K = Integer.parseInt(arr[1]);1
            String S = s.nextLine();
            StringBuilder sb = new StringBuilder(S);
            String T = s.nextLine();
            StringBuilder st = new StringBuilder(T);
            HashMap<Integer, ArrayList<Integer>> m= new HashMap<Integer, ArrayList<Integer>>();
            for(int j=0;j<K;j++) {
                String parr[] = s.nextLine().split(" ");
                int p1 = Integer.parseInt(parr[0]);
                int p2 = Integer.parseInt(parr[1]);
                ArrayList temp = null;
                if(m.containsKey(p1)) {
                    temp = m.get(p1);
                } else {
                    temp = new ArrayList();
                }
                temp.add(p2);
                m.put(p1, temp);
            }
            for(int k=0;k<N;k++) {
                char min = sb.charAt(k);
                if(T.charAt(k)<min){
                    min = T.charAt(k);
                }
                ArrayList temp = m.get(k);
                if(temp == null) {}
                else {
                    for(int al = 0; al < temp.size();al++) {
                        int ind = (int)temp.get(al);
                        System.out.println("ind===" + ind);
                        System.out.println("T.charAt(ind) ===" + T.charAt(ind) + " min==" + min);
                        System.out.println("res=== " + (T.charAt(ind) < min));
                        if(T.charAt(ind) < min) {
                            min = T.charAt(ind);
                            System.out.println("inside if=== " + min);
                        }
                    }
                }
                sb.setCharAt(k, min);
            }
            System.out.println(sb);
            // for(Map.Entry<Integer, ArrayList<Integer>> ee : m.entrySet()) {
            //     int k  = ee.getKey();
            //     List<Integer> v = ee.getValue();
            //     System.out.println("key==" + k + ", value==" + v); 
            // }
            
        }             
           

        

        // Write your code here

    }
}


import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    List<List<Integer>> ls = new ArrayList<List<Integer>>();
	    
	    List<Integer> list1 = new ArrayList<Integer>();
	    list1.add(0);
	    list1.add(1);
	    List<Integer> list2 = new ArrayList<Integer>();
	    list2.add(1);
	    list2.add(2);
	    List<Integer> list3 = new ArrayList<Integer>();
	    list3.add(3);
	    list3.add(4);
	    List<Integer> list4 = new ArrayList<Integer>();
	    list4.add(4);
	    list4.add(5);
	   //  List<Integer> list5 = new ArrayList<Integer>();
	   // list5.add(4);
	   // list5.add(6);
	    
	    ls.add(list1);
	    ls.add(list2);
	    ls.add(list3);
	    ls.add(list4);
	   // ls.add(list5);
	    
	    StringBuilder sb = new StringBuilder("abagfiab");
	    StringBuilder st = new StringBuilder("cbacbcda");
	    
	    for(int k=0;k<8;k++) {
                char t = sb.charAt(k);
                String res = smallestStringWithSwaps(st.toString(),ls);
                System.out.print("res==" + res);
                if(st.charAt(k)<t){
                    sb.setCharAt(k, st.charAt(k));
                    st.setCharAt(k, t);
                }
                
            }
	    
	   // System.out.println("Hello World"+ls.getClass().getSimpleName());
	    //String res = smallestStringWithSwaps("cbacbcda",ls);
		System.out.println();
		System.out.println(sb);
	}
	
	public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
        for (List<Integer> p : pairs) {
            //System.out.print("p==" + p);
            union(root, p.get(0), p.get(1));
        }
        
        for (int i = 0; i < n; ++i) System.out.print(root[i] + " ");
        
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < n; ++i) {
            int head = findRoot(root, i);
            root[i] = head;
            if (!map.containsKey(head)) map.put(head, new PriorityQueue<Character>());
            map.get(head).add(s.charAt(i));
            System.out.print("map===" + map.get(head));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append(map.get(root[i]).poll());
        return sb.toString();
    }

    private static int findRoot(int[] root, int i) {
        if (root[i] == i) return i;
        int r = findRoot(root, root[i]);
        root[i] = r;
        return r;
    }
    
    private static void union(int[] root, int src, int dst) {
        int srcRoot = findRoot(root, src);
        int dstRoot = findRoot(root, dst);
        if (srcRoot != dstRoot) root[srcRoot] = dstRoot;
    }

}




/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int n = 8;
	    List<List<Integer>> ls = new ArrayList<List<Integer>>();
	    
	    List<Integer> list1 = new ArrayList<Integer>();
	    list1.add(0);
	    list1.add(1);
	    List<Integer> list2 = new ArrayList<Integer>();
	    list2.add(1);
	    list2.add(2);
	    List<Integer> list3 = new ArrayList<Integer>();
	    list3.add(3);
	    list3.add(4);
	    List<Integer> list4 = new ArrayList<Integer>();
	    list4.add(4);
	    list4.add(5);
	   //  List<Integer> list5 = new ArrayList<Integer>();
	   // list5.add(1);
	   // list5.add(6);
	    
	    ls.add(list1);
	    ls.add(list2);
	    ls.add(list3);
	    ls.add(list4);
	   // ls.add(list5);
	    
	    StringBuilder sb = new StringBuilder("abagfiab");
	    StringBuilder st = new StringBuilder("cbacbcda");
	    
	    int[] root = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
	    
	    HashMap<Integer, PriorityQueue<Character>> map = createConnectedComponents(st.toString(), ls, root);
	    
	    for(int k=0;k<8;k++) {
                char b = sb.charAt(k);
                char t = map.get(root[k]).poll();
                if(t<b){
                    sb.setCharAt(k,  t);
                    t = b;
                }
                
                int head = findRoot(root, k);
                root[k] = head;
                if (!map.containsKey(head)) map.put(head, new PriorityQueue<Character>());
                map.get(head).add(t);
            }
	    
		System.out.println();
		System.out.println(sb);
	}
	
	public static HashMap<Integer, PriorityQueue<Character>> createConnectedComponents(String s, List<List<Integer>> pairs, int[] root) {
        int n = s.length();
        
        for (List<Integer> p : pairs) {
            union(root, p.get(0), p.get(1));
        }
        
        
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < n; ++i) {
            int head = findRoot(root, i);
            root[i] = head;
            if (!map.containsKey(head)) {
                map.put(head, new PriorityQueue<Character>());
            }
            map.get(head).add(s.charAt(i));
        }
                             
        return map;
    }

    private static int findRoot(int[] root, int i) {
        if (root[i] == i) return i;
        int r = findRoot(root, root[i]);
        root[i] = r;
        return r;
    }
    
    private static void union(int[] root, int src, int dst) {
        int srcRoot = findRoot(root, src);
        int dstRoot = findRoot(root, dst);
        if (srcRoot != dstRoot) root[srcRoot] = dstRoot;
    }

}
