/*Hulk and Thor become best friends now. 
Hulk lives in the P-th house while Thor lives in the N-th house. 
Hulk has decided to meet Thor every day. After going for many days, 
he notices that there are few streets such that he passes every time 
he goes to meet Thor, no matter which path he takes.

You have been given a grid of N houses in the form of undirected graph. 
Houses are numbered from 1 to N.
For each I-th query, you have been given P (Hulk's house). 
You have to say how many streets are there which he encounters in every path 
he takes to go from P to N. If there is no such street, print "-1".
Also, note P can be equal to N.

Input Format:
-------------
Line-1: Two space separated integers N and M, Number of houses, number of streets.
Next M lines: contain two space-separated integers u and v, 
		denoting a street between house-u and house-v.
Next line: contains an integer P.

Output Format:
--------------
Print an integer, number of streets in that path.


Sample Input-1:
---------------
4 3
1 2
1 3
2 4
1

Sample Output-1:
----------------
2

Explanation:
------------
There is only one path 1->2->4. so answer = 2


Sample Input-2:
---------------
4 3
1 2
1 3
2 4
4

Sample Output-2:
----------------
-1

Explanation:
------------
There is no path as they both live in the same house 4.
So answer = -1.

 */
import java.util.*;

public class day30_1 {
    static int time = 0;
    static List<List<Integer>> graph;
    static List<int[]> bridges;
    static int[] tin, low;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int P = sc.nextInt();
        int T = N;

        if (P == T) {
            System.out.println(-1);
            return;
        }

        bridges = new ArrayList<>();
        time = 0;
        tin = new int[N + 1];
        low = new int[N + 1];
        visited = new boolean[N + 1];

        DFS(1, -1);

        Map<Integer, List<Integer>> bridgeGraph = new HashMap<>();
        for (int[] bridge : bridges) {
            int u = bridge[0], v = bridge[1];
            bridgeGraph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            bridgeGraph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        visited = new boolean[N + 1];
        List<int[]> path = new ArrayList<>();
        if (!Path(P, T, bridgeGraph, visited, path)) {
            System.out.println(-1);
        } else {
            System.out.println(path.size());
        }
    }

    static void DFS(int u, int parent) {
        visited[u] = true;
        tin[u] = low[u] = time++;

        for (int v : graph.get(u)) {
            if (v == parent) continue;
            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                DFS(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > tin[u]) {
                    bridges.add(new int[]{u, v});
                }
            }
        }
    }

    static boolean Path(int u, int target, Map<Integer, List<Integer>> bGraph, boolean[] visited, List<int[]> path) {
        if (u == target) return true;
        visited[u] = true;

        if (!bGraph.containsKey(u)) return false;

        for (int v : bGraph.get(u)) {
            if (!visited[v]) {
                path.add(new int[]{u, v});
                if (Path(v, target, bGraph, visited, path)) return true;
                path.remove(path.size() - 1); // backtrack
            }
        }
        return false;
    }
}
