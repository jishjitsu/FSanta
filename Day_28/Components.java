import java.util.*;
public class Components {
    public static void DFS(int node, List<List<Integer>> list, boolean[] visited){
        visited[node] = true; 
        for(int i=0; i<list.get(node).size(); i++){
            int child = list.get(node).get(i); 
            if(!visited[child]){
                DFS(child, list, visited); 
            }
        }
    }
    public static void Connected(List<List<Integer>> list, int V) {
        boolean[] visited = new boolean[V]; 
        int count = 0; 
        for(int i=0; i<V; i++){
            if(!visited[i]){
                DFS(i, list, visited); 
                count++; 
            }
        }
        System.out.println(count); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        int V = sc.nextInt(); 
        int E = sc.nextInt(); 
        
        for(int i=0 ; i<V; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt(); 
            list.get(u).add(v); 
            list.get(v).add(u); 
        }

        Connected(list, V);
    }
}