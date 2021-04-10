/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	
	public static void main(String[] args) {
	    Graph g = new Graph();
	    g.createAdjacenyList("START","A", 5);
	    g.createAdjacenyList("START","B",6);
	    g.createAdjacenyList("START","C", 10);
	    g.createAdjacenyList("A","D",4);
	    g.createAdjacenyList("B","D",5);
	    g.createAdjacenyList("C","D",6);
	    g.createAdjacenyList("C","E",24);
	    g.createAdjacenyList("D","F",3);
	    g.createAdjacenyList("E","F",1);
	    g.createAdjacenyList("F","END_1",5);
	    g.createAdjacenyList("F","END_2",10);
	    
	    Map<String, Integer> points = new HashMap<String, Integer>();
	    points.put("START",0);
	    points.put("A",24);
	    points.put("B",3);
	    points.put("C",10);
	    points.put("D",7);
	    points.put("E",24);
	    points.put("F",3);
	    points.put("END_1",4);
	    points.put("END_2",7);
	    
	    g.printGraph();
	    g.dijkstra(points);
	}
	
	static class Edge {
        String source;
        String destination;
        int weight;

        public Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
	
	static class Graph {
	    
	    Map<String, ArrayList<Edge>> graphMap = new LinkedHashMap<String, ArrayList<Edge>>(); 
	    
	    public void createAdjacenyList(String u, String v, int w) {
	        Edge edge = new Edge(u, v, w);
    	    if(graphMap.containsKey(u)) {
    	        ArrayList<Edge> val = graphMap.get(u);
    	        val.add(edge);
    	    } else {
    	        ArrayList<Edge> newEntry = new ArrayList<Edge>();
    	        newEntry.add(edge);
    	        graphMap.put(u, newEntry);
    	    }
	   }
	   
	   public void dijkstra()
	   
	   public void printGraph(){
            for(Map.Entry m:graphMap.entrySet()){  
                System.out.print(m.getKey() + "[");
                ArrayList<Edge> val = (ArrayList) m.getValue();
                for (int i = 0; i < val.size(); i++) 
                    System.out.print(val.get(i).destination + "-" + val.get(i).weight + " ");
                System.out.print("]");
                System.out.println();
            }  
        }
	}
	
}
