/*In the village of Alphaville, where the houses are arranged in a grid pattern like a big crossword puzzle,
the local children love playing a game called "Word Hunt." 

In this game, a 2D grid is drawn on the ground, each cell filled with a single English letter. 

The goal is to find specific words in the grid that can be formed by connecting letters horizontally or vertically. 
Words can be read left to right, right to left, top to bottom, or bottom to top.

One sunny day, the children decide to challenge you to this game. 
They provide you with a grid filled with letters and a word to find. 

Your task is to determine if the word exists anywhere in the grid 
according to the game's rules.

Test Case 1
Input = 3 4
a b c s 
s f c e 
a d e e 
see
output = true

Test Case 2
Input = 4 4 
x y z t 
w x y z 
p q r t 
z o o z 
zoom
output = false */

//Graph Question
import java.util.*;

class day13_3 {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, rows, cols)) return true;
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] board, String word, int index, int r, int c, int rows, int cols) {
        if (index == word.length()) return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(index)) return false;
        
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, word, index + 1, r + 1, c, rows, cols) ||
                        dfs(board, word, index + 1, r - 1, c, rows, cols) ||
                        dfs(board, word, index + 1, r, c + 1, rows, cols) ||
                        dfs(board, word, index + 1, r, c - 1, rows, cols);
        board[r][c] = temp;
        return found;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        System.out.println(exist(board, word));
    }
}