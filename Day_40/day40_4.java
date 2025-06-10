/*Write a function that will retum the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string. 
The input string can be assumed to contain only alphabets (both uppercase and lowercase) 
and numeric digits.

example
input=aA112
output=2 */

import java.util.*;

public class day40_4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> m = new HashMap<>();
        String s = sc.next();
        
        s=s.toLowerCase();
        
        for(int i=0; i<s.length(); i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        
        int ret = 0;
        
        for(Character c: m.keySet()){
            if(m.get(c)>1) ret++;
        }
        
        System.out.println(ret);
    }
}