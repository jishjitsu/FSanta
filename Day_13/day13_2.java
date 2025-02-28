/*In the quiet village of Alpha, every letter of the alphabet has a twin, except one. 
The letters live happily, always paired with their twins for every village activity. 
However, one letter finds itself always alone, never having a twin to share experiences with. 
This lone letter often watches from the sidelines, its uniqueness unbeknownst to the others. 
As the village prepares for the grand Annual Twin Parade, where each letter pairs up with its twin, 
the lone letter s absence from the lineup catches the eye of the wise old Owl, the village storyteller.

Help the Owl, to determine which letter in the village of Alpha is without a twin. 

Input:  A line of text representing the list of letters participating in the parade, where every letter appears twice except for one. 
Each letter is separated by a space.
Output:
The letter that is uniquely without a twin in the village of Alpha.

Constraints:
The string of letters will be between 1 and 1000 characters long.
There will always be exactly one unique letter that does not repeat.

Note-Dont Use HashMap/HashTable
Print -1 if no such unique letter exists 

All inputs are lowercase English letters.
Input = a b c d e f g h i j k l m n o p q r s t u v w x y z a b c e f g h i j k l m n o p q r s t u v w x y z
Output = d


 */

 import java.util.*;
public class day13_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        char[] ch = new char[s.length];
        for(int i=0;i<s.length;i++){
            ch[i] = s[i].charAt(0);
        }
        char a = ch[0]; 
        for(int i=1; i<ch.length ;i++){
            a ^= ch[i];
        }
        System.out.println(a);
        if(a=='\0') System.out.println(-1);
    }
}