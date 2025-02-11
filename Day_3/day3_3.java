/*Mr. Param is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found. 

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.

Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid

Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.
*/

import java.util.*;
public class Sol{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int c = a.length();
        StringBuilder sb = new StringBuilder(a);
        for(int i=0;i<a.length();i++){
            for(int j=i+1;j<a.length();j++){
            if(palindrome(sb.substring(i,j+1))){
                c+=1;
            }
        }
        }
        System.out.println(c);
    }
    
    public static boolean palindrome(String a){
        char[] c = a.toCharArray();
        boolean f = false;
        for(int i=0;i<c.length;i++){
            if(c[i]==c[c.length-i-1]) f=true;
            else return false;
        }
        return f;
    }
}