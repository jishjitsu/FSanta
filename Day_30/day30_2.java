/*A group of researchers is analyzing satellite imagery of agricultural fields, 
represented by a grid of land sections. Each section is marked either as 
fertile (1) or infertile (0). To efficiently plan crop planting, the researchers 
need to identify the largest rectangular area consisting exclusively of fertile 
land sections.

Given a binary grid representing the land (1 for fertile and 0 for infertile), 
your task is to compute the area of the largest rectangle consisting entirely 
of fertile land sections.

Input Format:
-------------
Line-1: Two integers rows(r) and columns(c) of grid.
Next r lines: c space separated integers, each row of the grid.

Output Format:
--------------
Print an integer, area of the largest rectangle consisting entirely of fertile land sections.

Example:
--------
input=
4 5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

output=
6
 */

import java.util.*;

public class day30_2{
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static int maximalRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();

        System.out.println(maximalRectangle(matrix));
    }
}
