/*Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

Pranav wants to find out the number of empty spaces which are completely 
surrounded by the square boxes (left, right, top, bottom) in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of empty groups surrounded by
the boxes in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in Layout.
Next M lines: contains N space-separated either 0 or 1.

Output Format:
--------------
Print an integer, the number of fully trapped air pockets in the layout.

Sample Input-1:
---------------
6 7
1 1 1 1 0 0 1
1 0 0 0 1 1 0
1 0 0 0 1 1 0
0 1 1 1 0 1 0
1 1 1 0 0 1 1
1 1 1 1 1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
The 2 empty groups are as follows:
1st group starts at cell(1,1), 2nd group starts at cell(3,4).
The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)
are not valid empty groups, because they are not completely surrounded by boxes.


Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
1

Explanation:
------------
The only empty group starts at cell(1,1) is surrounded by boxes.

 */

import java.util.*;

public class day31_1 {

    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] grid = new int[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            if (grid[i][0] == 0 && !visited[i][0]) dfs(grid, visited, i, 0, M, N);
            if (grid[i][N-1] == 0 && !visited[i][N-1]) dfs(grid, visited, i, N-1, M, N);
        }

        for (int j = 0; j < N; j++) {
            if (grid[0][j] == 0 && !visited[0][j]) dfs(grid, visited, 0, j, M, N);
            if (grid[M-1][j] == 0 && !visited[M-1][j]) dfs(grid, visited, M-1, j, M, N);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(grid, visited, i, j, M, N);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int[][] grid, boolean[][] visited, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 1 || visited[i][j])
            return;

        visited[i][j] = true;

        for (int[] dir : directions) {
            dfs(grid, visited, i + dir[0], j + dir[1], M, N);
        }
    }
}
