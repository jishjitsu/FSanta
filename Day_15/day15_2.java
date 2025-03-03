/*The Smallest Number Challenge

Shyam a third class boyt has been given a large number, he can remove a few digits to make it as small as possible. 

The goal is to carefully choose which digits to remove so that the remaining number is the smallest possible.

You must remove exactly k digits.
The final number cannot have unnecessary leading zeros (unless it becomes "0").
If removing k digits removes all the digits, the result should simply be "0".
Can you figure out the best way to help shyam to  remove the digits and get the smallest possible number?
If the result is an empty string, return 0 instead.


input = 1432219  
3  
output =1219

Explanation:
By removing the digits 4, 3, and 2, the smallest possible number is 1219


Input=10200 
1  
Output=200

Explanation:
Removing "1" results in "0200", which simplifies to "200" after removing the leading zero.


Input="10"  
2  
Output=0

Explanation:
All digits are removed, so the result is "0"
*/
import java.util.*;
class File{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();
        System.out.println(removekDigits(n,k));
    }    
        public static String removekDigits(String n,int k){
            if(k >= n.length()){
                return "0";
            }
            Stack<Character> stack = new Stack<>();
            for(char digit:n.toCharArray()){
                while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }
            while(k>0 && !stack.isEmpty()){
                stack.pop();
                k--;
            }
            StringBuilder result = new StringBuilder();
            for(char digit:stack){
                result.append(digit);
            }
            while(result.length() > 0 && result.charAt(0) == '0'){
                result.deleteCharAt(0);
            }
            return result.length() == 0 ? "0":result.toString();
        }

}