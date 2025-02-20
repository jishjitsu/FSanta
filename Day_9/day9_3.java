/*Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */

 import java.util.*;
public class day9_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        StringBuilder found = new StringBuilder();
        
        char[] ret = a.toCharArray();
        
        for(char c: a.toCharArray()){
            if(vowels.contains(c)){
                found.append(c);
            }
        }
        
        if(found.length()<=1){
            System.out.println(a);
            return;
        }
        
        int c=found.length()-1;
    
        for(int i=0;i<ret.length;i++){
            if(c<0) break;
            if(vowels.contains(ret[i])){
                ret[i] = found.charAt(c);
                c--;
            }
        }
        
        System.out.println(new String (ret));
    
        
    }
}