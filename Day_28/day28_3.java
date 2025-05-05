/*In an undirected graph, a bridge (also known as a cut-edge) is an edge that, when removed, increases the number of connected components in the graph. 
In other words, removing a bridge disconnects part of the graph.

You are given an undirected graph with V vertices and E edges.
Your task is to identify and print all the bridges in the graph using Depth-First Search (DFS).

Input Format:
------------
- The first line contains two integers V and E — the number of vertices and edges.
- The next E lines each contain two integers u and v, denoting an undirected edge between vertex u and vertex v.

Output Format:
--------------
- Print the edges that are bridges in the graph.
- Each bridge should be printed as a pair of vertices: u v.
- If there are no bridges, the output should be empty.
- Order of output does not matter.

Constraints:
-------------
- 1≤ V ≤10000 
- 0≤ E ≤100000 
- 0≤ u,v <V
- The graph may be disconnected.
- No multiple edges or self-loops.

Example Input 1:
----------------
5 5
1 0
0 2
2 1
0 3
3 4

Example Output 1:
----------------
3 4
0 3

Explanation:
-------------
Removing edge 3 4 disconnects node 4. Similarly, removing edge 0 3 disconnects node 3. These are bridges.
However, edges like 1 0, 0 2, and 2 1 are not bridges because there are alternative paths to maintain connectivity.

Note:
-----
- The program uses Tarjan’s Algorithm for bridge detection, which uses discovery times and low values during DFS traversal.
- The edge list in the output does not need to be sorted.
 */
