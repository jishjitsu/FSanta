/*In a school, the students are given an array of strings words[]. Students have 
to find the longest string in words[] such that every prefix of it is also in words.

For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" 
has prefixes "ap","app","appl" and "a", all of which are in words.

Your task is the find and return the longest string in words as described above.

If there is more than one string with the same length, return the lexicographically
smallest one, and if no string exists, return "".

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
----------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


Sample Input-2:
---------------
t tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.
However, "tupla" is lexicographically smaller, so we return that.


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""

*/
import java.util.*;

class trieHelper 
{
    Trie root = new Trie();
    String res = "";
    public String longestWord(String[] words) 
    {
        for (String word : words)
            addWord(word);
        
        for (String word : words) 
            searchPrefix(word);
        
        return res;
    }
    
    private void searchPrefix(String word) 
    {
        Trie curr = root;
        boolean allPrefixesExist = true;
        
        // Check if all prefixes of the word exist in the trie
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children[c - 'a'];
            
            // If any prefix is not marked as a word, then not all prefixes exist
            if (!curr.isWord) {
                allPrefixesExist = false;
                break;
            }
        }
        
        // Update result if this word has all prefixes and is either longer or
        // same length but lexicographically smaller
        if (allPrefixesExist && (word.length() > res.length() || 
            (word.length() == res.length() && word.compareTo(res) < 0))) {
            res = word;
        }
    }
    
    private void addWord(String word) 
    {
        Trie curr = root;
        
        // Add each character of the word to the trie
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        
        // Mark the end of word
        curr.isWord = true;
    }
}

class Trie 
{
    Trie[] children = new Trie[26];
    boolean isWord;
}

class LongestWord
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String arr[]=sc.nextLine().split(" ");
        System.out.println(new trieHelper().longestWord(arr));
    }
}