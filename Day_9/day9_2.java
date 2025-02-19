/*Given a string s and an abbreviation abbr, determine whether abbr correctly 
represents s by following the abbreviation rules.

A valid abbreviation replaces consecutive characters in s with a number 
representing the count of omitted characters while maintaining the sequence of the 
remaining letters.

For instance, the string "word" can be abbreviated in the following valid ways:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Any abbreviation that deviates from this pattern is considered invalid.

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).
 */

 import java.util.*;

 public class day9_2{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         String s = sc.nextLine();
         String s1 = sc.nextLine();
         
         char[] c = s1.toCharArray();
         
         List<Character> l= Arrays.asList('0','1','2','3','4','5','6','7','8','9');
         
         int p=0;
         
         boolean flag = true;
         
         for(int i=0; i<c.length-1;i++){
             StringBuilder sb = new StringBuilder();
             if(p<c.length && (c[p]==c[i])) flag=false;
             for(int j=i+1;j<c.length;j++){
                 if(l.contains(c[j])){
                 sb.append(c[j]);
                 }
                 else{
                     break;
                 }
             }
             if(sb.length()!=0) p += Integer.parseInt(sb.toString());
         }
         
         System.out.println(flag);
     }
 }