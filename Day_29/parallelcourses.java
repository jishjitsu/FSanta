/*/*Parallel Courses: 
 
➢ You are given an integer N which denotes the number of courses numbered from 1 to N and a 
matrix ‘prerequisites’, in which each row contains exactly two integers ‘A’ and ‘B’ which 
represents the course ‘A’ has to be studied in some semester before studying course ‘B’. 
➢ In one semester, you can take at most k courses as long as you have taken all the prerequisites 
in the previous semesters for the courses you are taking. 
➢ You are supposed to find the minimum number of semesters required to study all the courses. 
If it is impossible to study all the courses, then return -1. 
Note: 
There is a limit on taking the number of courses in a particular semester as long as all the prerequisites 
for taking the course are satisfied. 
Input Format: 
➢ The first line represents N, which denotes the number of courses 
➢ The second line represents M, which denotes the number of rows of the matrix prerequisites. 
➢ The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], denoting that prerequisites[i][0] has to be studied before prerequisites[i][1]. 
➢ Last line k, denotes number of courses can be taken in a semester. 
 
Output Format: 
➢ Print the minimum number of semesters required to study all the courses. 
 
Input: n = 4,  
m = 3 
prerequisites =  
2 1 
3 1 
1 4 
k = 2 
Output: 3 
Explanation:  
In the first semester, you can take courses 2 and 3. 
In the second semester, you can take course 1. 
In the third semester, you can take course 4. 
 

Sample Test Case-1: 
Input = 4 
3 
2 1 
3 1 
4 1 
2       
Output: 3 
 
Sample Test Case-2: 
Input = 4 
3 
1 3 
2 3 
3 1 
3 
Output: -1 

For all Boundary Conditions Print -1

Constraints: 
1<= T <= 50 
1 <= N <= 20000 
0 <= M <= 20000 
1 <= prerequisites[i][0], prerequisites[i][1] <= N 
Prerequisites[i][0] != prerequisites[i][1], for any valid i 
*/

import java.util.*;

public class parallelcourses {

    public static void para(List<List<Integer>> graph, int V, int k) {
        int[] indegree = new int[V + 1];
        for (int u = 1; u <= V; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int semester = 0;
        int completed = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            int take = Math.min(sz, k);
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < take; i++) {
                int course = queue.poll();
                completed++;
                for (int next : graph.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        temp.add(next);
                    }
                }
            }

            queue.addAll(temp);
            semester++;
        }

        if (completed != V) {
            System.out.println(-1);
        } else {
            System.out.println(semester);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        int k = sc.nextInt();
        para(graph, V, k);
    }
}
