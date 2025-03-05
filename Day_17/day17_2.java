/*Mystic Energy Number

In an ancient civilization, numbers were believed to carry mystical energy. 
A number is considered blessed if repeatedly replacing it with the sum of the squares of its digits eventually results in 1. 
However, if it falls into a never-ending cycle that does not include 1, it is considered cursed.

Input
An integer num (1 ≤ num ≤ 10⁶).
Output
Print "Blessed Number" if the number eventually reaches 1.
Otherwise, print "Cursed Number".


Example
Input = 23  
Output = Blessed Number

(Explanation: 23 → 2² + 3² = 13 → 1² + 3² = 10 → 1² + 0² = 1, so it is a Blessed Number.)

Input = 25  
Output = Cursed Number
(Explanation: 25 falls into a cycle and does not reach 1.)



 */

 import java.util.*;

public class day17_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        happy(a);
    }
    
    static void happy(int a){
        if(a==1 || a==9){
            System.out.println("Blessed number");
            return;
        }
        if(a==4 || a==2){
            System.out.println("Cursed number");
            return;
        }
        int sum = 0;
        while(a>0){
            sum+=(power(a%10));
            a = a/10;
        }
        happy(sum);
    }
    
    static int power(int a){
        return a*a;
    }
}