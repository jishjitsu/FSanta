/*Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n-1 .
Return the minimum number of operations needed for n to become 1.

Example 1:
Input:8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:
Input:7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
 */
import java.util.*;

public class day21_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(minop(a,0));
    }
    
    static int minop(int a, int c){
        if(a==1) return c;
        if(a%2==0) return minop(a/2,c+1);
        return Math.min(minop(a+1,c+1),minop(a-1,c+1));
    }
}