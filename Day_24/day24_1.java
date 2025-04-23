/*In the mystical land of Factorial Forest,a wise old wizard named Algebraon is preparing a powerful
potion.To brew it successfully, he needs to gather a very specific quantity of magical powder called
"Prime Dust."

The Prime Dust is extracted from the factorial of a number, written as n!. 
However, only a particular prime number p is used to make this dust. 
Algebraon needs to know exactly how many complete units of Prime Dust he can extract from n!.

In simpler terms, he wants to know:
What is the largest number x such that p^x (p raised to the power x) divides n! perfectly, 
without leaving any remainder?

Can you help Algebraon figure out the correct amount of Prime Dust for his potion?

Input:
-------
The first line contains two space-separated integers, n and p.

n (1 ≤ n ≤ 10⁶) — the number for which factorial is to be considered.

p (2 ≤ p ≤ n) — a prime number, representing the ingredient for the potion.

Output:
-------
Print a single integer — the largest power x such that p^x divides n!.

Example 1:
----------
Input:
------
7 3

Output:
--------
2
check hint for explanation


Example 2:
----------
Input:
-------
10 3

Output:
-------
4
 */
import java.util.*;

public class day24_1{
    public static int poof(int n, int p){
        int c=0;
        long power = p;
        
        while(power<=n){
            c+=n/power;
            power*=p;
        }
        
        return c;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(poof(a,p));
    }
}