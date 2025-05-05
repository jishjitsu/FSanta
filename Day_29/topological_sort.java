/*given a graph(V) and N Edges print the Topolical Order of the Graph



The first line of input contains the Number of Vertices followed by the Number of Edges and Edges between the Vertices 

input = 
5 7
0 2
0 3
1 0
1 3
2 4
3 2
3 4
output = 
1 0 3 2 4
 */
import java.util.*;

public class topological_sort{
    
    public static void tsort(List<List<Integer>> l, int V){
      int indegree[] = new int[V]; 
      for (int i = 0; i < V; i++){
       for (int node : l.get(i)) 
           indegree[node]++; 
      } 
     
      Queue<Integer> q = new LinkedList<Integer>(); 
      for (int i = 0; i < V; i++) { 
       if (indegree[i] == 0) 
        q.add(i); 
      } 
     
      int cnt = 0; 
     
      List<Integer> topOrder = new ArrayList<Integer>(); 
      while (!q.isEmpty()) { 
       int u = q.poll(); 
       topOrder.add(u); 
       for (int node : l.get(u))  { 
        if (--indegree[node] == 0) 
         q.add(node); 
       } 
       cnt++; 
      } 
      if (cnt != V) { 
       return; 
      } 
     
      for (int i : topOrder)  
       System.out.print(i + " "); 
    } 
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        List<List<Integer>> l = new ArrayList<>();
        
        for(int i=0 ; i<V; i++){
            l.add(new ArrayList<>());
        }
        
        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            l.get(u).add(v);
        }
        
        tsort(l, V);
    }
}