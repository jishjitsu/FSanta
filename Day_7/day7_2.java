/*Amazon fire tv stick keyboard wanted to be operated on number pad. 
You will be given the below pad. 
You are supposed to print all possible words in alphabetic order for a given number (0-9)

	1		2		3
		   abc	  def
		 
	4		5		6
   ghi     jkl    mno
  
	7		8		9
  pqrs     tuv   wxyz
	
	*		0		#


You will be given a string S which contains (2-9)  only  
For example: S = "3", then the possible words are "d", "e", "f".

Input Format:
-------------
String(2-9)

Output Format:
--------------
Print the list of words in alphabetical order


Sample Input-1:
---------------
2

Sample Output-1:
----------------
a b c


Sample Input-2:
---------------
24

Sample Output-2:
----------------
ag ah ai bg bh bi cg ch ci
 */
import java.util.*;

public class day7_2{
    static final String[] KEYPAD = {
        "",     
        "",     
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs",
        "tuv",  
        "wxyz"  
    };

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> result = new ArrayList<>();
        
        if (input.isEmpty()){
            System.out.println();
            return;
        }
        
        words(input, 0, "", result);
        Collections.sort(result);
        for (String word : result){
            System.out.print(word + " ");
        }
    }
    
    public static void words(String digits, int index, String current, List<String> result){
        if (index == digits.length()){
            result.add(current);
            return;
        }
        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()){
            words(digits, index + 1, current + letter, result);
        }
    }
}