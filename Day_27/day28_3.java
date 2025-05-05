/*You are given a completed 4x4 Sudoku board. Your task is to write a program that determines whether the board is valid.

A valid 4x4 Sudoku board must meet the following conditions:

1. Each row must contain all the numbers from 1 to 4 exactly once.
2. Each column must contain all the numbers from 1 to 4 exactly once.
3. Each of the four 2x2 subgrids (top-left, top-right, bottom-left, bottom-right) must contain all the numbers from 1 to 4 exactly once.

Input
-----
- The program should read 16 integers from the standard input.
- These integers represent the 4x4 Sudoku board in row-major order (i.e., row by row).
- Each integer should be between 1 and 4 (inclusive).

Output
------
- Output `true` if the Sudoku board is valid.
- Output `false` otherwise.



Example-1:
----------
Input:

1 2 3 4
3 4 1 2
2 1 4 3
4 3 2 1


Output
-------
true


Example-2
---------
Input :

1 2 3 4
3 4 1 2
2 1 1 3
4 3 2 1


Output
------
false */

import java.util.*;

public class day28_3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        boolean isValid = isSudoku(board);
        System.out.println(isValid);
    }

    private static boolean isSudoku(int[][] board) {
        for (int i = 0; i < 4; i++) {
            if (!isSet(board[i])) return false;

            int[] column = new int[4];
            for (int j = 0; j < 4; j++) {
                column[j] = board[j][i];
            }
            if (!isSet(column)) return false;
        }

        int[][] starts = {{0,0}, {0,2}, {2,0}, {2,2}};
        for (int[] start : starts) {
            if (!isValid(board, start[0], start[1])) return false;
        }

        return true;
    }

    private static boolean isSet(int[] nums) {
        boolean[] seen = new boolean[5];
        for (int num : nums) {
            if (num < 1 || num > 4 || seen[num]) return false;
            seen[num] = true;
        }
        return true;
    }

    private static boolean isValid(int[][] board, int rowStart, int colStart) {
        boolean[] seen = new boolean[5];
        for (int i = rowStart; i < rowStart + 2; i++) {
            for (int j = colStart; j < colStart + 2; j++) {
                int num = board[i][j];
                if (num < 1 || num > 4 || seen[num]) return false;
                seen[num] = true;
            }
        }
        return true;
    }
}
