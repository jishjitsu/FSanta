/*You are given some tokens printed with unique numbers on it and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If you cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1
 */

 import java.util.*;

 public class day42_2 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String[] tokensStr = sc.nextLine().split(" ");
         int T = sc.nextInt();
         
         int[] tokens = Arrays.stream(tokensStr).mapToInt(Integer::parseInt).toArray();
         System.out.println(minTokens(tokens, T));
     }
     
     static int minTokens(int[] tokens, int T) {
         int[] dp = new int[T + 1];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0;
         
         for (int token : tokens) {
             for (int j = token; j <= T; j++) {
                 if (dp[j - token] != Integer.MAX_VALUE) {
                     dp[j] = Math.min(dp[j], dp[j - token] + 1);
                 }
             }
         }
         
         return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
     }
 }