/*Given an undirected, connected graph, identify all articulation points in the graph.

An articulation point (or cut vertex) is a vertex that, when removed along with its associated edges, 
increases the number of connected components in the graph. These vertices are critical for maintaining the connectivity of the graph.

Input Format:
------------
- The first line contains two integers V and E — the number of vertices and edges in the graph.
- The next E lines contain two integers u and v — representing an undirected edge between vertex u and vertex v.
Vertices are numbered from 0 to V - 1.

Output Format:
--------------
- Print a list of articulation points in increasing order.ā
- If there are no articulation points, print an empty list [].

Constraints:
-------------
- 1≤ V ≤10^4
- 0≤ E ≤10^5
- No self-loops or multiple edges.

Example Input 1:
----------------
5 5
1 0
0 2
2 1
0 3
3 4

Example Output 1:
------------------
[0, 3]

Explanation: 
-------------
Removing vertex 0 disconnects 3 and 4 from the rest of the graph.  
Removing 3 disconnects 4. So both are articulation points.

Example Input 2:
-----------------
4 3
0 1
1 2
2 3

Example Output 2:
-----------------
[1, 2]

Notes:
-------
- The graph may contain multiple components.
- The result should be based on DFS traversal using Tarjan’s algorithm for finding articulation points efficiently.
*/

